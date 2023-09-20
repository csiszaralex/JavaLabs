public class Mester extends Jatekos {
    int mesterfokozat;

    public Mester(int mesterfokozat) {
        this.mesterfokozat = mesterfokozat;
    }

    @Override
    public String toString() {
        return "[Mester]"+mesterfokozat;
    }

    @Override
    public void lep() {
        System.out.println(this.toString() + " - "+asztal.getKor());
        double tet = asztal.getTet() * (100+mesterfokozat)/100;
        asztal.emel(tet);
    }
}
