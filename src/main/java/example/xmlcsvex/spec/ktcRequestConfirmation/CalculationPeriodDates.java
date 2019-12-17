package example.xmlcsvex.spec.ktcRequestConfirmation;

import lombok.ToString;

@ToString
public class CalculationPeriodDates {
    public CalculationPeriodDatesAdjustments calculationPeriodDatesAdjustments;
    public String firstPeriodStartDate;
    public String firstRegularPeriodStartDate;
    public String lastRegularPeriodEndDate;
    public String lastRegularPeriodStartDate;
    public MaxOccursTextElement stubPeriodType;
    public CalculationPeriodFrequency calculationPeriodFrequency;
}

