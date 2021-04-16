/**
 * 
 */
package dev.sylvain.algo.forest.print;

import dev.sylvain.algo.forest.map.MapBuilderException;
import dev.sylvain.algo.forest.model.Step;

/**
 * @author sbrunon
 *
 */
public interface IView {
	/**
	 * Update view with data in step
	 * @param step
	 * @throws MapBuilderException 
	 */
	public void updateView(Step step) throws MapBuilderException;
	
	/**
	 * Update message in view
	 * @param message
	 */
	public void message(String message);
}
