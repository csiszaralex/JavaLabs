public class Main {
    public static void main(String[] args) {
//        Asztal a = new Asztal();
//        Jatekos j1 = new Kezdo("Béla");
//        Jatekos j2 = new Kezdo("Anna");
//        Jatekos j3 = new Robot();
//        a.addJatekos(j1);
//        a.addJatekos(j2);
//        a.addJatekos(j3);
//
//        try {
//            a.kor();
//            a.kor();
//            a.kor();
//        } catch (NincsJatekos err) {
//            System.out.println(err);
//        }


//        Asztal a2 = new Asztal();
//        try {
//            a2.kor();
//        } catch (NincsJatekos err) {
//            System.out.println(err);
//        }

        Asztal a3 = new Asztal();
        Jatekos m = new Mester(10);
        Jatekos ny = new Nyuszi("Piros");
//        Jatekos e = new Ember();
        a3.addJatekos(m);
        a3.addJatekos(ny);
        try {
            for (int i = 0; i < 10; i++) {
                a3.kor();
            }
        }catch (NincsJatekos err) {
            System.out.println(err);
        }
        a3= null;
        System.gc();

    }
}