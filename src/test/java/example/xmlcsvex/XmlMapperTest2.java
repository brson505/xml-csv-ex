package example.xmlcsvex;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import example.xmlcsvex.spec.KtcRequestConfirmation;
import org.junit.Test;

import java.io.InputStream;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class XmlMapperTest2 {
    @Test
    public void testXml() throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        InputStream in = getClass()
                .getClassLoader().getResourceAsStream("KRX_TC IRSwap_IDBTemplate_v0.81.xml");

        Map map = xmlMapper.readValue(in, Map.class);
        System.out.println(map);

    }

    @Test
    public void testXml2() throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        InputStream in = getClass()
                .getClassLoader().getResourceAsStream("KRX_TC IRSwap_IDBTemplate_v0.81.xml");

        KtcRequestConfirmation ktcRequestConfirmation = xmlMapper.readValue(in, KtcRequestConfirmation.class);
        System.out.println(ktcRequestConfirmation);
        assertEquals("unbounded", ktcRequestConfirmation.dataDocuments.get(0).trade.IRSwap.swapStream2.common.terminationDate.dateAdjustments.businessCenters.get(0).maxOccurs);

    }
}