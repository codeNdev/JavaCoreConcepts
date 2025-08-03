package multithreading.problems.producerConsumer;

public class ConsumerTask implements Runnable{
    public ConsumerTask(SharedQueue queue) {
        this.queue = queue;
    }

    SharedQueue queue;

    @Override
    public void run() {
        for (int i=0;i<15;i++){
//            System.out.println("Consumer Thread started");
            int val=queue.consume();
            System.out.println("The value consumed at Consumer thread is: "+ val);
            System.out.println("Consumer Thread Completed for iteration: "+ i+ "With current Queue"+queue.toString());
        }

    }
}
