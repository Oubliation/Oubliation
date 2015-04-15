package edu.ycp.cs320spring2015.oubliation.client.transfer.overlays;

public abstract class EquipmentOverlay extends ItemOverlay {
	protected EquipmentOverlay() {}
	
	protected final native String[] getEquippableBy() /*-{
		return this.equippableBy;
	}-*/;
	protected final native int getAr() /*-{
		return this.ar;
	}-*/;
}