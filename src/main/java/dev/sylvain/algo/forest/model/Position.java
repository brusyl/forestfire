/**
 * 
 */
package dev.sylvain.algo.forest.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * @author sbrunon
 *
 */
public class Position {
	private int x;
	private int y;
	
	/**
	 * @param x
	 * @param y
	 */
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Parse input String to transform in position list. 
	 * Format of string : "1,2;1,3;2,4"
	 * Generate only complete positions
	 * Return null if string is empty. 
	 * @param sPositions
	 * @return
	 */
	public static final Position[] parseString(String sPositions) throws NumberFormatException {
		if (StringUtils.isBlank(sPositions)) {
			return null;
		}
		List<Position> positions = new ArrayList<Position>();
		
		// Parse string first by group with ; character
		String[] arraySPosition = sPositions.split(";");
		for (String sPosition : arraySPosition) {
			// Then parse all strings with , character to generate positions
			String[] sCoordinates = sPosition.split(",");
			if (sCoordinates.length == 2) {
				Position position = new Position(Integer.parseInt(sCoordinates[0]), Integer.parseInt(sCoordinates[1]));
				positions.add(position);
			}
		}
		
		Position[] positionsArray = new Position[positions.size()];
		return positions.toArray(positionsArray);
	}
}
