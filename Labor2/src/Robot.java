public class Robot extends Jatekos {
    private static int srsz = 0;
    private final int sorszam;

    public Robot() {
        sorszam = srsz++;
    }

    @Override
    public String toString() {
        return "[Robot]" + sorszam;
    }

    public void lep() {
        System.out.println(this.toString() + " - "+ asztal.getKor());
    }
}
