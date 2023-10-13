public class Call implements Command{
    @Override
    public void execute(String[] cmd) {
        if(cmd.length < 2) return;
        int cimke = Main.functions.get(cmd[1]);
        Main.frame.push(Main.pc);
        Main.pc = cimke - 1;
    }
}
