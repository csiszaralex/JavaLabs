public class Return implements Command{
    @Override
    public void execute(String[] cmd) {
        Main.pc = Main.frame.pop();
    }
}
