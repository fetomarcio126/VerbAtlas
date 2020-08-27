package it.uniroma1.nlp.kb;

import java.util.List;

public abstract class Frame {

	protected ResourceID id;
	protected String name;
	
	public abstract String getName();
	public abstract ResourceID getId();
	public abstract List<Role> getRoles();

	public class Role{
		
	}
	
}
