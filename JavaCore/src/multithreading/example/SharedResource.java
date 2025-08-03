package multithreading.example;

public class SharedResource {
    boolean isItemAvailable=false;
//    synchronized put the monitor lock
    public synchronized void addItem(){
        isItemAvailable=true;
        System.out.println("Item added by thread: "+Thread.currentThread().getName());
        notifyAll();
    }
    public synchronized void consumeItem() {
        System.out.println("Consume Item Method is invoked by: " + Thread.currentThread().getName());
        while (!isItemAvailable) {
            try {
                System.out.println("Thread: " + Thread.currentThread().getName() + " Is waiting now");
                wait(); // releases all the monitor lock

            } catch (Exception ex) {
                System.out.println("Handle Exception");
            }
        }
        System.out.println("Item consumed by thread: " + Thread.currentThread().getName());
        isItemAvailable = false;
    }
}
