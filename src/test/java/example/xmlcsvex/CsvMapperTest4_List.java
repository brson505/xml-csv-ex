package example.xmlcsvex;


import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CsvMapperTest4_List {


    @Test
    public void testList() throws Exception {
        CsvMapper mapper = new CsvMapper();
        mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
//        File csvFile = new File("input.csv"); // or from String, URL etc
//        MappingIterator<String[]> it = mapper.readerFor(String[].class).readValues(csvFile);
//        while (it.hasNext()) {
//            String[] row = it.next();
//            // and voila, column values in an array. Works with Lists as well
//        }

        String csv = "";
        csv += "1,son,111-1111\n";
        csv += "2,rok,222-2222\n";

//        MappingIterator<String[]> it = mapper.readerFor(String[].class).readValues(csv);
//        List<String[]> all = it.readAll();

        MappingIterator<List<String>> it = mapper.readerFor(List.class).readValues(csv);
        List<List<String>> all = it.readAll();

        System.out.println(all);
    }
}
