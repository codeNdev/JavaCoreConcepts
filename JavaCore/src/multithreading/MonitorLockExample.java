package multithreading;

public class MonitorLockExample {
    public synchronized void task1(){
        try {
            System.out.println("Inside Task1");
            Thread.sleep(10000);
            System.out.println("Task1 Completed");
        }catch (Exception ex){
            System.out.println("Exception Message: "+ex.getMessage());
//            Exception Handling
        }
    }
    public void task2(){
        System.out.println("Task2 but before synchronized");
        synchronized (this){
            try{
                System.out.println("Task2, after synchronized");
                Thread.sleep(10000);
            }catch (Exception ex){
                //Exception Handling
            }
        }
    }

    public void task3(){
        System.out.println("Task3 ");
    }
}
