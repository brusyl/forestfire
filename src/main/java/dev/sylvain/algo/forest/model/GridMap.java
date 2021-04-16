/**
 * 
 */
package dev.sylvain.algo.forest.model;

import java.util.ArrayList;
import java.util.List;

import dev.sylvain.algo.forest.map.MapBuilderException;

/**
 * @author sbrunon
 *
 */
public class GridMap {
	
	public static final String ERROR_OUT_BOUND = "Out of bounding";
	
	private int columns;
	private int rows;
	private Tile[] tiles;
	
	/**
	 * @param columns
	 * @param rows
	 */
	public GridMap(int rows, int columns) {
		super();
		this.columns = columns;
		this.rows = rows;
		updateTileSize();
	}

	/**
	 * 
	 */
	private void updateTileSize() {
		this.tiles = new Tile[getSize()];
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
		updateTileSize();
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
		updateTileSize();
	}

	/**
	 * @return the tiles
	 */
	public Tile[] getTiles() {
		return tiles;
	}
	
	/**
	 * Set tile in datagrid
	 * @param row
	 * @param column
	 * @param tile
	 * @throws SimulatorException 
	 */
	public void setTile(int row, int column, Tile tile) throws MapBuilderException {
		tiles[getGridPosition(row, column)] = tile;
	}
	
	/**
	 * @return the size
	 */
	public int getSize() {
		return columns * rows;
	}

	/**
	 * Get tile with row and column
	 * @param row
	 * @param column
	 * @return
	 * @throws MapBuilderException
	 */
	public Tile getTile(int row, int column) throws MapBuilderException {
		return tiles[getGridPosition(row, column)];
	}
	
	/**
	 * Calculate grid position depends of row and column
	 * @param row
	 * @param column
	 * @return
	 * @throws MapBuilderException
	 */
	private int getGridPosition(int row, int column) throws MapBuilderException {
		if (column > columns 
				|| column < 0 
				|| row > rows 
				|| row < 0) {
			throw new MapBuilderException(ERROR_OUT_BOUND);
		}
		int position = column + row * columns;
		if (position < 0 || position > (getSize() - 1)) {
			throw new MapBuilderException(ERROR_OUT_BOUND);
		}
		return position;
	}
	
	/**
	 * Find tile neighbour
	 * @param row
	 * @param column
	 * @return
	 * @throws MapBuilderException
	 */
	public Tile[] findNeighbour(int row, int column) throws MapBuilderException {
		List<Tile> tiles = new ArrayList<Tile>();

		if (row - 1 >= 0) {
			tiles.add(getTile(row - 1, column));
		}
		if (row + 1 < rows) {
			tiles.add(getTile(row + 1, column));
		}
		if (column - 1 >= 0) {
			tiles.add(getTile(row, column - 1));
		}
		if (column + 1 < columns) {
			tiles.add(getTile(row, column + 1));
		}
		Tile[] array = new Tile[tiles.size()];
		return tiles.toArray(array);
	}
}
