package example.xmlcsvex.csv;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    private CsvToDbSchema schema;

    public Parser(CsvToDbSchema schema){
        this.schema =  schema;
    }

    public Map<String, Map<String, String>> parse(String[] columns){
        Map<String, Map<String, String>> dataSetMap = new HashMap<String, Map<String, String>>();

        for (Column c : schema.getColumns()){
            int index = c.getIndex();
            String data = columns[index];

            for(Column.Db db : c.getDbs()){
                set(dataSetMap, db.getTable(), db.getColumn(), data);
            }
        }

        return dataSetMap;
    }

    private void set(Map<String, Map<String, String>> dataSetMap, String tableName, String columnName, String data) {
        Map<String, String> dataSet = dataSetMap.get(tableName);
        if(dataSet == null){
            dataSet = new HashMap<String, String>();
            dataSetMap.put(tableName, dataSet);
        }
        dataSet.put(columnName, data);
    }
}
