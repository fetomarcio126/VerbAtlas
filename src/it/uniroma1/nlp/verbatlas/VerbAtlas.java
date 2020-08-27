package it.uniroma1.nlp.verbatlas;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import it.uniroma1.nlp.kb.VerbAtlasFrameID;
import it.uniroma1.nlp.kb.Frame;
import it.uniroma1.nlp.kb.ResourceID;

public class VerbAtlas {

	private static VerbAtlas instance;
	
	private HashMap<ResourceID, Frame> frames;
	
	private VerbAtlas() {
		frames = new HashMap<ResourceID, Frame>();
		LoadResources();
	}
	
	private void LoadResources() {
		try {
			List<String> frameIds = LoadResource("VerbAtlas-1.0.3/VA_frame_ids.tsv");
			frameIds.forEach(s -> {
				System.out.println(s);
				VerbAtlasFrameID id = new VerbAtlasFrameID(s.split("\t")[0]);
				String frameName = s.split("\t")[1];
				frames.put(id, new VerbAtlasFrame(id, frameName));
			});
			
			
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private List<String> LoadResource(String localPath) throws URISyntaxException, IOException {
		URI uri = ClassLoader.getSystemResource(localPath).toURI();
		Path path = Paths.get(uri);
		List<String> content = Files.readAllLines(path);
		new ArrayList<String>(content).forEach( s -> {
			if(s.startsWith("#")) {
				content.remove(s);
			}
		});
		return content;
	}
	
	
	public static VerbAtlas getInstance() {
		if(instance == null)
			instance = new VerbAtlas();
		return instance;
	}
	
	
	
}
