package MeetingScheduler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MeetingScheduler {
    private final ConcurrentHashMap<Integer, ArrayList<Meeting>> roomIdVsListOfMeetings = new ConcurrentHashMap<>();


    public MeetingScheduler(List<Room> rooms) {
        for (Room room : rooms) {
            roomIdVsListOfMeetings.putIfAbsent(room.getId(),new ArrayList<Meeting>());
        }
    }


    public boolean scheduleMeeting(Meeting meeting) {

        if(!roomIdVsListOfMeetings.containsKey(meeting.getRoomId())) {
            System.out.println("Invalid Room Id");
            return false;
        }


        // Check if room is free for the meeting
        if (!isRoomAvailable(meeting.getRoomId(), meeting.getStart(), meeting.getEnd())) {
            System.out.println("Room " + meeting.getRoomId() + " is not available.");
            return false;
        }

        ArrayList<Meeting> meetingArrayList = roomIdVsListOfMeetings.get(meeting.getRoomId());

        synchronized (meetingArrayList) {
            meetingArrayList.add(meeting);
        }

        System.out.println("Meeting '" + meeting.getTitle() + "' scheduled successfully.");
        return true;
    }


    public boolean isRoomAvailable(int roomId, LocalDateTime start, LocalDateTime end) {
        List<Meeting> meetings = roomIdVsListOfMeetings.get(roomId);

        synchronized (meetings) {
            for (Meeting m : meetings) {
                if (m.getStart().isBefore(end) && m.getEnd().isAfter(start)) {
                    return false; // Room busy
                }
            }
        }
        return true;
    }

    public ArrayList<Integer> getAvailableRooms(LocalDateTime start, LocalDateTime end) {
        ArrayList<Integer> availableRooms = new ArrayList<>();

        for (Map.Entry<Integer, ArrayList<Meeting>> entry : roomIdVsListOfMeetings.entrySet()) {
            List<Meeting> meetings = entry.getValue();

            boolean isRoomFree = true;

            synchronized (meetings) {
                for (Meeting m : meetings) {
                    if (m.getStart().isBefore(end) && m.getEnd().isAfter(start)) {
                        isRoomFree = false;
                        break;
                    }
                }
            }

            if (isRoomFree) {
                availableRooms.add(entry.getKey());
            }
        }
        return availableRooms;
    }

}
