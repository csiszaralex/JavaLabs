public class Write implements Command{
    @Override
    public void execute(String[] cmd) {
        if (Main.stack.isEmpty()) {
            System.out.println("A verem üres!");
            return;
        }
        System.out.println(Main.stack.pop());
    }
}
