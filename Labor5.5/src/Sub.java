public class Sub implements Command{
    public void execute(String[] cmd) {
        if(Main.stack.size() < 2) {
            System.out.println("Nincs elég elem a kivonáshoz! ("+Main.stack.size()+")");
            return;
        }
        Main.stack.push(Main.stack.pop() - Main.stack.pop());
    }
}
