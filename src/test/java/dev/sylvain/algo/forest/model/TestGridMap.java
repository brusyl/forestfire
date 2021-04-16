/**
 * 
 */
package dev.sylvain.algo.forest.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dev.sylvain.algo.forest.map.MapBuilderException;

/**
 * @author sbrunon
 *
 */
public class TestGridMap {
	
	@Test
	public void testConstructor() {
		GridMap map = new GridMap(5, 10);
		assertNotNull(map);
	}
	
	@Test
	public void testGetSize() throws Exception {
		GridMap map = new GridMap(5, 10);
		assertTrue(map.getSize() == 50);
	}
	
	@Test
	public void testGetTile() throws Exception {
		GridMap map = new GridMap(5, 10);
		
		Tile tile = map.getTile(3, 5);
		// Null because not initialized
		assertNull(tile);
	}
	
	@Test
	public void testOutBoundGetTile() throws Exception {
		GridMap map = new GridMap(5, 10);
		
		assertThrows(MapBuilderException.class, () -> map.getTile(3, 11));
		assertThrows(MapBuilderException.class, () -> map.getTile(6, 4));
	}
	
	@Test
	public void testFindNeighbour() throws Exception {
		GridMap map = new GridMap(5, 10);
		
		Tile[] tiles = map.findNeighbour(3, 3);
		assertTrue(tiles.length == 4);
		
		tiles = map.findNeighbour(0, 4);
		assertTrue(tiles.length == 3);
		
		tiles = map.findNeighbour(4, 9);
		assertTrue(tiles.length == 2);
		
		assertThrows(MapBuilderException.class, () -> map.findNeighbour(5, 10));
		assertThrows(MapBuilderException.class, () -> map.findNeighbour(-5, 5));
	}

}
