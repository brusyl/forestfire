/**
 * 
 */
package dev.sylvain.algo.forest.print;

import dev.sylvain.algo.forest.map.MapBuilderException;
import dev.sylvain.algo.forest.model.GridMap;
import dev.sylvain.algo.forest.model.State;
import dev.sylvain.algo.forest.model.Step;
import dev.sylvain.algo.forest.model.Tree;

/**
 * @author sbrunon
 *
 */
public class BasicLogView implements IView {

	@Override
	public void updateView(Step step) throws MapBuilderException {
		System.out.println(" ");
		GridMap map = step.getMap();
		int rows = map.getRows();
		int columns = map.getColumns();
        for (int row = 0; row < rows; row++) {
        	System.out.print(" ");
        	for (int col = 0; col < columns; col++) {
				System.out.print("- ");
			}
        	System.out.println("");
        	
			for (int col = 0; col < columns; col++) {
				System.out.print("|");
				Tree tree = (Tree) map.getTile(row, col);
				if (State.OK.equals(tree.getState())) {
					System.out.print("O");
				} else if (State.ASH.equals(tree.getState())) {
					System.out.print("X");
				} else {
					System.out.print("B");
				}
			}
			System.out.println("|");
		}
        System.out.println(" ");
	}

	@Override
	public void message(String message) {
		System.out.println("--------------------------------");
		System.out.println(message);
		System.out.println("--------------------------------");
	}

}
