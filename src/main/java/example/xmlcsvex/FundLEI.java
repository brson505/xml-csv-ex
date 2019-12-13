package example.xmlcsvex;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import javax.xml.bind.annotation.XmlAttribute;

public class FundLEI {

    @JacksonXmlProperty(isAttribute = true)
    private int id;

    @JacksonXmlText
    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "fundLEI{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
