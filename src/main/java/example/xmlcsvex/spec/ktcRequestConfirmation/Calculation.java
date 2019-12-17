package example.xmlcsvex.spec.ktcRequestConfirmation;

import lombok.ToString;

@ToString
public class Calculation {
    public InflationRateCalculation inflationRateCalculation;
    public CurrentNotional currentNotional;
    public NotionalSchedule notionalSchedule;
    public FixedRateSchedule fixedRateSchedule;
    public FloatingRateCalculation floatingRateCalculation;
    public String dayCountFraction;
    public Discounting discounting;
    public String compoundingMethod;
}
