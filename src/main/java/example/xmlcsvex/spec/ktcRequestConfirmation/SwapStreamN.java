package example.xmlcsvex.spec.ktcRequestConfirmation;

import lombok.ToString;

@ToString
public class SwapStreamN {
    public Common common;
    public CalculationPeriodDates calculationPeriodDates;
    public PaymentDates paymentDates;
    public ResetDates resetDates;
    public CalculationPeriodAmount calculationPeriodAmount;
    public PrincipalExchange principalExchange;
    public Cashflows cashflows;
}
