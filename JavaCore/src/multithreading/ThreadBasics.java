package multithreading;

public class ThreadBasics {
    public static void main(String[] args) {

        System.out.println("In the main method ThreadName: "+ Thread.currentThread().getName());
        Runnable runnable= () -> System.out.println("Implemented Runnable Interface by thread: "+Thread.currentThread().getName());
        Thread thread1=new Thread(runnable);
//        THis start method internally calls the run() method of runnable object, we passed to the thread.

        thread1.start();

        System.out.println("Finished main method");
    }
}
