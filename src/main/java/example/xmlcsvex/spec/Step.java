package example.xmlcsvex.spec;

import lombok.ToString;

@ToString
public class Step extends MaxOccursElement{
    public String amount;
    public String startDate;
    public String endDate;
}
