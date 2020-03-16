package example.xmlcsvex;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import example.xmlcsvex.xpath.DataDocument;
import example.xmlcsvex.xpath.KtcRequestConfirmation;
import example.xmlcsvex.xpath.XPathToDbSchema;

public class XPathTest2 {
    
    @Test
    public void testXPath() throws Exception {
    	
    	XPathToDbSchema schema = new XPathToDbSchema();	        
        schema.addElement("./trade/tradeHeader/partyTradeIdentifier/tradeId", "table1.a");
        
        
        XPathToDbSchema schema2 = new XPathToDbSchema();	        
        schema2.addElement("./trade/tradeHeader/partyTradeIdentifier/tradeId", "table2.a");
        
        
        InputStream xml = getClass()
                .getClassLoader().getResourceAsStream("KRX_TC IRSwap_IDBTemplate_v0.81.xml");

        KtcRequestConfirmation ktcRequestConfirmation = new KtcRequestConfirmation();        
        List<DataDocument> dataDocuments = ktcRequestConfirmation.parse(xml);
        
        for(DataDocument dataDocument : dataDocuments) {
        	System.out.println("messageClassificationID: " + dataDocument.getMessageClassificationID() );
        	 if("(전문분류ID)".equals(dataDocument.getMessageClassificationID())) {
        		 Map<String, Map<String, String>> map = dataDocument.parse(schema);
        		 System.out.println("map: " + map);
             }
             else if ("(전문분류ID)2".equals(dataDocument.getMessageClassificationID())) {
            	 Map<String, Map<String, String>> map = dataDocument.parse(schema2);
            	 System.out.println("map: " + map);
             }
             else {
            	 System.out.println("unknown");
             }
        }
        
        
       
    }
    

}