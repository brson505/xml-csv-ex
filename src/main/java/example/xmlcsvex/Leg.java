package example.xmlcsvex;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

//import javax.xml.bind.annotation.XmlAttribute;

public class Leg {

	private double idbFee;
	private FundLEI fundLEI;


	public double getIdbFee() {
		return idbFee;
	}

	public void setIdbFee(double idbFee) {
		this.idbFee = idbFee;
	}

	public FundLEI getFundLEI() {
		return fundLEI;
	}

	public void setFundLEI(FundLEI fundLEI) {
		this.fundLEI = fundLEI;
	}

	@Override
	public String toString() {
		return "Leg{" +
				"idbFee=" + idbFee +
				", fundLEI=" + fundLEI +
				'}';
	}
}
