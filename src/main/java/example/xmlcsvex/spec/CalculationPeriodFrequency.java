package example.xmlcsvex.spec;

import lombok.ToString;

//<calculationPeriodFrequency>
//<periodMultiplier>(이자계산주기승수_Leg1)</periodMultiplier>
//<period>(이자계산주기단위_Leg1)</period>
//<rollConvention>(이자계산주기규칙_Leg1)</rollConvention>
//</calculationPeriodFrequency>

@ToString
public class CalculationPeriodFrequency {
    public String periodMultiplier;
    public String period;
    public String rollConvention;
}
