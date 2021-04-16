/**
 * 
 */
package dev.sylvain.algo.forest.map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dev.sylvain.algo.forest.model.GridMap;

/**
 * @author sbrunon
 *
 */
public class TestMapBuilder {
	@Test
	public void testConstructor() {
		TreeMapBuilder builder = new TreeMapBuilder(2, 4);
		assertNotNull(builder);
	}
	
	@Test
	public void testBuildMap() throws MapBuilderException {
		TreeMapBuilder builder = new TreeMapBuilder(2, 4);
		GridMap map = builder.build();
		
		assertTrue(map.getSize() == 8);
	}
	
	@Test
	public void testBadRowsBuildMap() {
		TreeMapBuilder builder = new TreeMapBuilder(2, -4);
		MapBuilderException exception = null;
		try {
			builder.build();
		} catch (MapBuilderException e) {
			exception = e;
		}
		
		assertNotNull(exception);
		assertTrue(TreeMapBuilder.ERROR_MESSAGE_ROWS.equals(exception.getMessage()));
	}
	
	@Test
	public void testBadColumnsBuildMap() {
		TreeMapBuilder builder = new TreeMapBuilder(-2, 4);
		MapBuilderException exception = null;
		try {
			builder.build();
		} catch (MapBuilderException e) {
			exception = e;
		}
		
		assertNotNull(exception);
		assertTrue(TreeMapBuilder.ERROR_MESSAGE_COLUMNS.equals(exception.getMessage()));
	}
}
