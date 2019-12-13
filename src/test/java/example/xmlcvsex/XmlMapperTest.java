package example.xmlcvsex;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import example.xmlcsvex.Person;
import example.xmlcsvex.Persons;
import example.xmlcsvex.Splitter;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class XmlMapperTest {
    @Test
    public void testMap() throws Exception {
        XmlMapper xmlMapper = new XmlMapper();

        String xml2 = "<Persons><person attr1=\"b\"><id >1</id><apple name=\"b\">2</apple><phoneNumbers>123-456</phoneNumbers><phoneNumbers>456-789</phoneNumbers></person><person><id>2</id><name>아무개</name><phoneNumbers>223-456</phoneNumbers><phoneNumbers>226-789</phoneNumbers></person></Persons>";
        System.out.println("xml2:" +  xml2);
        //xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Persons readedPersons2 = xmlMapper.readValue(xml2, Persons.class);
        System.out.println(readedPersons2.getPerson());
    }
}
