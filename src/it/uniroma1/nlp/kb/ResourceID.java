package it.uniroma1.nlp.kb;

public class ResourceID implements Comparable<ResourceID>{

	protected String value;
	
	public ResourceID(String v) {
		value = v;
	}
	
	public String getValue() {
		return value;
	}

	@Override
	public int compareTo(ResourceID o) {
		return getValue().compareTo(o.getValue());
	}
	
}
