/**
 * 
 */
package dev.sylvain.algo.forest.simulator;

import dev.sylvain.algo.forest.map.MapBuilderException;
import dev.sylvain.algo.forest.model.SimulatorException;
import dev.sylvain.algo.forest.model.Step;
import dev.sylvain.algo.forest.print.IView;

/**
 * @author sbrunon
 *
 */
public class SimulatorManager {

	private ISimulator simulator;
	private IView view;
	private Step currentStep;

	/**
	 * @param simulator
	 */
	public SimulatorManager(ISimulator simulator) {
		super();
		this.simulator = simulator;
	}
	
	/**
	 * @param simulator
	 */
	public SimulatorManager(ISimulator simulator, IView view) {
		this(simulator);
		this.view = view;
	}
	
	public void process() throws SimulatorException, MapBuilderException {
		this.currentStep = this.simulator.initialize();
		if (this.view != null) {
			this.view.message("Etape initiale");
			this.view.updateView(this.currentStep);
		}
		
		while(this.simulator.hasNext()) {
			this.currentStep = this.simulator.next();
			
			if (this.view != null) {
				this.view.message("Etape : " + this.currentStep.getStepNumber());
				this.view.updateView(this.currentStep);
			}
		}
	}
	
	public SimulatorResult result() {
		return this.simulator.getResult();
	}
}
