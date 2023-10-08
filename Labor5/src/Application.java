import java.util.Random;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Fifo fifo = new Fifo();
        Random r = new Random();

        Producer prod = new Producer("alma", fifo, r.nextInt(500) + 1000);
        Producer prod2 = new Producer("korte", fifo, r.nextInt(500) + 1000);
        Producer prod3 = new Producer("szilva", fifo, r.nextInt(500) + 1000);
        prod.start();
        prod2.start();
        prod3.start();

//        Thread t1 = new Thread(prod);
//        t1.start();

        Consumer cons = new Consumer(fifo, "1", r.nextInt(50)+100);
        Consumer cons2 = new Consumer(fifo, "2", r.nextInt(50)+100);
        Consumer cons3 = new Consumer(fifo, "3", r.nextInt(50)+100);
        cons.start();
        cons2.start();
        cons3.start();

    }
}
