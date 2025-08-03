package multithreading.join;

public class DeamonExample {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread running...");
                try { Thread.sleep(500); } catch (Exception e) {}
            }
        });

        daemonThread.setDaemon(true);
        daemonThread.start();

        try { Thread.sleep(1500); } catch (Exception e) {}
        System.out.println("Main thread finished. JVM will exit now.");
    }
}
