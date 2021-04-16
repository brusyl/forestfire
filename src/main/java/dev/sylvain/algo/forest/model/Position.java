/**
 * 
 */
package dev.sylvain.algo.forest.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sbrunon
 *
 */
public class Position {
	private int row;
	private int column;
	
	/**
	 * @param x
	 * @param y
	 */
	public Position(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}
	
	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
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
		if (sPositions == null || sPositions.isBlank()) {
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
