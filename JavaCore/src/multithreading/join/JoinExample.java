package multithreading.join;

import multithreading.infiniteWaiting.SharedResource;

public class JoinExample {
    public static void main(String[] args) {
        SharedResource sharedResource=new SharedResource();
        System.out.println("Main thread started");
        Thread thread1=new Thread(()->{
            System.out.println("Thread-1 calling test method");
            sharedResource.test();
        });
        thread1.start();
        try {
            System.out.println("Main thread is waiting for Thread-1 to finish now");
            thread1.join();
        }catch (Exception ex){
//            Exception handling

        }
        System.out.println("Main Thread finished Working");
//        Join method for thread
//        Deamon thread --> Use cases
//        Thread Priority  -> Not confirms the order
//
    }
}
