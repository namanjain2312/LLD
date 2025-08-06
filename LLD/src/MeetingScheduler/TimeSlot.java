package MeetingScheduler;

import java.time.LocalTime;

public class TimeSlot {
    private final LocalTime start;
    private final LocalTime end;

    public TimeSlot(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    public boolean overlaps(TimeSlot other) {
        return this.start.isBefore(other.end) && this.end.isAfter(other.start);//main condition for overlapping
    }

    public LocalTime getStart() { return start; }
    public LocalTime getEnd() { return end; }
}
