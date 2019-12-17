package example.xmlcsvex.spec;

import lombok.ToString;

@ToString
public class EffectiveDate {
    public String unadjustedDate;
    public String terminationDate;
    public DateAdjustments dateAdjustments;
}
