public abstract class Jatekos {
    protected Asztal asztal;

    public void lep() {
    }

    protected void finalize() {
        System.out.println("[Finalize]"+this.hashCode()+" - "+ this);
    }

    public void setAsztal(Asztal a) {
        asztal = a;
    }
}
