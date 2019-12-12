package example.xmlcvsex;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CsvMapperTest {

    //중복은 있지만 가장 간단한 분리
    @Test
    public void testMap() throws IOException {

        CsvMapper csvMapper = new CsvMapper();
        csvMapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN,true);

        CsvSchema csvSchema =  CsvSchema.builder()
                .addColumn("id")
                .addColumn("name")
                .addColumn("phoneNumber")
                .build();

        String csv = "";
        csv += "1,son,111-1111\n";
        csv += "2,rok,222-2222\n";

        MappingIterator<Map<String, String>> mappingIterator =  csvMapper.readerFor(Map.class).with(csvSchema).readValues(csv);

        List<Map<String, String>> readedPersons = mappingIterator.readAll();

        for(Map person : readedPersons) {
            System.out.println(person);
        }

        assertEquals("1", readedPersons.get(0).get("id"));
        assertEquals("son", readedPersons.get(0).get("name"));
        assertEquals("111-1111", readedPersons.get(0).get("phoneNumber"));

        assertEquals("2", readedPersons.get(1).get("id"));
        assertEquals("rok", readedPersons.get(1).get("name"));
        assertEquals("222-2222", readedPersons.get(1).get("phoneNumber"));

        String map1names[] = {"id", "name"};
        String map2names[] = {"phoneNumber"};

        List<Map<String, String>> map1List = new ArrayList<Map<String, String>>();
        List<Map<String, String>> map2List = new ArrayList<Map<String, String>>();

        for(Map person : readedPersons) {
            Map<String, String> map1 = extractMap(person, map1names);
            Map<String, String> map2 = extractMap(person, map2names);
            map1List.add(map1);
            map2List.add(map2);
        }

        assertEquals("1", map1List.get(0).get("id"));
        assertEquals("son", map1List.get(0).get("name"));
        assertNull(map1List.get(0).get("phoneNumber"));

        assertNull(map2List.get(0).get("id"));
        assertNull(map2List.get(0).get("name"));
        assertEquals("111-1111", map2List.get(0).get("phoneNumber"));
    }

    private Map<String, String> extractMap(Map<String, String> person, String[] map1names) {
        Map<String, String> map = new LinkedHashMap<String, String>();
        for(String name : map1names){
            map.put(name, person.get(name));
        }
        return map;
    }
}
