/**
 * 
 */
package dev.sylvain.algo.forest.map;

import dev.sylvain.algo.forest.model.GridMap;

/**
 * @author sbrunon
 *
 */
public interface IMapBuilder {
	
	/**
	 * Method to build map
	 * @param <T>
	 * @return
	 */
	public GridMap build() throws MapBuilderException;

}
