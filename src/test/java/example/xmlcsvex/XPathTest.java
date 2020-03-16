package example.xmlcsvex;

import example.xmlcsvex.xpath.XPathToDbSchema;
import example.xmlcsvex.xpath.XmlDocument;

import org.junit.Test;
import org.w3c.dom.Document;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.InputStream;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import static org.junit.Assert.*;

public class XPathTest {

    @Test
    public void testXPath() throws Exception {
        String xml =
                "<a>\n" +
                "    <b>\n" +
                "        <c attr1=\"attr_value1\">c_value1</c>\n" +
                "    </b>\n" +
                "    <bb>\n" +
                "        <cc>dd_value1</cc>\n" +
                "    </bb>\n" +
                "</a>";

        XPathToDbSchema schema = new XPathToDbSchema();
        schema.addElement("/a/b/c", "table1.c");
        schema.addElement("/a/b/c[@attr1]", "table1.attr1");
        schema.addElement("/a/bb/cc", "table1.cc", "table2.cc");

        Map<String, Map<String, String>> map = schema.parse(xml);

        System.out.println("map:" + map);
        
        InputStream is = getClass()
                .getClassLoader().getResourceAsStream("KRX_TC IRSwap_IDBTemplate_v0.81.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document doc = documentBuilder.parse(is);

        XPath xPath = XPathFactory.newInstance().newXPath();

        String data =  xPath.compile("ktcRequestConfirmation/dataDocuments/dataDocument/header/messageClassificationID").evaluate(doc);
        System.out.println("messageClassificationID:" + data);
    }
    
    @Test
    public void testXPath2() throws Exception {
    	
    	XPathToDbSchema schema = new XPathToDbSchema();	        
        schema.addElement("ktcRequestConfirmation/dataDocuments/dataDocument/trade/tradeHeader/partyTradeIdentifier/tradeId", "table1.tradeId");    		
        schema.addElement("/a/b/c", "table1.c");
        schema.addElement("/a/b/c[@attr1]", "table1.attr1");
        schema.addElement("/a/bb/cc", "table1.cc", "table2.cc");
        
        InputStream xml = getClass()
                .getClassLoader().getResourceAsStream("KRX_TC IRSwap_IDBTemplate_v0.81.xml");

        //new XmlDocument() 와 같다.
        XmlDocument xmlDoc = new XmlDocument("ktcRequestConfirmation/dataDocuments/dataDocument/header/messageClassificationID");        
        xmlDoc.parse(xml);
        
        System.out.println("messageClassificationID:" + xmlDoc.getMessageClassificationID() );
        
        if("(전문분류ID)".equalsIgnoreCase(xmlDoc.getMessageClassificationID())) {
	        Map<String, Map<String, String>> map = schema.parse(xmlDoc);	        
	        System.out.println("map:" + map);
        }
        else {
        	System.out.println("! (전문분류ID)");
        }
    }

}