package example.xmlcsvex.spec.ktcRequestConfirmation;

import lombok.ToString;

@ToString
public class PartyTradeInformation {
    public String executionVenueType;
    public String executionDateTime;
    public String intentToClear;
    public String category2;
    public String category3;
    public String clearingIndicator;
    public String clearingEntityIndicator;
    public String collateralizationType;
    public String marginRequiredForNonCCP;
    public String belongToSwaption;
    public BreakAtInformation breakAtInformation;
    public String markitConfirm;
    public EmbeddedOption embeddedOption;
}
