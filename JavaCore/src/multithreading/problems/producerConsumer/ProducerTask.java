package multithreading.problems.producerConsumer;

public class ProducerTask implements Runnable {
    SharedQueue sharedQueue;
    public ProducerTask(SharedQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i=0;i<15;i++){
            int val= (int) (Math.random()*10);
            System.out.println("Generated value at Producer Thread is: "+ val);
            sharedQueue.produce(val);
            System.out.println("Producer Task Completed for iteration: "+ i + "With current Queue : "+sharedQueue.toString());
        }
    }
}
