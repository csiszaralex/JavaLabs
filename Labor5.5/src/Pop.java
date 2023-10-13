public class Pop implements Command {
    @Override
    public void execute(String[] cmd) {
        if (Main.stack.isEmpty()) {
            System.out.println("A verem üres!");
            return;
        }
        Main.stack.pop();
    }
}
