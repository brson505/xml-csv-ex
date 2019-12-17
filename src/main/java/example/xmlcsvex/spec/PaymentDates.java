package example.xmlcsvex.spec;

import lombok.ToString;

@ToString
public class PaymentDates {
    public PaymentFrequency paymentFrequency;
    public String payRelativeTo;
    public PaymentDaysOffset paymentDaysOffset;
    public PaymentDatesAdjustments paymentDatesAdjustments;
}
