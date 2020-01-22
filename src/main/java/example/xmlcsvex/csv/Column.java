package example.xmlcsvex.csv;

import java.util.ArrayList;

public class Column {
    private int index;
    private String name;
    private ArrayList<TableColumn> tableColumns = new ArrayList<TableColumn>();

    public Column(int index){
        this.index = index;
    }

    public Column(int index, String name){
        this.index = index;
        this.name = name;
    }

    public Column addTableColumn(String tableColumn){
        String[] a = tableColumn.split("\\.");
        if(a.length==1){
            tableColumns.add(TableColumn.create(a[0], name));
        }
        else if(a.length==2){
            tableColumns.add(TableColumn.create(a[0], a[1]));
        }
        else {
            throw new IllegalArgumentException(tableColumn);
        }
        return this;
    }

    public Column addTableColumn(String...tableColumns){
        for (String tableAndColumnName : tableColumns){
            addTableColumn(tableAndColumnName);
        }
        return this;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public ArrayList<TableColumn> getTableColumns() {
        return tableColumns;
    }

}
