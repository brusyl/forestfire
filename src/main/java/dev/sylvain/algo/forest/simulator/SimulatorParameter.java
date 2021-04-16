package dev.sylvain.algo.forest.simulator;

import dev.sylvain.algo.forest.model.GridMap;
import dev.sylvain.algo.forest.model.Position;

public class SimulatorParameter {
	private float probability;
	private GridMap map;
	private Position[] startPositions;

	/**
	 * @param probability
	 */
	public SimulatorParameter(GridMap map, Position[] startPositions, float probability) {
		super();
		this.map = map;
		
		this.setStartPositions(startPositions);
		this.setProbability(probability);
	}

	/**
	 * @return the grid
	 */
	public GridMap getMap() {
		return map;
	}

	/**
	 * @return the startPositions
	 */
	public Position[] getStartPositions() {
		return startPositions;
	}
	
	/**
	 * @param startPositions the startPositions to set
	 */
	public void setStartPositions(Position[] startPositions) {
		// Check input value
		if (startPositions == null) {
			this.startPositions = new Position[0];
		} else {
			this.startPositions = startPositions;
		}
	}

	/**
	 * @return the probability
	 */
	public float getProbability() {
		return probability;
	}

	/**
	 * @param probability the probability to set
	 */
	public void setProbability(float probability) {
		// Check input value
		if (probability > 1) {
			this.probability = 1f;
		} else if (probability < 0) {
			this.probability = 0;
		} else {
			this.probability = probability;
		}
		
	}
}
