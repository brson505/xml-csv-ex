package example.xmlcsvex.spec;

import lombok.ToString;

import java.util.Map;

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

