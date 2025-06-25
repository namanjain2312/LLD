package MeetingScheduler;

import java.time.LocalDateTime;
import java.util.List;

public class Meeting {
    private  int id;
    private  String title;
    private  LocalDateTime start;
    private  LocalDateTime end;
    private  User organizer;
    private  List<User> attendees;
    private int roomId;

    public Meeting(int id,String title, LocalDateTime start, LocalDateTime end, int roomId ,User organizer, List<User> attendees) {
        this.id = id;
        this.title = title;
        this.start = start;
        this.end = end;
        this.organizer = organizer;
        this.attendees = attendees;
        this.roomId = roomId;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public List<User> getAttendees() {
        return attendees;
    }

    public String getTitle() {
        return title;
    }

    public User getOrganizer() {
        return organizer;
    }

    public int getId() {
        return id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }

    public void setAttendees(List<User> attendees) {
        this.attendees = attendees;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

}