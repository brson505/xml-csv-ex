package example.xmlcsvex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Splitter {

    public static Map<String, List<Map<String, String>>> split(List<Map<String, String>> listmap) {
        Map<String, List<Map<String, String>>> maplistmap = new HashMap<String, List<Map<String, String>>>();
        for (Map<String, String> map : listmap) {
            Map<String, Map<String, String>> mapmap = split(map);
            for (String label : mapmap.keySet()) {
                List<Map<String, String>> list = maplistmap.get(label);
                if (list == null) {
                    list = new ArrayList<Map<String, String>>();
                    maplistmap.put(label, list);
                }
                list.add(mapmap.get(label));
            }
        }
        return maplistmap;
    }


    public static Map<String, Map<String, String>> split(Map<String, String> in) {
        Map<String, Map<String, String>> mapmap = new HashMap<String, Map<String, String>>();
        for(String key : in.keySet()){
            String[] labelAndName = key.split("\\.");
            if(labelAndName.length!=2) throw new IllegalArgumentException(key);
            String label = labelAndName[0];
            String name = labelAndName[1];
            Map<String, String> splitMap = mapmap.get(labelAndName[0]);
            if(splitMap==null){
                splitMap = new HashMap<String, String>();
                mapmap.put(label, splitMap);
            }
            splitMap.put(name, in.get(key));
        }
        return mapmap;
    }
}
