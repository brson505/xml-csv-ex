package example.xmlcvsex;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import example.xmlcsvex.Splitter;
import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CsvMapperTest3 {
    @Test
    public void testMap() throws Exception {

        CsvMapper csvMapper = new CsvMapper();
        //csvMapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN,true);

        CsvSchema csvSchema =  CsvSchema.builder()
                .addColumn("map1.id")
                .addColumn("map1.name")
                .addColumn("map2.phoneNumber")
                .build();

        String csv = "";
        csv += "1,son,111-1111\n";
        csv += "2,rok,222-2222\n";

        MappingIterator<Map<String, String>> mappingIterator =  csvMapper.readerFor(Map.class).with(csvSchema).readValues(csv);

        List<Map<String, String>> readedPersons = mappingIterator.readAll();

        System.out.println(readedPersons);

        Map<String, List<Map<String, String>>> map = Splitter.split(readedPersons);

        System.out.println(map);

        assertEquals("1", map.get("map1").get(0).get("id"));
        assertEquals("son", map.get("map1").get(0).get("name"));
        assertEquals("111-1111", map.get("map2").get(0).get("phoneNumber"));

        assertNull("1", map.get("map2").get(0).get("id"));
        assertNull("son", map.get("map2").get(0).get("name"));
        assertNull("111-1111", map.get("map1").get(0).get("phoneNumber"));
    }
}
