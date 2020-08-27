package it.uniroma1.nlp.verbatlas;

import java.util.List;

import it.uniroma1.nlp.kb.Frame;
import it.uniroma1.nlp.kb.ResourceID;

public class VerbAtlasFrame extends Frame{

	
	
	public VerbAtlasFrame(ResourceID id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public ResourceID getId() {
		return id;
	}

	@Override
	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		return null;
	}	
	

}
