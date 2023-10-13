public class Load implements Command{
    @Override
    public void execute(String[] cmd) {
        if(cmd.length < 2) return;
        Main.stack.push(Main.vars.get(cmd[1]));
    }
}
