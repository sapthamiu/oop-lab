class Items {
    private int item;
    private boolean available = false;

    public synchronized void produce(int value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        item = value;
        available = true;
        System.out.println("Produced: " + item);
        notify();
    }

    public synchronized void consume() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("Consumed: " + item);
        available = false;
        notify();
    }
}

class Producer extends Thread {
    private final Items queue;

    public Producer(Items queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            queue.produce(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class Consumer extends Thread {
    private final Items queue;

    public Consumer(Items queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            queue.consume();
            try {
                Thread.sleep(1500); 
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class ProdCons {
    public static void main(String[] args) {
        Items queue = new Items();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        producer.start();
        consumer.start();
    }
}
