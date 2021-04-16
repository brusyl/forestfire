/**
 * 
 */
package dev.sylvain.algo.forest.model;

/**
 * @author sbrunon
 *
 */
public class Step {
	private int stepNumber;
	private GridMap map;
	private Tile[] activeItems;

	/**
	 * @param stepNumber
	 * @param map
	 * @param activeItems
	 */
	public Step(int stepNumber, GridMap map, Tile[] activeItems) {
		super();
		this.stepNumber = stepNumber;
		this.activeItems = activeItems;
		this.map = map;
	}

	/**
	 * @return the stepNumber
	 */
	public int getStepNumber() {
		return stepNumber;
	}

	/**
	 * @param stepNumber the stepNumber to set
	 */
	public void setStepNumber(int stepNumber) {
		this.stepNumber = stepNumber;
	}
	
	/**
	 * @return the map
	 */
	public GridMap getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(GridMap map) {
		this.map = map;
	}

	/**
	 * @return the activeItems
	 */
	public Tile[] getActiveItems() {
		return activeItems;
	}

	/**
	 * @param activeItems the activeItems to set
	 */
	public void setActiveItems(Tile[] activeItems) {
		this.activeItems = activeItems;
	}
}
