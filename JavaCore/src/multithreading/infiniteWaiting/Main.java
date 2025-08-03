package multithreading.infiniteWaiting;

public class Main {
    public static void main(String[] args) {
        System.out.println("main thread started");
        SharedResource sharedResource=new SharedResource();
        Thread thread1=new Thread(()->{
            System.out.println("Thread1 calling produce method ");
            sharedResource.test();
        });
        Thread thread2=new Thread(()->{

            try {
                Thread.sleep(1000);
            }catch (Exception ex){

            }
            System.out.println("Thread2 calling produce method ");
            sharedResource.test();
        });
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(2000);
        }catch (Exception ex){

        }
        System.out.println("Main thread ended");
//        thread1.suspend();  // not available in modern java
    }
}
