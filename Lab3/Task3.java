package Second_kurs;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task3 {
    static ArrayList<Sportsman> arrayList = new ArrayList<>();
    public static void main(String[] args) {
        fifth();
    }
    public static void first(){
        try {
            Document doc = newDoc("Data3.xml");
            Node root = doc.getDocumentElement();
            NodeList nodeList = root.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if(node.hasAttributes())System.out.println("Автор: "+node.getAttributes().getNamedItem("name").getTextContent());
                NodeList nodeList1 = node.getChildNodes();
                for (int j = 0; j < nodeList1.getLength(); j++) {
                    Node node1 = nodeList1.item(j);
                    if(node1.getNodeType() == Node.ELEMENT_NODE && node1.hasAttributes()){
                        Element element = (Element) node1;
                        System.out.print("Книга: "+node1.getAttributes().getNamedItem("name").getTextContent()+"   ");
                        System.out.println("Количество страниц: "+element.getElementsByTagName("pages").item(0).getTextContent());
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
    public static void second(){
        try {
            Document document = newDoc("Data_sportsman.xml");
            Node root = document.getDocumentElement();
            NodeList nodeList = root.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                String n = "",b = "",s = "";
                Node node = nodeList.item(i);
                if(node.hasAttributes()){
                    n=node.getAttributes().getNamedItem("name").getTextContent();
                    b=node.getAttributes().getNamedItem("birthday").getTextContent();
                    s=node.getAttributes().getNamedItem("s").getTextContent();
                }
                Sportsman sportsman = new Sportsman(n,b,s);
                arrayList.add(sportsman);
                NodeList nodeList1 = node.getChildNodes();
                for (int j = 0; j < nodeList1.getLength(); j++) {
                    Node node1 = nodeList1.item(j);
                    if(node1.getNodeType() == Node.ELEMENT_NODE && node1.hasAttributes()){
                        Element element = (Element) node1;
                        sportsman.addYear(Integer.parseInt(node1.getAttributes().getNamedItem("year").getTextContent()));
                        sportsman.addPlace(node1.getAttributes().getNamedItem("place").getTextContent());
                        sportsman.addResult(Integer.parseInt(element.getElementsByTagName("result").item(0).getTextContent()));
                        sportsman.addAward(element.getElementsByTagName("award").item(0).getTextContent());
                    }
                }
            }
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
    public static void third(){
        second();
        for (Sportsman value : arrayList) {
            if (value.getGender().equals("м")) {
                System.out.println(value.getName() + "  " + value.getBirthday());
            }
        }
        for (Sportsman value : arrayList) {
            if (value.getGender().equals("ж") && Integer.parseInt(value.getBirthday().substring(0, 4)) > 1985) {
                int j = 0;
                while (!value.getAward(j).equals("-1")) j++;
                System.out.println(value.getName() + "  " + value.getBirthday() + "  Количество медалей: " + j);
            }
        }
        for (Sportsman sportsman : arrayList) {
            int j = 0;
            while (sportsman.getYear(j) != -1) {
                if (sportsman.getYear(j) == 2002 && sportsman.getPlace(j).equals("москва")) {
                    System.out.println(sportsman.getName() + "  " + sportsman.getResult(j));
                }
                j++;
            }
        }
    }
    public static void fourth(){
        Scanner scanner = new Scanner(System.in);
        String n = "",b = "",s = "";
        System.out.println("Введите данные спортсмена");
        System.out.print("Имя: " );
        n=scanner.next();
        System.out.print("Дата рождения (формат гггг-мм-дд): " );
        b=scanner.next();
        System.out.print("Пол м или ж: " );
        s=scanner.next();
        Sportsman sportsman = new Sportsman(n,b,s);
        System.out.print("Количество соревнований: ");
        int k  =scanner.nextInt();
        for (int i = 0; i < k; i++) {
            System.out.print("Место: ");
            sportsman.addPlace(scanner.next());
            System.out.print("Год: " );
            sportsman.addYear(scanner.nextInt());
            System.out.print("Результат: " );
            sportsman.addResult(scanner.nextInt());
            System.out.print("Медаль: " );
            sportsman.addAward(scanner.next());
        }
    }
    public static void fifth(){
        try {
            Document document =  newDoc("Data_sportsman.xml");
            Document document_new  = newDoc();
            Element rootElement = document_new.createElement("Sportsmen");
            document_new.appendChild(rootElement);
            Node root = document.getDocumentElement();
            NodeList nodeList = root.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                second();
                Sportsman sportsman = arrayList.get(i);
                int sum = 0;
                int j = 0;
                while (sportsman.getResult(j)!=-1){
                    sum+=sportsman.getResult(j);
                    j++;
                }
                Element element = document_new.createElement("Sportsman");
                Element element1 = document_new.createElement("events");
                Element element2 = document_new.createElement("results");
                element2.appendChild(document_new.createTextNode(String.valueOf(sum)));
                element1.setAttribute("number", String.valueOf(j));
                element1.appendChild(element2);
                if (node.hasAttributes()) {
                    element.setAttribute("name", node.getAttributes().getNamedItem("name").getTextContent());
                    element.appendChild(element1);
                    rootElement.appendChild(element);
                }
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            DOMSource source = new DOMSource(document_new);
            StreamResult file = new StreamResult(new File("New_data.xml"));
            transformer.transform(source,file);
        } catch (SAXException | IOException | ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
    public static Document newDoc() throws ParserConfigurationException {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    }
    public static Document newDoc(String string) throws ParserConfigurationException, IOException, SAXException {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(string);
    }
}
