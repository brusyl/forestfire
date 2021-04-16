/**
 * 
 */
package dev.sylvain.algo.forest.simulator;

import dev.sylvain.algo.forest.model.State;
import dev.sylvain.algo.forest.model.Step;
import dev.sylvain.algo.forest.model.Tile;
import dev.sylvain.algo.forest.model.Tree;

/**
 * @author sbrunon
 *
 */
public class TreeSimulatorResult extends SimulatorResult {
	
	public TreeSimulatorResult(Step lastStep) {
		super(lastStep);
	}

	/**
	 * Calculate number of trees in ash
	 * @return
	 */
	public int countAshTrees() {
		int count = 0;
		Tile[] tiles = this.getLastStep().getMap().getTiles();
		for (int i = 0; i < tiles.length; i++) {
			Tree tree = (Tree) tiles[i];
			if (State.ASH.equals(tree.getState())) {
				count++;
			}
		}
		return count;
	}
}
