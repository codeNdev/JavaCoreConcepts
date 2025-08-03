package multithreading.join;

public class PriorityExample {
    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + " running");
            }
        };

        Thread t1 = new Thread(task, "Low Priority");
        Thread t2 = new Thread(task, "High Priority");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }
}
