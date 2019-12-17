package example.xmlcsvex.csv;

import java.util.ArrayList;
import java.util.List;

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
}
