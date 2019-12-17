package example.xmlcsvex.spec;

import lombok.ToString;

@ToString
public class CashSettlementInformation {
    public String cashSettlement;
    public String cashSettlementValTime;
    public MaxOccursTextElement cashSettlementValDate;
    public CashSettlementPayment cashSettlementPayment;
}
