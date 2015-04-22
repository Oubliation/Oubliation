package edu.ycp.cs320spring2015.oubliation.shared;

public class EffectOrder {
	private String customer;
	private String effect;
	private String target;
	private int power;
	private int accuracy;
	private String status;
	private int potency;
	
	public EffectOrder(String customer, String effect, String target, int power, int accuracy,
			String status, int potency) {
		this.customer = customer;
		this.effect = effect;
		this.target = target;
		this.power = power;
		this.accuracy = accuracy;
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
	public String getStatus() {
		return status;
	}
	public int getPotency() {
		return potency;
	}
	
}
