package example.xmlcsvex;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import example.xmlcsvex.LabeledCsvSchemaBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CsvMapperTest2 {


    //CsvSchema 생성할때 별도의 분리정보(label) 포함하여 생성하고
    //파싱후 분리정보를 이용하여 분리
    @Test
    public void testMap() throws IOException {

        CsvMapper csvMapper = new CsvMapper();
        csvMapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN,true);

        LabeledCsvSchemaBuilder builder = new LabeledCsvSchemaBuilder();
        builder.addColumn("map1", "id");
        builder.addColumn("map1", "name");
        builder.addColumn("map2", "phoneNumber");

        CsvSchema csvSchema = builder.build();

        String csv = "";
        csv += "1,son,111-1111\n";
        csv += "2,rok,222-2222\n";

        MappingIterator<Map<String, String>> mappingIterator =  csvMapper.readerFor(Map.class).with(csvSchema).readValues(csv);

        List<Map<String, String>> readedPersons = mappingIterator.readAll();

        List<Map<String, String>> map1List = new ArrayList<Map<String, String>>();
        List<Map<String, String>> map2List = new ArrayList<Map<String, String>>();

        for(Map person : readedPersons) {
            Map<String, String> map1 = extractMap(person, builder.getLabeledNames("map1"));
            Map<String, String> map2 = extractMap(person, builder.getLabeledNames("map2"));
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

    private Map<String, String> extractMap(Map<String, String> person, List<String> map1names) {
        Map<String, String> map = new LinkedHashMap<String, String>();
        for(String name : map1names){
            map.put(name, person.get(name));
        }
        return map;
    }
}
