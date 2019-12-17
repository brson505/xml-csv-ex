package example.xmlcsvex.spec;

import lombok.ToString;

import java.util.List;

@ToString
public class KtcRequestConfirmation {
    public KtcHeader ktcHeader;
    public List<DataDocument> dataDocuments;
}

