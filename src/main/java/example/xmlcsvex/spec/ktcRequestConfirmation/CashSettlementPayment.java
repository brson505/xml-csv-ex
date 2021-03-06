package example.xmlcsvex.spec.ktcRequestConfirmation;

import lombok.ToString;

@ToString
public class CashSettlementPayment {
    public String cashSettlementPayDate;
    public DateAdjustments dateAdjustments;
    public String cashSettlementCurrency;
    public String cashSettlementMethod;
    public String cashSettlementRefBanks;
    public String quotatioRate;
}
