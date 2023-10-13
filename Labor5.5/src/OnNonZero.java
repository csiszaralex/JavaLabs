public class OnNonZero implements Command{
    @Override
    public void execute(String[] cmd) {
        if(cmd.length < 2) return;
        if(Main.stack.pop() == 0) return;
        int cimke = Main.labels.get(cmd[1]);
        Main.pc = cimke - 1;
    }
}
