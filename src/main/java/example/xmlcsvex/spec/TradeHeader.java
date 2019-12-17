package example.xmlcsvex.spec;

import lombok.ToString;

import java.util.Map;

@ToString
public class TradeHeader {
    public PartyTradeIdentifier partyTradeIdentifier;
    public PartyTradeIdentifierN partyTradeIdentifier1;
    public PartyTradeIdentifierN partyTradeIdentifier2;
    public PartyTradeInformation partyTradeInformation;
    public PartyTradeInformationN partyTradeInformation1;
    public PartyTradeInformationN partyTradeInformation2;
    public ProductSummary productSummary;
    public OriginatingPackage originatingPackage;
}
