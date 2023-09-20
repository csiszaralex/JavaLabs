import java.util.Random;

public class Asztal {
    private Jatekos[] jatekosok;
    private int akt;
    private double tet;
    private int kor;
    private double goal;

    public Asztal() {
        ujJatek();
    }

    public void ujJatek() {
        jatekosok = new Jatekos[10];
        akt = 0;
        kor = 0;
        tet = 0;
        Random r = new Random();
        goal = r.nextDouble() * 100;
    }

    public void addJatekos(Jatekos j) {
        if (akt == 10) {
            System.out.println("Az asztal megtelt");
            return;
        }
        jatekosok[akt++] = j;
        j.setAsztal(this);
    }

    public int getKor() {
        return kor;
    }

    public void emel(double d) {
        tet += d;
    }
    public double getTet() {
        return tet;
    }

    public void kor() throws NincsJatekos {
        if (akt == 0) {
            throw new NincsJatekos("Nincs egy játékos sem");
        }
        if (tet > goal) {
            System.out.println("Vége a játéknak");
            return;
        }
        kor++;
        for (int i = 0; i < akt; i++) {
            Jatekos jatekos = jatekosok[i];
            jatekos.lep();
            if (tet > goal) {
                System.out.print("[Game]Vége");
                if (1.1 * tet < goal) System.out.println(" - NYERT: " + jatekos.toString());
                else System.out.println(" - Mindenki veszített");
                return;
            }
        }

        System.out.println("[RoundEnd]"+tet);

    }


}
