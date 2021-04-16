/**
 * 
 */
package dev.sylvain.algo.forest.simulator;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dev.sylvain.algo.forest.model.Position;

/**
 * @author sbrunon
 *
 */
public class TestSimulatorParameter {
	
	@Test
	public void testConstructor() {
		SimulatorParameter parameter = new SimulatorParameter(null, null, 1f);
		assertNotNull(parameter);
	}
	
	@Test
	public void testPositions() throws Exception {
		Position[] position = new Position[] {new Position(1, 2),new Position(3, 4)};
		SimulatorParameter parameter = new SimulatorParameter(null, position, 1f);
		assertTrue(parameter.getStartPositions().length == 2);
	}
	
	@Test
	public void testNullPositions() throws Exception {
		SimulatorParameter parameter = new SimulatorParameter(null, null, 1f);
		assertTrue(parameter.getStartPositions().length == 0);
	}
	
	@Test
	public void testProbability() throws Exception {
		SimulatorParameter parameter = new SimulatorParameter(null, null, .5f);
		assertTrue(parameter.getProbability() == .5f);
	}
	
	@Test
	public void testNegativeProbability() throws Exception {
		SimulatorParameter parameter = new SimulatorParameter(null, null, -.5f);
		assertTrue(parameter.getProbability() == 0f);
	}
	
	@Test
	public void testPlusProbability() throws Exception {
		SimulatorParameter parameter = new SimulatorParameter(null, null, 15f);
		assertTrue(parameter.getProbability() == 1f);
	}
}
