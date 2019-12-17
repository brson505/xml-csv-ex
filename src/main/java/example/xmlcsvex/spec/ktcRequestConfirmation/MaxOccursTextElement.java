package example.xmlcsvex.spec.ktcRequestConfirmation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class MaxOccursTextElement extends MaxOccursElement {
    @JacksonXmlText
    public String value;
}
