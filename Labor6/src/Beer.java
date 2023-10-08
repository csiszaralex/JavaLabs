import java.io.Serializable;
import java.util.Comparator;

public class Beer implements Serializable {
    private final String name;
    private final String style;
    private final double strength;

    public Beer(String name, String style, double strength) {
        this.name = name;
        this.style = style;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public String getStyle() {
        return style;
    }

    public double getStrength() {
        return strength;
    }

    public String toString() {
        return name + " (" + style + ") " + strength + "%";
    }
}

class NameComparator implements Comparator<Beer> {
    public int compare(Beer o1, Beer o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
class StyleComparator implements Comparator<Beer> {
    public int compare(Beer o1, Beer o2) {
        return o1.getStyle().compareTo(o2.getStyle());
    }
}
class StrengthComparator implements Comparator<Beer> {
    public int compare(Beer o1, Beer o2) {
        return Double.compare(o1.getStrength(), o2.getStrength());
    }
}
