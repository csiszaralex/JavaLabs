public class BusStop {
    public Boolean valid;
    public String name;
    public String oldName;
    public String wheelchair;
    public double lat;
    public double lng;
    public double dist;

    public BusStop() {
        reset();
    }
    public void reset() {
        valid = false;
        name = "";
        oldName = "";
        wheelchair = "";
    }

}
