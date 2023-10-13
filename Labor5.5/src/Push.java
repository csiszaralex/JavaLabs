public class Push implements Command {
    @Override
    public void execute(String[] cmd) {
        if (cmd.length < 2){
            System.out.println("Kevés az argumentumok száma!");
            return;
        }
        int i = 0;
        if(cmd[1].charAt(0) == '-') i = 1;
        for (; i<cmd[1].length(); i++) {
            if(!Character.isDigit(cmd[1].charAt(i))) {
                System.out.println("A megadott paraméter csak szám lehet");
                return;
            }
        }
        Main.stack.push(Integer.parseInt(cmd[1]));
    }
}
