public class Consumer extends Thread {
    private final Fifo fifo;
    private final String uzenet;
    private final int delay;

    public Consumer (Fifo fifo, String str, int delay) throws InterruptedException {
        this.fifo = fifo;
        this.uzenet = str;
        this.delay = delay;
    }

    public void run() {
        while(true) {
            try {
                String uzenet = "";
                synchronized (fifo) {
                    uzenet = fifo.get();
                }
//                System.out.println("consumed " + this.uzenet + " "  + uzenet + " " + (System.currentTimeMillis() % 100000));
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
