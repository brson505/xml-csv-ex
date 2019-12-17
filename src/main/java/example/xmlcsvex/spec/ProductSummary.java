package example.xmlcsvex.spec;

import lombok.ToString;

@ToString
public class ProductSummary {
    public String productCodeFSS;
    public String productName;
    public String productId;
    public String assetClass;
    public String instrumentType;
    public String exerciseStyle;
    public String optionType;
    public String pricingMethod;
    public String notionalSchedule;
    public String singleOrMultipleCurrency;
    public String singleOrMultipleTenor;
    public MaxOccursTextElement contractType;
    public MaxOccursTextElement contractSubType;
    public String seniority;
    public String settlementType;
    public String settlementCurrency;
}
