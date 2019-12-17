package example.xmlcsvex.spec.ktcRequestConfirmation;

import lombok.ToString;

@ToString
public class Trade {
    public TradeHeader tradeHeader;
    public CalculationAgent calculationAgent;
    public Documentation documentation;
    public AdditionalPayment additionalPayment;
    public IRSwap_ IRSwap;
}
