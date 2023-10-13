//public class Producer implements Runnable {
public class Producer extends Thread {
    private final String uzenet;
    private int srsz;
    private final Fifo fifo;
    private final int delay;

    public Producer(String str, Fifo fifo, int delay) {
        uzenet = str;
        srsz = 0;
        this.fifo = fifo;
        this.delay = delay;
    }

    public void go() throws InterruptedException {
        while (true) {
            synchronized (fifo) {
                fifo.push(uzenet + " " + srsz);
            }
//            System.out.println("produced "+uzenet + "\t" + srsz + "\t" + (System.currentTimeMillis() % 100000));
            srsz++;
            Thread.sleep(delay);
        }
    }

    public void run() {
        try {
            go();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
