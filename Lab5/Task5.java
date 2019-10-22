package Second_kurs;

import org.json.JSONObject;
import org.xml.sax.SAXException;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.*;
import java.util.ArrayList;

public class Task5 extends MyHandler {
    public static void main(String[] args) {
        second();
    }

    public static void first() {

        ArrayList<Table> tables = new ArrayList<>();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        Table pers = new Table();
        try {
            XMLEventReader reader = factory.createXMLEventReader(new FileInputStream("Data3.xml"));
            while (reader.hasNext()) {
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("author")) {
                        Attribute persAttr = startElement.getAttributeByName(new QName("name"));
                        if (persAttr != null) {
                            pers.setName(persAttr.getValue());
                        }
                    } else if (startElement.getName().getLocalPart().equals("book")) {
                        Attribute persAttr = startElement.getAttributeByName(new QName("name_book"));
                        if (persAttr != null) {
                            pers.setName_book(persAttr.getValue());
                        }
                    } else if (startElement.getName().getLocalPart().equals("pages")) {
                        xmlEvent = reader.nextEvent();
                        pers.setPages(Integer.parseInt(xmlEvent.asCharacters().getData()));
                        tables.add(pers);
                        pers = new Table(pers.getName(), null, 0);
                    }
                }
            }
            System.out.println(tables);
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void second() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse("Data_sportsman.xml", handler);
            ArrayList<Sportsman> people = handler.getPeople();
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("New_data5.json")));
            JSONObject object = new JSONObject();
            JSONObject object1 = new JSONObject();
            JSONObject object2 = new JSONObject();
            for (int i = 0; i < people.size(); i++) {
                Sportsman man = people.get(i);
                if (man.getGender().equals("м")){
                    object1 = new JSONObject();
                    object2 = new JSONObject();
                    object1.put("name",man.getName());
                    object1.put("birthday",man.getBirthday());
                    int j = 0;
                    while (man.getYear(j)!=-1) {
                        object2.accumulate("year",man.getYear(j));
                        object2.accumulate("award",man.getAward(j));
                        j++;
                    }
                    object1.put("event",object2);
                    object.append("sportsmen",object1);
                }
            }
            bw.write(object.toString());
            bw.close();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
