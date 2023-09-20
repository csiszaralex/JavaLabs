public class Kezdo extends Jatekos {
    private final String nev;

    public Kezdo(String nev) {
        this.nev = nev;
    }

    @Override
    public String toString() {
        return nev;
    }

    public void lep() {
        System.out.println("[Kezdo]"+this.toString() + " - " +asztal.getKor());
        int kor = asztal.getKor();

        if (kor % 2 == 0) {
            asztal.emel(1);
        }


    }

}
