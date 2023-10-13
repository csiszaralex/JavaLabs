public class Mult implements Command {
    @Override
    public void execute(String[] cmd) {
        if(Main.stack.size() < 2) {
            System.out.println("Nincs elég elem a szorzáshoz! ("+Main.stack.size()+")");
            return;
        }
        Main.stack.push(Main.stack.pop()*Main.stack.pop());
    }
}
