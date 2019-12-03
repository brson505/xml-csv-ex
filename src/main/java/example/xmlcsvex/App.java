package example.xmlcsvex;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        
        testXml();
        testCsv(true);
        testCsv(false);
    }
    
    static void testCsv(boolean withHeader) throws Exception{
    	Person person1 = testPerson1(); // test data
    	Person person2 = testPerson2(); // test data
    	
    	List<Person> persons = Arrays.asList(person1, person2);
    	
    	CsvMapper csvMapper = new CsvMapper();
    	
    	CsvSchema csvSchema =  CsvSchema.builder()
    			.addColumn("id")
    			.addColumn("name")
    			.addArrayColumn("phoneNumbers", " ")    			
    			.build();
    	
    	if(withHeader) csvSchema  = csvSchema.withHeader();
    	
    	ByteArrayOutputStream out = new ByteArrayOutputStream();
    	csvMapper.writerFor(Person.class).with(csvSchema).writeValuesAsArray(out).writeAll(persons);
    	String csv = out.toString();
    	
    	
        
    	System.out.println("csv:\n" +  csv);
    	
    	MappingIterator<Person> mappingIterator =  csvMapper.readerFor(Person.class).with(csvSchema).readValues(csv);
    	
    	List<Person> readedPersons = mappingIterator.readAll(); 
    	
    	for(Person person : readedPersons) {
    		printPerson(person);
    	}
    }
        

        
    static void testXml() throws Exception{
    	Person person1 = testPerson1(); // test data
    	Person person2 = testPerson2(); // test data
    	Persons persons = new Persons();
    	persons.setPerson(Arrays.asList(person1, person2));
    	
    	
    	XmlMapper xmlMapper = new XmlMapper();        
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xmlMapper.writeValue(byteArrayOutputStream, persons);
        
        String xml = byteArrayOutputStream.toString();
        System.out.println("xml:" +  xml);
        
        Persons readedPersons = xmlMapper.readValue(xml, Persons.class);
        
        for(Person person : readedPersons.getPerson()) {
    		printPerson(person);
    	}
    }
    
    static void printPerson(Person person) {
    	System.out.println("id: " +  person.getId());
    	System.out.println("name: " +  person.getName());
        System.out.println("phoneNumbers: " +  person.getPhoneNumbers());
    }

	private static Person testPerson1() {
		Person person = new Person();
		person.setId(1);
		person.setName("홍길동");
		ArrayList<String> phoneNumbers = new ArrayList<String>();
		phoneNumbers.add("123-456");
		phoneNumbers.add("456-789");
				
		person.setPhoneNumbers(phoneNumbers);
		
		return person;
	}
	
	private static Person testPerson2() {
		Person person = new Person();
		person.setId(2);
		person.setName("아,무\"개");
		ArrayList<String> phoneNumbers = new ArrayList<String>();
		phoneNumbers.add("223-456");
		phoneNumbers.add("226-789");
				
		person.setPhoneNumbers(phoneNumbers);
		
		return person;
	}
}
