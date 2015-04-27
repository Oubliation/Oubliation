package edu.ycp.cs320spring2015.oubliation.client.transfer.overlays;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityExtractor;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityResourceMap;
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
		EntityExtractor<Job, JobOverlay> extractor = new EntityExtractor<Job, JobOverlay>() {
			public Job getEntity(JobOverlay overlay) {
				return overlay.getJob();
			}
		};
		return EntityOverlay.remapEntity(overlayMap, extractor);
	}
	
	final public Job getJob() {
		return new Job(getNameTag());
	}
}
