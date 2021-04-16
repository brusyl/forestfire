/**
 * 
 */
package dev.sylvain.algo.forest.simulator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import dev.sylvain.algo.forest.map.MapBuilderException;
import dev.sylvain.algo.forest.map.TreeMapBuilder;
import dev.sylvain.algo.forest.model.GridMap;
import dev.sylvain.algo.forest.model.Position;
import dev.sylvain.algo.forest.model.SimulatorException;
import dev.sylvain.algo.forest.model.Step;

/**
 * @author sbrunon
 *
 */
public class TestSimulator {
	
	private SimulatorParameter parameter;
	private ISimulator simulator;
	private GridMap map;
	
	@Before
	public void beforeEach() throws MapBuilderException {
		TreeMapBuilder builder = new TreeMapBuilder(2, 4);
		map = builder.build();
		parameter = new SimulatorParameter(map, null, 1f);
		simulator = new TreeSimulator(parameter);
		
    }
		
	@Test
	public void testConstructor() {
		parameter = new SimulatorParameter(null, null, 1f);
		simulator = new TreeSimulator(parameter);
		assertNotNull(parameter);
		assertNotNull(simulator);
	}
	
	@Test
	public void testInitialize() throws Exception {
		parameter = new SimulatorParameter(map, null, 1);
		simulator = new TreeSimulator(parameter);
		simulator.initialize();
		assertTrue(simulator.isInitialized());
	}
	
	@Test
	public void testNullMap() throws Exception {
		parameter = new SimulatorParameter(null, null, 1);
		simulator = new TreeSimulator(parameter);
		
		assertThrows(SimulatorException.class, () -> simulator.initialize());
	}
	
	@Test
	public void testHasNext() throws Exception {
		Position[] position = new Position[] {new Position(1, 1)};
		parameter = new SimulatorParameter(map, position, 0);
		simulator = new TreeSimulator(parameter);
		simulator.initialize();
		assertTrue(simulator.isInitialized());
		assertTrue(simulator.hasNext());
	}
	
	@Test
	public void testNoHasNext() throws Exception {
		parameter = new SimulatorParameter(map, null, 0);
		simulator = new TreeSimulator(parameter);
		simulator.initialize();
		assertTrue(simulator.isInitialized());
		assertFalse(simulator.hasNext());
	}
	
	@Test
	public void testNext() throws Exception {
		parameter = new SimulatorParameter(map, null, 0);
		simulator = new TreeSimulator(parameter);
		simulator.initialize();
		if (simulator.isInitialized()) {
			Step step = simulator.next();
			assertNotNull(step);
			assertTrue(step.getStepNumber() == 1);
		}
	}
	
	@Test
	public void testResult() throws Exception {
		Position[] position = new Position[] {new Position(1, 1)};
		parameter = new SimulatorParameter(map, position, 0);
		simulator = new TreeSimulator(parameter);
		simulator.initialize();
		if (simulator.isInitialized()) {
			TreeSimulatorResult result = (TreeSimulatorResult) simulator.getResult();
			assertNotNull(result);
			assertTrue(result.countAshTrees() == 0);
			
			simulator.next();
			result = (TreeSimulatorResult) simulator.getResult();
			assertTrue(result.countAshTrees() == 1);
		}
	}

}
