package example.xmlcsvex.csv;

public class TableColumn {
    private String table;
    private String column;

    public TableColumn(String table, String column) {
        this.table = table;
        this.column = column;
    }

    public static TableColumn create(String table, String column) {
       return new TableColumn(table, column);
    }

    public String getTable() {
        return table;
    }

    public String getColumn() {
        return column;
    }
}
