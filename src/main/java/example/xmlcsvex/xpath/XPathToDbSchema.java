package example.xmlcsvex.xpath;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XPathToDbSchema {
    private final ArrayList<Element> elements = new ArrayList<Element>();
    public Element addElement(String xpath, String...tableColumns){
        Element e = new Element(xpath, tableColumns);
        this.elements.add(e);
        return e;
    }

    public List<Element> getElements() {
        return elements;
    }


    //deprecated
    public Map<String, Map<String, String>> parse(String str) throws ParserConfigurationException, XPathExpressionException, IOException, SAXException {
        return parse(new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8)));
    }

    //deprecated
    public Map<String, Map<String, String>> parse(InputStream is) throws ParserConfigurationException, XPathExpressionException, IOException, SAXException {
        
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document doc = documentBuilder.parse(is);

       return parse(doc);
    }
    
    //deprecated
    public Map<String, Map<String, String>> parse(XmlDocument doc) throws ParserConfigurationException, XPathExpressionException, IOException, SAXException {        
       return parse(doc.getDocument());
    }
    
    //deprecated
    public Map<String, Map<String, String>> parse(Document doc) throws ParserConfigurationException, XPathExpressionException, IOException, SAXException {
    	Map<String, Map<String, String>> dataSetMap = new HashMap<String, Map<String, String>>();
    	
    	XPath xPath = XPathFactory.newInstance().newXPath();

         for (Element e : getElements()){
             String data =  xPath.compile(e.getXpath()).evaluate(doc);
             for(TableColumn tableColumn : e.getTableColumns()) {
                 set(dataSetMap, tableColumn, data);
             }
         }

         return dataSetMap;
    }

    //deprecated
    private void set(Map<String, Map<String, String>> dataSetMap, TableColumn tableColumn, String data) {
        Map<String, String> dataSet = dataSetMap.get(tableColumn.getTable());
        if(dataSet == null){
            dataSet = new HashMap<String, String>();
            dataSetMap.put(tableColumn.getTable(), dataSet);
        }
        dataSet.put(tableColumn.getColumn(), data);
    }
}
