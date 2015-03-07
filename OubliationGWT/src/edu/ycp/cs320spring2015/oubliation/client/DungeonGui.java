package edu.ycp.cs320spring2015.oubliation.client;

public class DungeonGui extends Gui {

	private double[] perspectiveTransform(double xDist, double yDist, double depth) {
		double xViewSlope = 0, yViewSlope = 0;
		double initialTileHeight = 0, initialTileWidth = 0;

		double xScale = depth*xViewSlope*initialTileHeight;
		double yScale = depth*yViewSlope*initialTileWidth;
		
		double[] screenCoords = {xDist*xScale, yDist*yScale};
		
		return screenCoords;
	}

	@Override
	public void showMain() {
		// TODO Auto-generated method stub

	}

}
