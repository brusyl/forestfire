/**
 * 
 */
package dev.sylvain.algo.forest.map;

import dev.sylvain.algo.forest.model.GridMap;
import dev.sylvain.algo.forest.model.Position;
import dev.sylvain.algo.forest.model.Tree;

/**
 * @author sbrunon
 *
 */
public class TreeMapBuilder implements IMapBuilder {
	
	public static final String ERROR_MESSAGE_ROWS = "Rows must be >= 1";
	public static final String ERROR_MESSAGE_COLUMNS = "Rows must be >= 1";
	
	private int columns;
	private int rows;
	
	/**
	 * 
	 * @param columns
	 * @param rows
	 */
	public TreeMapBuilder(int columns, int rows) {
		super();
		this.columns = columns;
		this.rows = rows;
	}
	
	/**
	 * @return the columns
	 */
	public int getColumns() {
		return columns;
	}
	/**
	 * @param columns the columns to set
	 */
	public void setColumns(int columns) {
		this.columns = columns;
	}
	/**
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	@Override
	public GridMap build() throws MapBuilderException {
		// Check input values
		if (columns < 1) {
			throw new MapBuilderException(ERROR_MESSAGE_COLUMNS);
		}
		if (rows < 1) {
			throw new MapBuilderException(ERROR_MESSAGE_ROWS);
		}
		
		GridMap map = new GridMap(rows, columns);
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < columns; col++) {
				Position position = new Position(row, col);
				Tree tree = new Tree(position);
				map.setTile(row, col, tree);
			}
		}
		
		return map;
	}

}
