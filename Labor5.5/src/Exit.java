public class Exit implements Command {
    @Override
    public void execute(String[] cmd) {
        System.exit(0);
    }
}
