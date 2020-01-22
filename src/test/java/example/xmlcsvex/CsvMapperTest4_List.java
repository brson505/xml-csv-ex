package example.xmlcsvex;


import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import example.xmlcsvex.csv.CsvToDbSchema;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CsvMapperTest4_List {


    @Test
    public void testList() throws Exception {
        CsvMapper mapper = new CsvMapper();
        mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
        String csv = "";
        csv += "1,son,111-1111,222-2222\n";
        csv += "2,rok,333-3333, 444-4444\n";

        MappingIterator<String[]> it = mapper.readerFor(String[].class).readValues(csv);
        List<String[]> all = it.readAll();

        CsvToDbSchema schema = new CsvToDbSchema();
        schema.addColumn(0, "id").addTableColumn("table1", "table3-0","table3-1");
        schema.addColumn(1, "name").addTableColumn("table1", "table2");
        schema.addColumn(2, "phone1").addTableColumn("table2", "table3-0.phone");
        schema.addColumn(3, "phone2").addTableColumn("table2", "table3-1.phone");

        for(String[] columns : all){
            for(String column : columns){
                System.out.print(column +", ");
            }
            System.out.println();
        }

        ArrayList<Map<String, Map<String, String>>>  dataSetMapList = new ArrayList<Map<String, Map<String, String>>>();
        for (String[] columns : all){
            Map<String, Map<String, String>> p = schema.parse(columns);
            System.out.println(p);
            dataSetMapList.add(p);
        }

        Map<String, String> table1 = dataSetMapList.get(0).get("table1");
        assertEquals(2, table1.size());
        assertEquals("1", table1.get("id"));
        assertEquals("son", table1.get("name"));

        Map<String, String> table2 = dataSetMapList.get(0).get("table2");
        assertEquals(3, table2.size());
        assertEquals("son", table2.get("name"));
        assertEquals("111-1111", table2.get("phone1"));
        assertEquals("222-2222", table2.get("phone2"));


        Map<String, String> table3_0 = dataSetMapList.get(0).get("table3-0");
        assertEquals(2, table3_0.size());
        assertEquals("1", table3_0.get("id"));
        assertEquals("111-1111", table3_0.get("phone"));

        Map<String, String> table3_1 = dataSetMapList.get(0).get("table3-1");
        assertEquals(2, table3_1.size());
        assertEquals("1", table3_0.get("id"));
        assertEquals("222-2222", table3_1.get("phone"));


    }
}
