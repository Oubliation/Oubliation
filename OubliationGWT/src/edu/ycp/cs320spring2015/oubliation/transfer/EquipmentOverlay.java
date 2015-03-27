package edu.ycp.cs320spring2015.oubliation.transfer;

import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Equipment;

public abstract class EquipmentOverlay<T extends Equipment> extends EntityOverlay<T> {
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
	
	protected TreeSet<String> getJobSet() {
		String[] jobNames = getEquippableBy();
		TreeSet<String> jobSet = new TreeSet<String>();
		for (String jobName : jobNames) {
			jobSet.add(jobName);
		}
		return jobSet;
	}
}