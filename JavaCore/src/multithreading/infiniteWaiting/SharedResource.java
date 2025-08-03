package multithreading.infiniteWaiting;

import java.util.SortedMap;

public class SharedResource {
    boolean isAvailable=false;
    public synchronized void test(){
        System.out.println("Acquired Lock");
        isAvailable=true;
        System.out.println("Current thread is: "+ Thread.currentThread().getName());
        try {
            Thread.sleep(8000);
        }catch (Exception ex){
//            Handle Exception

        }
        System.out.println("Lock Released");
    }
}
