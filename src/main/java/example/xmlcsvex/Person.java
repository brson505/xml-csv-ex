package example.xmlcsvex;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

//@JsonIgnoreProperties(ignoreUnknown=true)
public class Person {
	private int id;
	private String name;
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<String> phoneNumbers = new ArrayList<String>();
	private String attr1;
	private Apple apple;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public String getAttr1() {
		return attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	public Apple getApple() {
		return apple;
	}

	public void setApple(Apple apple) {
		this.apple = apple;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", name='" + name + '\'' +
				", phoneNumbers=" + phoneNumbers +
				", attr1='" + attr1 + '\'' +
				", apple=" + apple +
				'}';
	}
}
