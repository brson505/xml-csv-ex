package example.xmlcsvex.spec;

import lombok.ToString;

@ToString
public class EmbeddedOption {
    public String embeddedOptionIndicator;
    public String embeddedOptionType;
    public String embeddedOptionBuyer;
    public String embeddedOptionStyle;
    public EmbeddedOptionExerciseDates embeddedOptionExerciseDates;
    public String partialExercise;
    public String multipleExercise;
    public String minimumNotionalAmount;
    public CashSettlementInformation cashSettlementInformation;
    public CashSettlementPayment cashSettlementPayment;
}
