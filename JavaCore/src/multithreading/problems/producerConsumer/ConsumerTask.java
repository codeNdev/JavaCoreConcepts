package multithreading.problems.producerConsumer;

public class ConsumerTask implements Runnable{
    SharedQueue sharedQueue;
    public ConsumerTask(SharedQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }


    @Override
    public void run() {
        for (int i=0;i<15;i++){
//            System.out.println("Consumer Thread started");
            int val= sharedQueue.consume();
            System.out.println("The value consumed at Consumer thread is: "+ val);
            System.out.println("Consumer Thread Completed for iteration: "+ i+ "With current Queue"+ sharedQueue.toString());
        }
    }
}
