public class Nyuszi extends Jatekos {
    String szin;

    public Nyuszi(String szin) {
        this.szin = szin;
    }

    @Override
    public String toString() {
        return szin;
    }

    @Override
    public void lep() {
        System.out.println("[Nyuszi]"+this.toString()+" - "+asztal.getKor());

        if(asztal.getTet() <= 50) {
            asztal.emel(5);
        } else {
            System.out.println("\t"+asztal.getTet() + "Huha!");
        }
    }
}
