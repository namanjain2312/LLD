package MeetingScheduler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        MeetingScheduler scheduler = new MeetingScheduler();

        // Create users
        User alice = new User("Alice", 1);
        User bob = new User("Bob", 2);
        User charlie = new User("Charlie", 3);


        MeetingRoom room1 = new MeetingRoom(1, "Small Room", 2);
        scheduler.addMeetingRoom(room1);

        // Schedule a valid meeting
        TimeSlot slot1 = new TimeSlot(LocalTime.of(10, 0), LocalTime.of(10, 30));
        Meeting meeting1 = scheduler.scheduleMeeting(slot1, room1, Arrays.asList(alice, bob));

        // Checking avilable slots
        List<TimeSlot> available = scheduler.getAvailableTimeSlots(Arrays.asList(alice, bob), room1,
                LocalTime.of(9, 0), LocalTime.of(17, 0));
        System.out.println("Available Slots:");
        for (TimeSlot ts : available) {
            System.out.println(ts.getStart() + " to " + ts.getEnd());
        }

        //Overlapping meeting in a meeting room
        TimeSlot slot2 = new TimeSlot(LocalTime.of(10, 0), LocalTime.of(10, 30));
        Meeting meeting2 = scheduler.scheduleMeeting(slot2, room1, Arrays.asList(charlie, alice));

        //Exceeding room capacity
        TimeSlot slot3 = new TimeSlot(LocalTime.of(11, 0), LocalTime.of(11, 30));
        Meeting meeting3 = scheduler.scheduleMeeting(slot3, room1, Arrays.asList(charlie, alice,bob));

        //Cancelling a meeting
        scheduler.cancelMeeting(meeting1);



    }
}