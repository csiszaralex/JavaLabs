import calc.Calculator;

public class Main {
    public static void main(String[] args) {

        int sum = 0;
        Calculator c = new Calculator();
        for (int i = 0; i < args.length; i++) {
            sum = c.add(sum, Integer.parseInt(args[i]));
        }

        System.out.println(sum);
    }
}