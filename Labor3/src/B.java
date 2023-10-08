
class A {
    protected void p(String s) {
        System.out.println(s);
    }
    public void foo1(double x) {p("A.foo1");}
    public void foo2(double x) {p("A.foo2");}
    public void foo3(double x) {foo1(x);}
    public void foo4(double x) {foo2(x);}
}
public class B extends A {
    public void foo1(double x) {p("B.foo1");}
    public void foo2(String x) {p("B.foo2");}
    public static void main(String[] args) {
        A b = new B();
        b.foo4(3.14);
        b.foo3(2.71);
    }
}

