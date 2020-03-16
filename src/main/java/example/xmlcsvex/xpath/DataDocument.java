package example.xmlcsvex.xpath;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DataDocument {
	
	private Node node;
	private String messageClassificationID;
	private XPath xpath;

	public DataDocument(Node node) throws XPathExpressionException {
		this.node = node;		
		this.xpath = XPathFactory.newInstance().newXPath();
        this.messageClassificationID = xpath.evaluate("./header/messageClassificationID", this.node); 
	}

	public Node getNode() {
		return node;
	}
	
	public String getMessageClassificationID() {
		return messageClassificationID;
	}
		
	public Map<String, Map<String, String>> parse(XPathToDbSchema schema) throws ParserConfigurationException, XPathExpressionException, IOException, SAXException {
		Map<String, Map<String, String>> dataSetMap = new HashMap<String, Map<String, String>>();
    	
		for (Element e : schema.getElements()){
             String data =  xpath.evaluate(e.getXpath(), node);
             for(TableColumn tableColumn : e.getTableColumns()) {
                 set(dataSetMap, tableColumn, data);
             }
         }

         return dataSetMap;
    }
	
	private void set(Map<String, Map<String, String>> dataSetMap, TableColumn tableColumn, String data) {
        Map<String, String> dataSet = dataSetMap.get(tableColumn.getTable());
        if(dataSet == null){
            dataSet = new HashMap<String, String>();
            dataSetMap.put(tableColumn.getTable(), dataSet);
        }
        dataSet.put(tableColumn.getColumn(), data);
    }
	
}
