package edu.ycp.cs320spring2015.oubliation.shared.category;

public enum Element implements Category {
	physical("Physical", "Impairs animate bodies using highly accelerated solid matter."),
	lightning("Lightning", "Impairs animate bodies with lethal exposure to charged particles."), 
	ice("Ice", "Impairs animate bodies through the intense dispersion of kinetic energy."), 
	magic("Magic", "Impairs animate bodies by discharging unstable occult energies.");
	
	final private String name;
	final private String description; 
	
	Element(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
}
