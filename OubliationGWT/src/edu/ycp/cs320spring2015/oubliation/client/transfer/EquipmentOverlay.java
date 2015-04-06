package edu.ycp.cs320spring2015.oubliation.client.transfer;

import java.util.TreeSet;

public abstract class EquipmentOverlay extends EntityOverlay {
	protected EquipmentOverlay() {}
	
	protected final native int getPrice() /*-{
		return this.price;
	}-*/;
	protected final native String[] getEquippableBy() /*-{
		return this.equippableBy;
	}-*/;
	protected final native int getAr() /*-{
		return this.ar;
	}-*/;
	
	protected final TreeSet<String> getJobSet() {
		String[] jobNames = getEquippableBy();
		TreeSet<String> jobSet = new TreeSet<String>();
		for (String jobName : jobNames) {
			jobSet.add(jobName);
		}
		return jobSet;
	}
}