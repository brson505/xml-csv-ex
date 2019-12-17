package example.xmlcsvex.spec;

import lombok.ToString;

@ToString
public class PaymentAmountN {
    public String amount;
    public String paymentType;
    public String currency;
    public String paymentDate;
    public String payerPartyReference;
    public String receiverPartyReference;
}
