package edu.ycp.cs320spring2015.oubliation.transfer;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Headwear;

public class HeadwearOverlay extends EquipmentOverlay {
	protected HeadwearOverlay() {}
	
	public Headwear getHeadwear() {
		return new Headwear(getNameTag(), getPrice(), getJobSet(), getAr());
	}
}
