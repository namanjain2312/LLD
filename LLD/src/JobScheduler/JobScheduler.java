//package JobScheduler;
//
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.ScheduledFuture;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class JobScheduler {
//
//    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);
//    private final Map<Integer, JobMetadata> jobs = new ConcurrentHashMap<>();
//    private final AtomicInteger jobIdCounter = new AtomicInteger(1);
//
//    public int schedule(Job job, LocalDateTime time) {
//        long delay = time - System.currentTimeMillis();
//        if (delay < 0) {
//            System.out.println("❌ Cannot schedule a job in the past.");
//            return -1;
//        }
//
//        int jobId = jobIdCounter.getAndIncrement();
//        ScheduledFuture<?> future = executor.schedule(() -> {
//            job.execute();
//            jobs.remove(jobId);
//        }, delay, TimeUnit.MILLISECONDS);
//
//        jobs.put(jobId, new JobMetadata(jobId, future, job, time));
//        System.out.println("✅ Job " + jobId + " scheduled for " + time);
//        return jobId;
//    }
//
//    public boolean cancel(int jobId) {
//        JobMetadata meta = jobs.get(jobId);
//        if (meta != null) {
//            boolean cancelled = meta.future.cancel(false);
//            if (cancelled) {
//                jobs.remove(jobId);
//                System.out.println("✅ Job " + jobId + " cancelled.");
//            }
//            return cancelled;
//        }
//        System.out.println("❌ Job " + jobId + " not found.");
//        return false;
//    }
//
//    public int reschedule(int jobId, Date newTime) {
//        JobMetadata meta = jobs.get(jobId);
//        if (meta != null) {
//            cancel(jobId);
//            return schedule(meta.job, newTime);
//        }
//        System.out.println("❌ Job " + jobId + " not found for rescheduling.");
//        return -1;
//    }
//
//    public void shutdown() {
//        executor.shutdown();
//    }
//}
