package example.xmlcsvex.csv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvToDbSchema {
    private final ArrayList<Column> columns = new ArrayList<Column>();
    public Column addColumn(String name){
        int index = this.columns.size();
        return addColumn(index, name);
    }
    public Column addColumn(int index, String name){
        Column c = new Column(index, name);
        this.columns.add(c);
        return c;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public Map<String, Map<String, String>> parse(String[] columns){
        Map<String, Map<String, String>> dataSetMap = new HashMap<String, Map<String, String>>();

        for (Column c : getColumns()){
            int index = c.getIndex();
            String data = columns[index];

            for(TableColumn tableColumn : c.getTableColumns()){
                set(dataSetMap, tableColumn, data);
            }
        }

        return dataSetMap;
    }

    private void set(Map<String, Map<String, String>> dataSetMap, TableColumn tableColumn, String data) {
        Map<String, String> dataSet = dataSetMap.get(tableColumn.getTable());
        if(dataSet == null){
            dataSet = new HashMap<String, String>();
            dataSetMap.put(tableColumn.getTable(), dataSet);
        }
        dataSet.put(tableColumn.getColumn(), data);
    }
}
