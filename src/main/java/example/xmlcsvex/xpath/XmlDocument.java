package example.xmlcsvex.xpath;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

//deprecated
public class XmlDocument {

    private String messageClassificationID;
	private Document document;
	private String messageClassificationIDXPath;
	
	public XmlDocument(){
		this.messageClassificationIDXPath = "ktcRequestConfirmation/dataDocuments/dataDocument/header/messageClassificationID";
	}
	
	public XmlDocument(String messageClassificationIDXPath){
		this.messageClassificationIDXPath = messageClassificationIDXPath;
	}

	public void parse(String str) throws ParserConfigurationException, XPathExpressionException, IOException, SAXException {
        parse(new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8)));
    }

    public void parse(InputStream is) throws ParserConfigurationException, XPathExpressionException, IOException, SAXException {
        
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        this.document = documentBuilder.parse(is);
        
        XPath xPath = XPathFactory.newInstance().newXPath();        
        this.messageClassificationID =  xPath.compile(messageClassificationIDXPath).evaluate(this.document);        
    }
    
    public String getMessageClassificationID() {
		return messageClassificationID;
	}

	public Document getDocument() {
		return document;
	}

}