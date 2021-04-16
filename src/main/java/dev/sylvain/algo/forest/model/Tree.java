/**
 * 
 */
package dev.sylvain.algo.forest.model;

/**
 * @author sbrunon
 *
 */
public class Tree implements Tile {
	private State state;
	private Position position;

	/**
	 */
	public Tree(Position position) {
		this.position = position;
		this.state = State.OK;
	}

	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}
	
	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
}
