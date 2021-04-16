/**
 * 
 */
package dev.sylvain.algo.forest.simulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dev.sylvain.algo.forest.map.MapBuilderException;
import dev.sylvain.algo.forest.model.GridMap;
import dev.sylvain.algo.forest.model.Position;
import dev.sylvain.algo.forest.model.SimulatorException;
import dev.sylvain.algo.forest.model.State;
import dev.sylvain.algo.forest.model.Step;
import dev.sylvain.algo.forest.model.Tile;
import dev.sylvain.algo.forest.model.Tree;

/**
 * @author sbrunon
 *
 */
public class TreeSimulator implements ISimulator {
	
	public static final String ERROR_NOT_INITIALIZED = "Simulator not initialized";
	public static final String ERROR_NO_MAP = "No map";
	
	private SimulatorParameter parameter;
	private Step currentStep;
	private Random random = new Random();

	/**
	 * @param parameter
	 */
	public TreeSimulator(SimulatorParameter parameter) {
		super();
		this.parameter = parameter;
	}

	@Override
	public Step initialize() throws SimulatorException, MapBuilderException {
		GridMap map = this.parameter.getMap();
		if (map == null) {
			throw new SimulatorException(ERROR_NO_MAP);
		}
		List<Tree> startTrees = new ArrayList<Tree>();
		for (int i = 0; i < this.parameter.getStartPositions().length; i++) {
			Position position = this.parameter.getStartPositions()[i];
			Tree tree = (Tree) map.getTile(position.getRow(), position.getColumn());
			startTrees.add(tree);
		}
		
		Tree[] array = new Tree[startTrees.size()];
		startTrees.toArray(array);
		applyState(array, State.BURN);
		this.currentStep = new Step(0, this.parameter.getMap(), array);
		return this.currentStep;
	}

	@Override
	public Step next() throws SimulatorException, MapBuilderException {
		checkInit();
		Tree[] tiles = (Tree[]) this.currentStep.getActiveItems();
		
		// Transform previous burned tree to ash
		applyState(tiles, State.ASH);
		
		// Clone step
		GridMap map = this.currentStep.getMap();

		// Search neighbour of burned tree
		List<Tree> neighbourList = new ArrayList<Tree>();
		for (int i = 0; i < tiles.length; i++) {
			Tree tile = tiles[i];
			Tile[] findNeighbours = map.findNeighbour(tile.getPosition().getRow(), tile.getPosition().getColumn());
			for (Tile neighbour : findNeighbours) {
				neighbourList.add((Tree) neighbour);
			}
		}
		
		// From neighbour extract with probability and change state
		Tree[] neighbours = new Tree[neighbourList.size()];
		Tree[] newActiveTiles = extractRandomTiles(neighbourList.toArray(neighbours), this.parameter.getProbability());
		applyState(newActiveTiles, State.BURN);

		// Create new step
		this.currentStep = new Step((this.currentStep.getStepNumber() + 1), 
				map, newActiveTiles);
		
		return this.currentStep;
	}

	@Override
	public boolean hasNext() throws SimulatorException {
		checkInit();
		return this.currentStep.getActiveItems().length > 0;
	}

	@Override
	public boolean isInitialized() {
		return this.currentStep != null;
	}

	@Override
	public Step getCurrentStep() {
		return currentStep;
	}

	/**
	 * @throws SimulatorException
	 */
	private void checkInit() throws SimulatorException {
		if (!isInitialized()) {
			throw new SimulatorException(ERROR_NOT_INITIALIZED);
		}
	}

	/**
	 * Extract randomly tile from neighbour
	 * @param tiles
	 * @param probability
	 * @return
	 */
	private Tree[] extractRandomTiles(Tree[] tiles, float probability) {
		List<Tree> extractedTrees = new ArrayList<Tree>();
		for (int i = 0; i < tiles.length; i++) {
			Tree tree = tiles[i];
			if (State.OK.equals(tree.getState()) 
					&& random.nextFloat() <= probability) {
				extractedTrees.add(tree);
			}
		}
		Tree[] result = new Tree[extractedTrees.size()];
		return extractedTrees.toArray(result);
	}
	
	/**
	 * Apply state on list of tree
	 * @param tiles
	 * @param state
	 */
	private void applyState(Tree[] trees, State state) {
		for (int i = 0; i < trees.length; i++) {
			trees[i].setState(state);
		}
	}

	@Override
	public SimulatorResult getResult() {
		return new TreeSimulatorResult(this.currentStep);
	}
}
