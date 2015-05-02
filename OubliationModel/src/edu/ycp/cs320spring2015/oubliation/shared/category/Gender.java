package edu.ycp.cs320spring2015.oubliation.shared.category;

public enum Gender implements Category {
	male("he", "his", "his"), female("she", "her", "hers"), other("they", "their", "theirs");
	
	String personalPronoun;
	String possessiveAdjective;
	String possessivePronoun;
	
	private Gender(String personalPronoun, String possessiveAdjective, String possessivePronoun) {
		this.personalPronoun = personalPronoun;
		this.possessiveAdjective = possessiveAdjective;
		this.possessivePronoun = possessivePronoun;
	}
	public String getName() {
		return name();
	}
	public String getDescription() {
		return name();
	}
	public String getPersonalPronoun() {
		return personalPronoun;
	}
	public String getPossessiveAdjective() {
		return possessiveAdjective;
	}
	public String getPossessivePronoun() {
		return possessivePronoun;
	}
}
