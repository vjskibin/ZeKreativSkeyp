package view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import view.model.MenuItem;

public  class XMLManager {


    public static void addMenuItem() {

        try {
            File fXmlFile = new File("src/main/resources/check.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("food");

            Element root = doc.getDocumentElement();
            Collection<MenuItem> servers = new ArrayList<MenuItem>();
            servers.add(new MenuItem());

            for (MenuItem server : servers) {
                // server elements
                Element newServer = doc.createElement("food");

                Element name = doc.createElement("name");
                name.appendChild(doc.createTextNode(server.getName()));
                newServer.appendChild(name);

                Element price = doc.createElement("price");
                price.appendChild(doc.createTextNode(Float.toString(server.getPrice())));
                newServer.appendChild(price);

                Element description = doc.createElement("description");
                description.appendChild(doc.createTextNode(Float.toString(server.getPrice())));
                newServer.appendChild(description);

                Element calories = doc.createElement("calories");
                calories.appendChild(doc.createTextNode(Float.toString(server.getPrice())));
                newServer.appendChild(calories);

                root.appendChild(newServer);
            }

            DOMSource source = new DOMSource(doc);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult("check.xml");
            transformer.transform(source, result);


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }

    private static void addElement(Document doc) {
        NodeList employees = doc.getElementsByTagName("Employee");
        Element emp = null;

        //loop for each employee
        for(int i=0; i<employees.getLength();i++){
            emp = (Element) employees.item(i);
            Element salaryElement = doc.createElement("salary");
            salaryElement.appendChild(doc.createTextNode("10000"));
            emp.appendChild(salaryElement);
        }
    }

    private static void deleteElement(Document doc) {
        NodeList employees = doc.getElementsByTagName("Employee");
        Element emp = null;
        //loop for each employee
        for(int i=0; i<employees.getLength();i++){
            emp = (Element) employees.item(i);
            Node genderNode = emp.getElementsByTagName("gender").item(0);
            emp.removeChild(genderNode);
        }

    }

    private static void updateElementValue(Document doc) {
        NodeList employees = doc.getElementsByTagName("Employee");
        Element emp = null;
        //loop for each employee
        for(int i=0; i<employees.getLength();i++){
            emp = (Element) employees.item(i);
            Node name = emp.getElementsByTagName("name").item(0).getFirstChild();
            name.setNodeValue(name.getNodeValue().toUpperCase());
        }
    }

    private static void updateAttributeValue(Document doc) {
        NodeList employees = doc.getElementsByTagName("Employee");
        Element emp = null;
        //loop for each employee
        for(int i=0; i<employees.getLength();i++){
            emp = (Element) employees.item(i);
            String gender = emp.getElementsByTagName("gender").item(0).getFirstChild().getNodeValue();
            if(gender.equalsIgnoreCase("male")){
                //prefix id attribute with M
                emp.setAttribute("id", "M"+emp.getAttribute("id"));
            }else{
                //prefix id attribute with F
                emp.setAttribute("id", "F"+emp.getAttribute("id"));
            }
        }
    }

}