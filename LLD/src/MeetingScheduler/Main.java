package MeetingScheduler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Room room1 = new Room(101,"Room1",3);
        Room room2 = new Room(102,"Room2",5);
        Room room3 = new Room(103,"Room3",10);

        ArrayList<Room> roomList = new ArrayList<>();
        ArrayList<Integer> roomIdList = new ArrayList<>();
        roomList.add(room1);
        roomIdList.add(101);
        roomIdList.add(102);
        roomIdList.add(103);
        roomList.add(room2);
        roomList.add(room3);




        MeetingScheduler scheduler = new MeetingScheduler(roomList);

        User alice = new User("Alice",1);
        User bob = new User("Bob",2);
        User charles = new User("Charles",3);
        User naman = new User("Naman" , 4);

        LocalDateTime start = LocalDateTime.of(2025, 6, 10, 10, 0);
        LocalDateTime end = LocalDateTime.of(2025,6,10,11,0);




        System.out.println("Get Free Meeting Rooms Between Start : " + start.toString() + " and End : " + end.toString());

        roomIdList = scheduler.getAvailableRooms(start,end);
        for(Integer r : roomIdList)
            System.out.println("Room Id : " + r);

        Meeting meeting1 = new Meeting(1,"Team Sync",
                start,
                end,
                101,
                alice,
                Arrays.asList(alice, bob)
        );

        scheduler.scheduleMeeting(meeting1);

        System.out.println("Get Free Meeting Rooms Between Start : " + start.toString() + " and End : " + end.toString());

        roomIdList = scheduler.getAvailableRooms(start,end);
        for(Integer r : roomIdList)
            System.out.println("Room Id : " + r);

        Meeting meeting2 = new Meeting(2,"Client Call",
                start,
                end,
                101,
                charles,
                Arrays.asList(naman,charles)
        );

        scheduler.scheduleMeeting(meeting2); // should detect conflict

        System.out.println("Get Free Meeting Rooms Between Start : " + start.toString() + " and End : " + end.toString());

        roomIdList = scheduler.getAvailableRooms(start,end);
        for(Integer r : roomIdList)
            System.out.println("Room Id : " + r);

        Meeting meeting3 = new Meeting(2,"Client Call",
                start,
                end,
                102,
                charles,
                Arrays.asList(naman,charles)
        );

        scheduler.scheduleMeeting(meeting3);

        System.out.println("Get Free Meeting Rooms Between Start : " + start.toString() + " and End : " + end.toString());

        roomIdList = scheduler.getAvailableRooms(start,end);
        for(Integer r : roomIdList)
            System.out.println("Room Id : " + r);

    }
}
