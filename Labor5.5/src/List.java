public class List implements Command {
    @Override
    public void execute(String[] cmd) {
//        Main.stack.forEach(System.out::println);
        if (Main.stack.isEmpty()) {
            System.out.println("A verem üres!");
            return;
        }
        for (Integer elem : Main.stack) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
