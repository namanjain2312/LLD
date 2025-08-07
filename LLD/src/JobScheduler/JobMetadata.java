package JobScheduler;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.ScheduledFuture;

public class JobMetadata {
    final int jobId;
    final ScheduledFuture<?> future;
    final Job job;
    final LocalDateTime scheduleTime;

    JobMetadata(int jobId, ScheduledFuture<?> future, Job job, LocalDateTime scheduleTime) {
        this.jobId = jobId;
        this.future = future;
        this.job = job;
        this.scheduleTime = scheduleTime;
    }

}
