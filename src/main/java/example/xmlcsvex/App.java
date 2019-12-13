package example.xmlcsvex;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class App 
{
//
//    public static void main( String[] args ) throws Exception
//    {
//        System.out.println( "Hello World!" );
//
//        testXml();
//        testCsv(true);
//        testCsv(false);
//    }
//
//    static void testCsv(boolean withHeader) throws Exception{
//    	Leg leg1 = testPerson1(); // test data
//    	Leg leg2 = testPerson2(); // test data
//
//    	List<Leg> legs = Arrays.asList(leg1, leg2);
//
//    	CsvMapper csvMapper = new CsvMapper();
//		csvMapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN,true);
//
//    	CsvSchema csvSchema =  CsvSchema.builder()
//    			.addColumn("id")
//    			.addColumn("name")
//    			.addArrayColumn("phoneNumbers", " ")
//    			.build();
//
//    	if(withHeader) csvSchema  = csvSchema.withHeader();
//
//    	ByteArrayOutputStream out = new ByteArrayOutputStream();
//    	csvMapper.writerFor(Leg.class).with(csvSchema).writeValuesAsArray(out).writeAll(legs);
//    	String csv = out.toString();
//
//
//
//    	System.out.println("csv:\n" +  csv);
//
//    	MappingIterator<Leg> mappingIterator =  csvMapper.readerFor(Leg.class).with(csvSchema).readValues(csv);
//
//    	List<Leg> readedLegs = mappingIterator.readAll();
//
//    	for(Leg leg : readedLegs) {
//			System.out.println(leg);
//    	}
//    }
//
//
//
//    static void testXml() throws Exception{
//    	Leg leg1 = testPerson1(); // test data
//    	Leg leg2 = testPerson2(); // test data
//    	Leg leg = new Leg();
//    	leg.setPerson(Arrays.asList(leg1, leg2));
//
//
//    	XmlMapper xmlMapper = new XmlMapper();
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        xmlMapper.writeValue(byteArrayOutputStream, leg);
//
//        String xml = byteArrayOutputStream.toString();
//        System.out.println("xml:" +  xml);
//
//		Leg readedLeg = xmlMapper.readValue(xml, Leg.class);
//		for(Leg person : readedLeg.getPerson()) {
//			System.out.println(person);
//		}
//
//		String xml2 = "<Persons><person attr1=\"b\"><b>a</b><id>1</id><phoneNumbers>123-456</phoneNumbers><phoneNumbers>456-789</phoneNumbers></person><person><id>2</id><name>아무개</name><phoneNumbers>223-456</phoneNumbers><phoneNumbers>226-789</phoneNumbers></person></Persons>";
//		System.out.println("xml2:" +  xml2);
//		//xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        Leg readedLeg2 = xmlMapper.readValue(xml2, Leg.class);
//        for(Leg person : readedLeg2.getPerson()) {
//			System.out.println(person);
//    	}
//    }
//
//	private static Leg testPerson1() {
//		Leg leg = new Leg();
//		leg.setId(1);
//		leg.setName("홍길동");
//		ArrayList<String> phoneNumbers = new ArrayList<String>();
//		phoneNumbers.add("123-456");
//		phoneNumbers.add("456-789");
//
//		leg.setPhoneNumbers(phoneNumbers);
//
//		return leg;
//	}
//
//	private static Leg testPerson2() {
//		Leg leg = new Leg();
//		leg.setId(2);
//		leg.setName("아,무\"개");
//		ArrayList<String> phoneNumbers = new ArrayList<String>();
//		phoneNumbers.add("223-456");
//		phoneNumbers.add("226-789");
//
//		leg.setPhoneNumbers(phoneNumbers);
//
//		return leg;
//	}
}
