package example.xmlcsvex;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Data {
	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName="Leg")
	private List<Leg> legs = new ArrayList<Leg>();

	void addLeg(Leg leg){
		legs.add(leg);
	}

	public List<Leg> getLegs() {
		return legs;
	}

	public void setLegs(List<Leg> legs) {
		this.legs = legs;
	}
}
