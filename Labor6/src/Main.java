import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.*;

@SuppressWarnings("InfiniteLoopStatement")
public class Main {
    private static ArrayList<Beer> beers = new ArrayList<>();
    private static final HashMap<String, Command> commands = new HashMap<>();
    private static final HashMap<String, Comparator<Beer>> comps = new HashMap<>();
    static {
        comps.put("name", new NameComparator());
        comps.put("style", new StyleComparator());
        comps.put("strength", new StrengthComparator());
    }

    public static void main(String[] args) {
        //region sorok
        beers.add(new Beer("aa", "z", 7));
        beers.add(new Beer("ab", "w", 2));
        beers.add(new Beer("ac", "x", 5));
        beers.add(new Beer("ba", "y", 3));
        beers.add(new Beer("bb", "a", 1));
        beers.add(new Beer("bc", "a", 8));
        beers.add(new Beer("x", "zz", 6));
        beers.add(new Beer("y", "a", 4));
        //endregion
        //region commands
        commands.put("", x->{});
        commands.put("exit", x-> System.exit(0));
        commands.put("list", Main::list);
        commands.put("add", Main::add);
        commands.put("save", Main::save);
        commands.put("load", Main::load);
        commands.put("search", Main::search);
        commands.put("find", Main::find);
        commands.put("delete", Main::delete);
        //endregion

        while (true) {
            System.out.print("#");
            Scanner in = new Scanner(System.in);
            String cmd = in.nextLine();
            String[] cmds = cmd.split(" ");

            if(commands.containsKey(cmds[0])) {
                commands.get(cmds[0]).execute(cmds);
            } else {
                System.out.println("Unknown command");
            }
        }
    }

    protected static void add(String @NotNull [] cmds) {
        if (cmds.length != 4) return;
        beers.add(new Beer(cmds[1], cmds[2], Double.parseDouble(cmds[3])));
    }

    protected static void list(String @NotNull [] cmds) {
        for (int i = cmds.length - 1; i >= 1; i--) {
            if(comps.containsKey(cmds[i])){
                beers.sort(comps.get(cmds[i]));
            }
//            if ("name".equals(cmds[i])) beers.sort((b1, b2) -> b1.getName().compareTo(b2.getName()));
//            else if ("style".equals(cmds[i])) beers.sort((b1, b2) -> b1.getStyle().compareTo(b2.getStyle()));
//            else if ("strength".equals(cmds[i]))
//                beers.sort((b1, b2) -> Double.compare(b1.getStrength(), b2.getStrength()));
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