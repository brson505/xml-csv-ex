package example.xmlcsvex.spec;

import lombok.ToString;

@ToString
public class ResetDates {
    public String resetRelativeTo;
    public ResetCutOffDaysOffset resetCutOffDaysOffset;
    public ResetFrequency resetFrequency;
    public PubresetDatesAdjustments pubresetDatesAdjustments;
    public ResetDatesAdjustments resetDatesAdjustments;
}
