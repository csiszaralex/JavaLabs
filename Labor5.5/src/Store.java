public class Store implements Command {
    @Override
    public void execute(String[] cmd) {
        if(cmd.length < 2) return;
        if(Main.stack.isEmpty()) return;
        //szam-e
        Main.vars.put(cmd[1], Main.stack.pop());
    }
}
