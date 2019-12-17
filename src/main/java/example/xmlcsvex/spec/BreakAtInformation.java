package example.xmlcsvex.spec;

import lombok.ToString;

import java.util.Map;

@ToString
public class BreakAtInformation {
    public String breakAt;
    public String dateBreakAt;
    public String periodMultiplerBreakAtFrequency;
    public String periodBreakAtFrequency;
    public String markitConfirm;
    public EmbeddedOption embeddedOption;
}
