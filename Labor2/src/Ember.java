import java.util.Scanner;
public class Ember extends Jatekos {
    @Override
    public void lep() {
        System.out.println("[Ember]" + asztal.getTet());
        Scanner scanner = new Scanner(System.in);
        int szam = scanner.nextInt();
        asztal.emel(szam);
    }
}
