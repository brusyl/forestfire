/**
 * 
 */
package dev.sylvain.algo.forest.simulator;

import dev.sylvain.algo.forest.map.MapBuilderException;
import dev.sylvain.algo.forest.model.SimulatorException;
import dev.sylvain.algo.forest.model.Step;

/**
 * @author sbrunon
 *
 */
public interface ISimulator {
	
	/**
	 * Check if simulator correctly initialized
	 * @return
	 */
	public boolean isInitialized();
	
	/**
	 * Initialize simulator configuration
	 * @throws SimulatorException 
	 * @throws MapBuilderException 
	 */
	public Step initialize() throws SimulatorException, MapBuilderException;
	
	/**
	 * Process next step
	 * @return Generated step
	 * @throws SimulatorException
	 * @throws MapBuilderException 
	 */
	public Step next() throws SimulatorException, MapBuilderException;
	
	/**
	 * Check if there is more steps
	 * @return
	 * @throws SimulatorException
	 */
	public boolean hasNext() throws SimulatorException;
	
	/**
	 * Return current step
	 * @return
	 */
	public Step getCurrentStep();
	
	/**
	 * Return simulator result
	 * @return
	 */
	public SimulatorResult getResult();
}
