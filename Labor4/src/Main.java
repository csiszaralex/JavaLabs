import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static ArrayList<Beer> beers = new ArrayList<>();

    public static void main(String[] args) {
        beers.add(new Beer("aa", "z", 7));
        beers.add(new Beer("ab", "w", 2));
        beers.add(new Beer("ac", "x", 5));
        beers.add(new Beer("ba", "y", 3));
        beers.add(new Beer("bb", "a", 1));
        beers.add(new Beer("bc", "a", 8));
        beers.add(new Beer("x", "zz", 6));
        beers.add(new Beer("y", "a", 4));
        while (true) {
            System.out.print("#");
            Scanner in = new Scanner(System.in);
            String cmd = in.nextLine();
            String[] cmds = cmd.split(" ");

            if (cmds.length == 0) continue;
            else if ("exit".equals(cmds[0])) System.exit(0);
            else if ("add".equals(cmds[0])) add(cmds);
            else if ("list".equals(cmds[0])) list(cmds);
            else if ("save".equals(cmds[0])) save(cmds);
            else if ("load".equals(cmds[0])) load(cmds);
            else if("search".equals(cmds[0])) search(cmds);
            else if("find".equals(cmds[0])) find(cmds);
            else if("delete".equals(cmds[0])) delete(cmds);
            else System.out.println("Unknown command");
        }
    }

    protected static void add(String @NotNull [] cmds) {
        if (cmds.length != 4) return;
        beers.add(new Beer(cmds[1], cmds[2], Double.parseDouble(cmds[3])));
    }

    protected static void list(String @NotNull [] cmds) {
        for (int i = cmds.length-1; i >= 1; i--) {
            if ("name".equals(cmds[i])) beers.sort(new NameComparator());
            else if ("style".equals(cmds[i])) beers.sort(new StyleComparator());
            else if ("strength".equals(cmds[i])) beers.sort(new StrengthComparator());
        }
        for (Beer beer : beers) {
            System.out.println(beer);
        }
    }

    protected static void save(String @NotNull [] cmds) {
        if (cmds.length != 2) return;
        try {
            FileOutputStream f = new FileOutputStream(cmds[1]);
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(beers);
            out.close();
        } catch (IOException ex) {
            System.out.println("HIBA: " + ex.getMessage());
        }
    }

    protected static void load(String @NotNull [] cmds) {
        if (cmds.length != 2) return;
        ArrayList<Beer> sorok = null;
        try {
            FileInputStream f = new FileInputStream(cmds[1]);
            ObjectInputStream in = new ObjectInputStream(f);
            sorok = (ArrayList<Beer>) in.readObject();
            in.close();
        } catch (IOException ex) {
            System.out.println("HIBA(IO): " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("HIBA(CLASS): " + ex.getMessage());
        }
        beers = sorok;

    }

    protected static void search(String @NotNull [] cmds) {
        if (cmds.length != 2) return;
        for (Beer beer : beers) {
            if (beer.getName().equals(cmds[1])) System.out.println(beer);
        }
    }
    protected static void find(String @NotNull [] cmds) {
        if (cmds.length != 2) return;
        for (Beer beer : beers) {
            if (beer.getName().contains(cmds[1])) System.out.println(beer);
        }
    }
    protected static void delete(String @NotNull [] cmds) {
        if (cmds.length != 2) return;
        for (int i = 0; i < beers.size(); i++) {
            if (beers.get(i).getName().equals(cmds[1])) beers.remove(i);
        }
        Collections.binarySearch(beers, new Beer(cmds[1], "", 0), new NameComparator());
    }
}