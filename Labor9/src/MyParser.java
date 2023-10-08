import org.xml.sax.*;
import org.xml.sax.helpers.*;


public class MyParser extends DefaultHandler {

    int tab = 0;
    public void println(String s) {
        for (int i = 0; i < tab; i++) {
            System.out.print("\t");
        }
        System.out.println(s);
    }
    public void startDocument() throws SAXException {
        println("startDocument");
    }
    public void endDocument() throws SAXException {
        println("endDocument");
    }
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tab++;
        println("startElement: " + qName);
    }
    public void endElement(String uri, String localName, String qName) throws SAXException {
        println("endElement: " + qName);
        tab--;
    }
}