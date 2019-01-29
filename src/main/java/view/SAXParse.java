package view;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import view.model.MenuItem;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

public class SAXParse extends DefaultHandler {

    // List to hold Employees object
    private List<MenuItem> empList = null;
    private MenuItem emp = null;
    private StringBuilder data = null;

    // getter method for employee list
    public List<MenuItem> getEmpList() {
        return empList;
    }

//    boolean bAge = false;
//    boolean bName = false;
//    boolean bGender = false;
//    boolean bRole = false;

    boolean bName = false;
    boolean bPrice = false;
    boolean bDescription = false;
    boolean bCalories = false;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("food")) {
            // create a new Employee and put it in Map
            String id = attributes.getValue("id");
            // initialize Employee object and set id attribute
            emp = new MenuItem();
            emp.setId(Integer.parseInt(id));
            // initialize list
            if (empList == null)
                empList = new ArrayList<>();
        } else if (qName.equalsIgnoreCase("name")) {
            // set boolean values for fields, will be used in setting Employee variables
            bName = true;
        } else if (qName.equalsIgnoreCase("price")) {
            bPrice = true;
        } else if (qName.equalsIgnoreCase("description")) {
            bDescription = true;
        } else if (qName.equalsIgnoreCase("calories")) {
            bCalories = true;
        }
        // create the data container

        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bName) {
            // age element, set Employee age
            emp.setName(data.toString());
           // System.out.println(" NAME: " + emp.getName());
            bName = false;
        } else if (bPrice) {
            emp.setPrice(Float.parseFloat(data.toString()));
            //System.out.println(" PRICE: " + emp.getPrice());
            bPrice = false;
        } else if (bDescription) {
            emp.setDescription(data.toString());
            //System.out.println(" DESC: " + emp.getDescription());
            bDescription = false;
        } else if (bCalories) {
            emp.setCalories(Float.parseFloat(data.toString()));
            //System.out.println(" CAL: " + emp.getCalories());
            bCalories = false;
        }

        if (qName.equalsIgnoreCase("food")) {
            // add Employee object to list
            empList.add(emp);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }

}
