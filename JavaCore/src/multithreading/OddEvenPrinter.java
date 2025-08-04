package multithreading;

class Resource {
    int val = 1;
    int max;

    public Resource(int max) {
        this.max = max;
    }

    public synchronized void printOdd() {
        while (val <= max) {
            while ((val & 1) == 0) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }

            if (val <= max) {
                System.out.println("Odd thread prints: " + val);
                val++;
                notifyAll();
            }
        }
    }

    public synchronized void printEven() {
        while (val <= max) {
            while ((val & 1) == 1) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }

            if (val <= max) {
                System.out.println("Even thread prints: " + val);
                val++;
                notifyAll();
            }
        }
    }
}

class OddRunnable implements Runnable {
    Resource resource;

    public OddRunnable(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.printOdd();
    }
}

class EvenRunnable implements Runnable {
    Resource resource;

    public EvenRunnable(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.printEven();
    }
}

public class OddEvenPrinter {
    public static void main(String[] args) {
        int n = 10;
        Resource resource = new Resource(n);
        Thread oddThread = new Thread(new OddRunnable(resource));
        Thread evenThread = new Thread(new EvenRunnable(resource));

        // Start both threads immediately
        oddThread.start();
        evenThread.start();
    }
}
