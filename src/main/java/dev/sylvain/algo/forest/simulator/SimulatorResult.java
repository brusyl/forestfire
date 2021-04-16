/**
 * 
 */
package dev.sylvain.algo.forest.simulator;

import dev.sylvain.algo.forest.model.Step;

/**
 * @author sbrunon
 *
 */
public class SimulatorResult {
	private Step lastStep;

	/**
	 * @param lastStep
	 */
	public SimulatorResult(Step lastStep) {
		super();
		this.lastStep = lastStep;
	}
	
	/**
	 * @return the lastStep
	 */
	public Step getLastStep() {
		return lastStep;
	}

	/**
	 * @param lastStep the lastStep to set
	 */
	public void setLastStep(Step lastStep) {
		this.lastStep = lastStep;
	}
}
