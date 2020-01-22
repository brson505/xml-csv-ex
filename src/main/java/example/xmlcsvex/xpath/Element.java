package example.xmlcsvex.xpath;

import example.xmlcsvex.csv.Column;

import java.util.ArrayList;

class Element {
    private final String xpath;
    private final ArrayList<TableColumn> tableColumns = new ArrayList<TableColumn>();

    public Element(String xpath, String...tableColumns) {
        this.xpath = xpath;
        for (String tableColumn : tableColumns){
            this.tableColumns.add(TableColumn.create(tableColumn));
        }
    }

    public String getXpath() {
        return xpath;
    }

    public ArrayList<TableColumn> getTableColumns() {
        return tableColumns;
    }
}
