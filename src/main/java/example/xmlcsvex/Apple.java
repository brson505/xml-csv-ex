package example.xmlcsvex;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class Apple {
    private String name;
    @JacksonXmlText
    private String value;


    Apple(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
