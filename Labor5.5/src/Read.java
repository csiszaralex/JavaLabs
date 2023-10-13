import java.util.Scanner;

public class Read implements Command{
    @Override
    public void execute(String[] cmd) {
        boolean isInt;
        int szam = 0;
        Scanner in = new Scanner(System.in);
        do {
            isInt = true;
            String line = in.nextLine();
            String[] cmds = line.split(" ");

            int i = 0;
            if(cmds[0].charAt(0) == '-') i = 1;
            for (; i<cmds[0].length(); i++) {
                if (!Character.isDigit(cmds[0].charAt(i))) {
                    System.out.println("A megadott paraméter csak szám lehet");
                    isInt = false;
                    break;
                }
            }
            if(isInt)
                szam = Integer.parseInt(cmds[0]);
        } while (!isInt);
        Main.stack.push(szam);

    }
}
