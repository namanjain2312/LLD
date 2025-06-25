package MeetingScheduler;

public class User {
    private final int id;
    private final String name;

    public User(String name,int id) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}