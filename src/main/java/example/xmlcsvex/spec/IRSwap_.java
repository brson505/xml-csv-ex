package example.xmlcsvex.spec;

import lombok.ToString;

import java.util.Map;

@ToString
public class IRSwap_ {
    public SwapStreamN swapStream1;
    public SwapStreamN swapStream2;
    public CRS_ CRS;
    public Inflation inflation;
    public SettlementProvision settlementProvision;

    @Override
    public String toString() {
        return "IRSwap_{" +
                "swapStream1=" + swapStream1 +
                ", swapStream2=" + swapStream2 +
                ", CRS=" + CRS +
                ", inflation=" + inflation +
                ", settlementProvision=" + settlementProvision +
                "}\n";
    }
}
