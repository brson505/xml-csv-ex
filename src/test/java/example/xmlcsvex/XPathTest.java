package example.xmlcsvex;

import example.xmlcsvex.xpath.XPathToDbSchema;
import org.junit.Test;
import java.io.InputStream;
import java.util.Map;

import static org.junit.Assert.*;

public class XPathTest {

    @Test
    public void testXPath() throws Exception {
        String xml =
                "<a>\n" +
                "    <b>\n" +
                "        <c attr1=\"attr_value1\">c_value1</c>\n" +
                "    </b>\n" +
                "    <bb>\n" +
                "        <cc>dd_value1</cc>\n" +
                "    </bb>\n" +
                "</a>";

        XPathToDbSchema schema = new XPathToDbSchema();
        schema.addElement("/a/b/c", "table1.c");
        schema.addElement("/a/b/c[@attr1]", "table1.attr1");
        schema.addElement("/a/bb/cc", "table1.cc", "table2.cc");

        Map<String, Map<String, String>> map = schema.parse(xml);

        System.out.println("map:" + map);
    }

}