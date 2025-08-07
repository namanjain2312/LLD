package JobScheduler;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class PrintJob implements Job{

    private final String message;

    public PrintJob(String message) {
        this.message = message;
    }

    @Override
    public void execute() {
        System.out.println("Executing Job: " + message + " at " +  LocalDateTime.now());
    }

}
