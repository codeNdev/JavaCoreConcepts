package multithreading.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main method starts");
        SharedResource sharedResource=new SharedResource();
//        Take Thread is in new State
//        Producer thread
        Thread producerThread=new Thread(new ProduceTask(sharedResource));
//        Consumer Thread
        Thread consumerThread=new Thread(new ConsumerTask(sharedResource));
//      Take thread in Runnable state
        producerThread.start();
        consumerThread.start();
//
    }
}
