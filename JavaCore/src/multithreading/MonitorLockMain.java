package multithreading;

class MyRunnableImplamentation implements Runnable{
    MonitorLockExample monitorLockExample;
    public MyRunnableImplamentation(MonitorLockExample monitorLockExample){
        this.monitorLockExample=monitorLockExample;
    }
    @Override
    public void run() {
        monitorLockExample.task1();
    }
}
public class MonitorLockMain {
    public static void main(String[] args) {
        MonitorLockExample monitorLockExample=new MonitorLockExample();
//        Thread thread1=new Thread(()->monitorLockExample.task1());
        MyRunnableImplamentation myRunnableImplamentation=new MyRunnableImplamentation(monitorLockExample);

        Thread thread1=new Thread(myRunnableImplamentation);
        Thread thread2=new Thread(()->monitorLockExample.task2());
        Thread thread3=new Thread(()->monitorLockExample.task3());
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
