package MeetingScheduler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Meeting {
    private final UUID id;
    private final TimeSlot slot;
    private final MeetingRoom room;
    private final List<User> participants;

    public Meeting(TimeSlot slot, MeetingRoom room, List<User> participants) {
        this.id = UUID.randomUUID();
        this.slot = slot;
        this.room = room;
        this.participants = participants;
    }

    public UUID getId() { return id; }
    public TimeSlot getSlot() { return slot; }
    public MeetingRoom getRoom() { return room; }
    public List<User> getParticipants() { return participants; }
}