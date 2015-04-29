package edu.ycp.cs320spring2015.oubliation.shared.behavior;

public enum ActionResolution {
	miss,
	hit,
	fullHit,
	criticalHit,
	criticalFullHit;
	
	private interface ResolutionQueries {
		public String[] getDescriptions();
	}
	
	private ActionResolution(ResolutionQueries query) {
		
	}
}
