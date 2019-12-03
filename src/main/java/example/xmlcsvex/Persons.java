package example.xmlcsvex;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class Persons {
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Person> person = new ArrayList<Person>();

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}
}
