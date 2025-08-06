package MeetingScheduler;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MeetingScheduler {
    private final Map<User, List<Meeting>> userMeetings = new ConcurrentHashMap<>();
    private final Map<MeetingRoom, List<Meeting>> roomMeetings = new ConcurrentHashMap<>();
    private final List<MeetingRoom> meetingRooms = new ArrayList<>();


    public void addMeetingRoom(MeetingRoom room) {
        meetingRooms.add(room);
        roomMeetings.putIfAbsent(room, new ArrayList<>());
    }


    public Meeting scheduleMeeting(TimeSlot slot, MeetingRoom room, List<User> participants) {

        if (participants.size() > room.getCapacity()) {
            System.out.println("Room capacity exceeded.");
            return null;
        }

        // Check room availability
        for (Meeting m : roomMeetings.get(room)) {
            if (m.getSlot().overlaps(slot)) {
                System.out.println("Room is not available at the given time.");
                return  null;
            }
        }

        // Check participants' availability
        for (User user : participants) {
            List<Meeting> meetings = userMeetings.getOrDefault(user, new ArrayList<>());
            for (Meeting m : meetings) {
                if (m.getSlot().overlaps(slot)) {
                    System.out.println("Participant " + user.getName() + " is not available.");
                    return null;
                }
            }
        }

        Meeting meeting = new Meeting(slot, room, participants);
        roomMeetings.get(room).add(meeting);
        for (User user : participants) {
            userMeetings.computeIfAbsent(user, k -> new ArrayList<>()).add(meeting);
        }

        // ✅ Success message
        System.out.println("✅ Meeting scheduled from " + slot.getStart() + " to " + slot.getEnd() +
                " in room '" + room.getName());

        return meeting;
    }

    public void cancelMeeting(Meeting meeting) {
        roomMeetings.get(meeting.getRoom()).remove(meeting);
        for (User user : meeting.getParticipants()) {
            userMeetings.get(user).remove(meeting);
        }

        // ✅ Cancellation message
        System.out.println("✅ Meeting from " + meeting.getSlot().getStart() + " to " + meeting.getSlot().getEnd()
                + " in room '" + meeting.getRoom().getName() + "' has been cancelled.");
    }

    public List<TimeSlot> getAvailableTimeSlots(List<User> users, MeetingRoom room, LocalTime dayStart, LocalTime dayEnd) {
        List<TimeSlot> availableSlots = new ArrayList<>();

        LocalTime time = dayStart;
        while (time.plusMinutes(30).compareTo(dayEnd) <= 0) {
            TimeSlot candidateSlot = new TimeSlot(time, time.plusMinutes(30));

            boolean isAvailable = true;

            for (Meeting m : roomMeetings.getOrDefault(room, Collections.emptyList())) {
                if (m.getSlot().overlaps(candidateSlot)) {
                    isAvailable = false;
                    break;
                }
            }

            if (isAvailable) {
                for (User user : users) {
                    for (Meeting m : userMeetings.getOrDefault(user, Collections.emptyList())) {
                        if (m.getSlot().overlaps(candidateSlot)) {
                            isAvailable = false;
                            break;
                        }
                    }
                    if (!isAvailable) break;
                }
            }

            if (isAvailable) {
                availableSlots.add(candidateSlot);
            }

            time = time.plusMinutes(30);
        }

        return availableSlots;
    }

}
