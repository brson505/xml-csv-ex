package example.xmlcsvex;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import example.xmlcsvex.Leg;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class XmlMapperTest {
    @Test
    public void testXml() throws Exception {
        Data data = new Data();
        {
            Leg leg = new Leg();

            leg.setIdbFee(12.12335);
            FundLEI fundLEI = new FundLEI();
            fundLEI.setId(1);
            fundLEI.setValue("ISO17442");
            leg.setFundLEI(fundLEI);

            data.addLeg(leg);
        }
        {
            Leg leg = new Leg();

            leg.setIdbFee(13.12335);
            FundLEI fundLEI = new FundLEI();
            fundLEI.setId(2);
            fundLEI.setValue("ISO17442");
            leg.setFundLEI(fundLEI);

            data.addLeg(leg);
        }

        XmlMapper xmlMapper = new XmlMapper();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xmlMapper.writeValue(byteArrayOutputStream, data);

        String xml = byteArrayOutputStream.toString();
        System.out.println("xml:" +  xml);

        String xml2 = "<Data><Leg><idbFee>12.12335</idbFee><fundLEI id=\"1\">ISO17442</fundLEI></Leg><Leg><idbFee>13.12335</idbFee><fundLEI id=\"2\">ISO17442</fundLEI></Leg></Data>";
        System.out.println("xml2:" +  xml2);

        Data data2 = xmlMapper.readValue(xml2, Data.class);
        System.out.println(data2.getLegs());
    }
}
