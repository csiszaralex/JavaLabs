public class Add implements Command{
    @Override
    public void execute(String[] cmd) {
        if(Main.stack.size() < 2) {
            System.out.println("Nincs elég elem az összeadáshoz! ("+Main.stack.size()+")");
            return;
        }
        Main.stack.push(Main.stack.pop()+Main.stack.pop());
    }
}
