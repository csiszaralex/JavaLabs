import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;

public class TagCounter extends DefaultHandler {

    HashMap<String, Integer> stats = new HashMap<>();
    ArrayList<BusStop> megallok = new ArrayList<>();
    double baseLat;
    double baseLng;

    public TagCounter(double baseLat, double baseLng) {
        super();
        this.baseLat = baseLat;
        this.baseLng = baseLng;

    }

    public void endDocument() throws SAXException {
        //1. feladat
        for (String key : stats.keySet()) {
            System.out.println(key + ": " + stats.get(key));
        }
        //2. feladat
        megallok.sort((o1, o2) -> {
            if (o1.dist < o2.dist) {
                return -1;
            } else if (o1.dist > o2.dist) {
                return 1;
            } else {
                return 0;
            }
        });
        for (BusStop megallo : megallok) {
            if (megallo.valid) {
                System.out.println("MEGÁLLÓ: " + megallo.name + " " + (!megallo.oldName.equals("") ? "(" + megallo.oldName + ")\t" : "\t") + megallo.wheelchair);
            }
        }
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //1. feladat
        if (stats.containsKey(qName)) {
            stats.put(qName, stats.get(qName) + 1);
        } else {
            stats.put(qName, 1);
        }
        //2. feladat
        if (qName.equals(("node"))) {
            if (megallok.size() == 0) {
                megallok.add(new BusStop());
            }
            if (megallok.get(megallok.size() - 1).valid) {
                megallok.add(new BusStop());
            }
            megallok.get(megallok.size() - 1).lat = Double.parseDouble(attributes.getValue("lat"));
            megallok.get(megallok.size() - 1).lng = Double.parseDouble(attributes.getValue("lon"));
            megallok.get(megallok.size() - 1).dist = dist(baseLat, baseLng, megallok.get(megallok.size() - 1).lat, megallok.get(megallok.size() - 1).lng);
        }
        if (qName.equals("tag")) {
            if (attributes.getValue("v").equals("bus_stop")) {
                megallok.get(megallok.size() - 1).valid = true;
            }
            if (attributes.getValue("k").equals("name")) {
                megallok.get(megallok.size() - 1).name = attributes.getValue("v");
            }
            if (attributes.getValue("k").equals("old_name")) {
                megallok.get(megallok.size() - 1).oldName = attributes.getValue("v");
            }
            if (attributes.getValue("k").equals("wheelchair")) {
                megallok.get(megallok.size() - 1).wheelchair = attributes.getValue("v");
            }
        }

    }


    public double dist(double lat1, double lng1, double lat2, double lng2) {
        double earthRadius = 6371000;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double dist = earthRadius * c;

        return dist;
    }
}