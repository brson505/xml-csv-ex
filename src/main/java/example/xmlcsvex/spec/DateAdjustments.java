package example.xmlcsvex.spec;

import lombok.ToString;

import java.util.List;

//<dateAdjustments>
//<businessDayConvention>(종료일영업일규칙_Leg2)</businessDayConvention>
//<businessCenters>
//<businessCenter maxOccurs="unbounded">(종료일영업일적용도시_Leg2)</businessCenter>
//</businessCenters>
//</dateAdjustments>

@ToString
public class DateAdjustments {
    public String businessDayConvention;
    public List<MaxOccursTextElement> businessCenters;
}
