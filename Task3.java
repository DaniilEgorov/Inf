package Second_kurs;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Task3 {
    public static void main(String[] args) {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse("Data3.xml");
            Node root = doc.getDocumentElement();
            NodeList nodeList = root.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if(node.hasAttributes())System.out.println(node.getAttributes().getNamedItem("name").getTextContent());
                NodeList nodeList1 = node.getChildNodes();
                for (int j = 0; j < nodeList1.getLength(); j++) {
                    Node node1 = nodeList1.item(j);
                    if(node1.getNodeType() == Node.ELEMENT_NODE && node1.hasAttributes()){
                        Element element = (Element) node1;
                        System.out.print(node1.getAttributes().getNamedItem("name").getTextContent()+"   ");
                        System.out.println("Количество страниц: "+element.getElementsByTagName("pages").item(0).getTextContent());
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
