package edu.ycp.cs320spring2015.oubliation.client.transfer;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Job;

public class JobOverlay extends EntityOverlay {
	protected JobOverlay() { }
	
	static final public class ResourceMap extends EntityResourceMap<JobOverlay> {

		public ResourceMap(String[] filenames,
				AsyncCallback<EntityResourceMap<JobOverlay>> callback) {
			super(filenames, callback);
		}
	}
	
	static public Map<String, Job> remapHeadwear(Map<String, JobOverlay> overlayMap) {
		HashMap<String, Job> entityMap = new HashMap<String, Job>();
		for (String key : overlayMap.keySet()) {
			entityMap.put(key, overlayMap.get(key).getJob());
		}
		return entityMap;
	}
	
	public Job getJob() {
		return new Job(getNameTag());
	}
}
