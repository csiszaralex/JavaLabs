import java.io.File;

class Exit implements Command {

    @Override
    public File execute(File wd, String[] cmd) {
        System.exit(0);
        return wd;
    }

    @Override
    public String help() {
        return "Kilép a programból.";
    }

    @Override
    public String name() {
        return "exit";
    }
}
