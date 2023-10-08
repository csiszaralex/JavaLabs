import java.util.ArrayList;

public class Fifo {
    private final ArrayList<String> adatok;

    public Fifo() {
        adatok = new ArrayList<>();
    }

    public synchronized void push(String str) throws InterruptedException {
        System.out.println("push Thread ID: " + Thread.currentThread().getId());
        if (adatok.size() == 10) wait();
        adatok.add(0, str);
        notify();
    }

    public synchronized String get() throws InterruptedException {
        System.out.println("get Thread ID: " + Thread.currentThread().getId());
        if (adatok.size() == 0) wait();
        String seged = adatok.get(adatok.size() - 1);
        adatok.remove(seged);
        notify();
        return seged;
    }
}
