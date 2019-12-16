package example.xmlcsvex;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

public class XmlMapperTest2 {
    @Test
    public void testXml() throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        InputStream in = getClass()
                .getClassLoader().getResourceAsStream("KRX_TC IRSwap_IDBTemplate_v0.81.xml");

        Map map = xmlMapper.readValue(in, Map.class);
        System.out.println(map);

    }
}