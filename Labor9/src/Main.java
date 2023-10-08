import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Main {
    public static void main(String[] args) {
        elso(args[1], args[2], args[3]);
    }

    public static void elso(String path, String latS, String lngS) {
        double lat = Double.parseDouble(latS);
        double lng = Double.parseDouble(lngS);
        DefaultHandler h = new TagCounter(lat, lng);

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try{
            SAXParser p = factory.newSAXParser();
            p.parse(path, h);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
