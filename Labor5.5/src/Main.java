import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static ArrayDeque<Integer> stack = new ArrayDeque<>();
    static HashMap<String, Command> map = new HashMap<>();
    public static int pc = 0;
    public static HashMap<String, Integer> labels = new HashMap<>();
    public static HashMap<String, Integer> vars = new HashMap<>();
    public static ArrayDeque<Integer> frame = new ArrayDeque<>();
    public static HashMap<String, Integer> functions = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        map.put("exit", new Exit());
        map.put("list", new List());
        map.put("push", new Push());
        map.put("pop", new Pop());
        map.put("dup", new Dup());
        map.put("read", new Read());
        map.put("write", new Write());
        map.put("add", new Add());
        map.put("sub", new Sub());
        map.put("mult", new Mult());
        map.put("div", new Div());
        map.put("jump", new Jump());
        map.put("onzero", new OnZero());
        map.put("onnonzero", new OnNonZero());
        map.put("onnegative", new OnNegative());
        map.put("load", new Load());
        map.put("store", new Store());
        map.put("call", new Call());
        map.put("return", new Return());

        if (args.length > 0) {
            file(args[0]);
        } else {
            console();
        }
    }

    public static void console() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] cmds = line.split(" ");
            Command c = map.get(cmds[0]);
            if (c == null) {
                System.out.println("Hibás parancs!");
                continue;
            }
            c.execute(cmds);
        }
        in.close();
    }

    public static void file(String fileName) throws FileNotFoundException {
        LinkedList<String> lines = new LinkedList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("A fájl nem létezik!");
            return;
        }
        Scanner in = new Scanner(file);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.charAt(0) == '#') labels.put(line, pc + 1);
            else if (line.charAt(0) == '@') functions.put(line, pc+1);
            pc++;
            lines.add(line);
        }
        pc = 0;
        while (pc < lines.size()) {
            String line = lines.get(pc);

            if (line.charAt(0) == '#') {
                pc++;
                continue;
            }
            String[] cmds = line.split(" ");
            Command c = map.get(cmds[0]);
            if (c == null) {
                System.out.println("Hibás parancs!");
                pc++;
                continue;
            }
            c.execute(cmds);

            pc++;

        }
        in.close();
    }
}