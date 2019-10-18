package Second_kurs;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class MyHandler extends DefaultHandler {
    public ArrayList<Sportsman> people = new ArrayList<>();
    Sportsman sportsman ;
    String lastElementName;
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("sportsman") && attributes != null){
            String name = attributes.getValue("name");
            String birthday = attributes.getValue("birthday");
            String s = attributes.getValue("s");
            sportsman = new Sportsman(name,birthday,s);
            people.add(sportsman);
        }else if (qName.equals("event") && attributes != null){
            String place = attributes.getValue("place");
            int year = Integer.parseInt(attributes.getValue("year"));
            sportsman.addPlace(place);
            sportsman.addYear(year);
        }
        lastElementName = qName;
    }
    public void characters(char[] ch, int start, int length)  {
        String information = new String(ch, start, length);
        information = information.replace("\n", "").trim();
        if (!information.isEmpty()) {
            if (lastElementName.equals("result")) {
                sportsman.addResult(Integer.parseInt(information));
            }else if (lastElementName.equals("award")) {
                sportsman.addAward(information);
            }
        }
    }
    public ArrayList<Sportsman> getPeople(){
        return people;
    }
}
