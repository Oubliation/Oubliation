package edu.ycp.cs320spring2015.oubliation.shared;

import edu.ycp.cs320spring2015.oubliation.shared.category.Element;

public class BehaviorOrder {
	private String customer;
	private String effect;
	private String target;
	private int power;
	private int accuracy;
	private Element element;
	private String status;
	private int potency;
	
	public BehaviorOrder(String customer, String effect, String target, int power, int accuracy,
			String element, String status, int potency) {
		this.customer = customer;
		this.effect = effect;
		this.target = target;
		this.power = power;
		this.accuracy = accuracy;
		this.element = Element.valueOf(element);
		this.status = status;
		this.potency = potency;
	}
	public String getCustomer() {
		return customer;
	}
	public String getEffect() {
		return effect;
	}
	public String getTarget() {
		return target;
	}
	public int getPower() {
		return power;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public Element getElement() {
		return element;
	}
	public String getStatus() {
		return status;
	}
	public int getPotency() {
		return potency;
	}
	
}
