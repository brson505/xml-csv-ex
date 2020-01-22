package example.xmlcsvex.xpath;

class TableColumn {
    private String table;
    private String column;

    public TableColumn(String table, String column) {
        this.table = table;
        this.column = column;
    }

    public static TableColumn create(String table, String column) {
       return new TableColumn(table, column);
    }

    public static TableColumn create(String tableColumn) {
        String[] t = tableColumn.split("\\.");
        if(t.length!=2) {
           throw new IllegalArgumentException("invalid tableColum:" + tableColumn);
        }
        return new TableColumn(t[0], t[1]);
    }

    public String getTable() {
        return table;
    }

    public String getColumn() {
        return column;
    }
}
