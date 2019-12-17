package example.xmlcsvex.spec.ktcRequestConfirmation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.ToString;

import java.util.List;
@ToString
public class DataDocument {
    public Header header;
    public Trade trade;
    public ReplacementN replacement1;
    public ReplacementN replacement2;
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<Party> party;
}
