package example.xmlcsvex.spec.ktcRequestConfirmation;

import lombok.ToString;

@ToString
public class InflationRateCalculation {
    public InflationLeg inflationLeg;
    public String interpolationMethod;
    public String initialIndexLevel;
}
