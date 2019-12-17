package example.xmlcsvex.spec;

import lombok.ToString;

import java.util.List;

@ToString
public class CalculationPeriodDatesAdjustments{
    public String businessDayConvention;
    public List<MaxOccursTextElement> businessCenters;
}
