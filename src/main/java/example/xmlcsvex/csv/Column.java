package example.xmlcsvex.csv;

import java.util.ArrayList;

public class Column {
    private int index;
    private String name;
    private ArrayList<Db> dbs = new ArrayList<Db>();

    public Column(int index){
        this.index = index;
    }

    public Column(int index, String name){
        this.index = index;
        this.name = name;
    }

    public Column addDb(String tableAndColumnName){
        String[] a = tableAndColumnName.split("\\.");
        if(a.length==1){
            dbs.add(new Db(a[0], name));
        }
        else if(a.length==2){
            dbs.add(new Db(a[0], a[1]));
        }
        else {
            throw new IllegalArgumentException(tableAndColumnName);
        }
        return this;
    }

    public Column addDb(String...tableAndColumnNames){
        for (String tableAndColumnName : tableAndColumnNames){
            addDb(tableAndColumnName);
        }
        return this;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Db> getDbs() {
        return dbs;
    }

    protected class Db {
        String table;
        String column;
        protected Db(String table, String column) {
            this.table = table;
            this.column = column;
        }

        public String getTable() {
            return table;
        }

        public String getColumn() {
            return column;
        }
    }
}
