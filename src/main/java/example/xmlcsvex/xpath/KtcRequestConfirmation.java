package example.xmlcsvex.xpath;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class KtcRequestConfirmation {
	
	public List<DataDocument> parse(String str) throws ParserConfigurationException, XPathExpressionException, IOException, SAXException {
        return parse(new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8)));
    }

    public List<DataDocument> parse(InputStream is) throws ParserConfigurationException, XPathExpressionException, IOException, SAXException {
        
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(is);
        
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList nodeList =  (NodeList) xPath.evaluate("/ktcRequestConfirmation/dataDocuments/dataDocument", document, XPathConstants.NODESET);
        
        ArrayList<DataDocument> dataDocuments = new ArrayList<DataDocument>();
        
        for(int i=0; i<nodeList.getLength(); i++) {
        	dataDocuments.add(new DataDocument(nodeList.item(i)));
        }
        
        return dataDocuments;
    }
    

}
