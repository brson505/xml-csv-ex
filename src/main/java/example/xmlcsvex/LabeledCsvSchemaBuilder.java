package example.xmlcsvex;

import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.util.*;

public class LabeledCsvSchemaBuilder {
    private Map<String, List<String>> labelNamesMap = new HashMap<String, List<String>>();
    private ArrayList<String> names = new ArrayList();

    public LabeledCsvSchemaBuilder addColumn(String label, String name){
        names.add(name);
        List<String> labelNames = labelNamesMap.get(label);
        if(labelNames==null) {
            labelNames = new ArrayList<String>();
            labelNamesMap.put(label, labelNames);
        }
        labelNames.add(name);

        return this;
    }
    public CsvSchema build(){
        CsvSchema.Builder builder = CsvSchema.builder();
        for(String name : names){
            builder.addColumn(name);
        }
        return builder.build();
    }
    public List<String> getLabeledNames(String label){
        return labelNamesMap.get(label);
    }

    Set<String> getLabels(){
        return labelNamesMap.keySet();
    }
}
