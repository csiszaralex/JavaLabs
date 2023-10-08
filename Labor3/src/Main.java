import java.io.File;
import java.util.Scanner;

public class Main {
    public static File wd;

    public static void main(String[] args) {
        wd = new File(System.getProperty("user.dir"));
        while (true) {
            System.out.print(wd.getPath() + ">");
            Scanner in = new Scanner(System.in);
            String cmd = in.nextLine();
            String[] cmds = cmd.split(" ");

            if (cmds[0].equals("exit") || cmds[0].isEmpty()) exit();
            else if (cmds[0].equals("pwd")) pwd();
            else if (cmds[0].equals("ls")) ls(cmds);
            else if (cmds[0].equals("cd")) cd(cmds[1]);
            else if (cmds[0].equals("rm")) rm(cmds[1]);
            else if (cmds[0].equals("mkdir")) mkdir(cmds[1]);
            else if (cmds[0].equals("mv")) mv(cmds[1], cmds[2]);
            else if (cmds[0].equals("length")) length(cmds[1]);
            else if(cmds[0].equals("grep")) grep(cmds[1], cmds[2]);
            else if (cmds[0].equals("tail")) tail(cmds);
        }
    }

    public static void exit() {
        System.exit(0);
    }

    public static void pwd() {
        System.out.println(wd.getPath() + " - " + wd.listFiles().length);
    }

    public static void ls(String[] cmds) {
        File[] files = wd.listFiles();
        if (cmds.length > 1 && cmds[1].equals("-l")) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("-d\t" + file.getName() + "\t");
                } else {
                    System.out.println("-f\t" + file.getName() + "\t" + file.length());
                }
            }
        } else {
            for (File file : files) {
                System.out.println(file.getName());
            }

        }
    }

    public static void cd(String dir) {
        String[] dirs = dir.split("/");
        for (String d : dirs) {
            if (d.equals(".")) continue;
            if (d.equals("..")) {
                if (wd.getParentFile() != null) wd = wd.getParentFile();
                continue;
            }
            File[] files = wd.listFiles();
            for (File file : files) {
                if (file.getName().equals(d)) {
                    wd = file;
                }
            }
        }
    }
    public static void rm(String file) {
        //TODO /jel-el is menjen
        File[] files = wd.listFiles();
        for (File f : files) {
            if (f.getName().equals(file)) {
                f.delete();
            }
        }
    }
    public static void mkdir(String dir) {
        File newDir = new File(wd.getPath() + "/" + dir);
        newDir.mkdir();
    }
    public static void mv(String file, String dir) {
        File[] files = wd.listFiles();
        for (File f : files) {
            if (f.getName().equals(file)) {
                f.renameTo(new File(dir));
            }
        }
    }
    public static void length(String file) {
        File[] files = wd.listFiles();
        boolean found = false;
        for (File f : files) {
            if (f.getName().equals(file)) {
                found = true;
                System.out.println(f.length());
                break;
            }
        }
        if (!found) System.out.println("Nincs ilyen fájl!");
    }
    public static void grep(String pattern, String file) {
        File[] files = wd.listFiles();
        boolean found = false;
        for (File f : files) {
            if (f.getName().equals(file)) {
                try {
                    found = true;
                    Scanner in = new Scanner(f);
                    while (in.hasNextLine()) {
                        String line = in.nextLine();
                        if (line.contains(pattern)) {
                            System.out.println(line);
                        }
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Hiba történt a fájl olvasása közben!");
                }
            }
        }
        if (!found) System.out.println("Nincs ilyen fájl!");
    }
    public static void tail(String[] cmds) {
        int num = 10;
        String file;

        if(cmds.length == 4) {
            num = Integer.parseInt(cmds[2]);
            file = cmds[3];
        } else {
            file = cmds[1];
        }

        File[] files = wd.listFiles();
        boolean found = false;
        for (File f : files) {
            if (f.getName().equals(file)) {
                try {
                    found = true;
                    Scanner in = new Scanner(f);
                    int i = 0;
                    String[] lines = new String[num];
                    while (in.hasNextLine()) {
                        String line = in.nextLine();
                        lines[i % num] = line;
                        i++;
                    }
                    for (int j = 0; j < num; j++) {
                        if (lines[(i + j) % num] == null) continue;
                        System.out.println(lines[(i + j) % num]);
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Hiba történt a fájl olvasása közben!");
                }
            }
        }
        if (!found) System.out.println("Nincs ilyen fájl!");
    }

}