package example.xmlcsvex.spec.ktcRequestConfirmation;

import lombok.ToString;

@ToString
public class EffectiveDate {
    public String unadjustedDate;
    public String terminationDate;
    public DateAdjustments dateAdjustments;
}
