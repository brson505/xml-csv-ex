package example.xmlcsvex.spec.ktcRequestConfirmation;

import lombok.ToString;

import java.util.List;

//<paymentDatesAdjustments>
//<businessDayConvention>(이자지급일영업일규칙_Leg1)</businessDayConvention>
//<businessCenters>
//<businessCenter maxOccurs="unbounded">(이자지급일영업일적용도시_Leg1)</businessCenter>
//</businessCenters>
//</paymentDatesAdjustments>
@ToString
public class PaymentDatesAdjustments {
    public String businessDayConvention;
    public List<MaxOccursTextElement> businessCenters;
}
