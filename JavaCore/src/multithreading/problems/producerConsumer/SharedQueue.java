package multithreading.problems.producerConsumer;

import java.util.ArrayDeque;
import java.util.Queue;

public class SharedQueue {
    int size;
    Queue<Integer> queue;
    public SharedQueue(int size){
        this.size=size;
        queue=new ArrayDeque<>();
    }
    public synchronized boolean produce(int val){
        while(queue.size()>=size){
            try {
                wait();
                System.out.println("Producer Thread is waiting");
            }catch (Exception ex){
//                Handle Exception
                return false;
            }
        }
        queue.add(val);
        notify();
        return true;
    }
    public synchronized int consume(){

        while (queue.isEmpty()){
            try {
                wait();
                System.out.println("Consumer thread is waiting");
            }catch (Exception ex){
//                Handle Exception
                return -1;
            }
        }
        int val=queue.poll();
        notify();
        return val;
    }

    @Override
    public String toString() {
        return "SharedQueue{" +
                "size=" + size +
                ", queue=" + queue +
                '}';
    }
}
