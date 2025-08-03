package multithreading.problems.producerConsumer;

public class Main {
    public static void main(String[] args) {
        int size=5;
        SharedQueue sharedQueue=new SharedQueue(size);
        ProducerTask produceTask=new ProducerTask(sharedQueue);
        ConsumerTask consumerTask=new ConsumerTask(sharedQueue);
        Thread producerThread=new Thread(produceTask);
        Thread consumerThread=new Thread(consumerTask);

        producerThread.start();
        consumerThread.start();

    }
}
