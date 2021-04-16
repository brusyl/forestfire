/**
 * 
 */
package dev.sylvain.algo.forest.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author sbrunon
 *
 */
public class TestPosition {
		
	@Test
	public void testConstructor() {
		Position position = new Position(0, 1);
		assertNotNull(position);
		assertTrue(position.getRow() == 0);
		assertTrue(position.getColumn() == 1);
	}
	
	@Test
	public void testParsePositions() throws Exception {
		Position[] positions = Position.parseString("1,2");
		assertNotNull(positions);
		assertTrue(positions.length == 1);
	}
	
	@Test
	public void testParseMultiplePositions() throws Exception {
		Position[] positions = Position.parseString("1,2;1,3");
		assertNotNull(positions);
		assertTrue(positions.length == 2);
		assertTrue(positions[1].getRow() == 1);
		assertTrue(positions[1].getColumn() == 3);
	}
	
	@Test
	public void testParseEmptyPositions() throws Exception {
		Position[] positions = Position.parseString("");
		assertNull(positions);
	}
	
	@Test
	public void testParseNullPositions() throws Exception {
		Position[] positions = Position.parseString(null);
		assertNull(positions);
	}
	
	@Test
	public void testParseIncompletePositions() throws Exception {
		Position[] positions = Position.parseString("1,2;1");
		assertNotNull(positions);
		assertTrue(positions.length == 1);
		assertTrue(positions[0].getRow() == 1);
		assertTrue(positions[0].getColumn() == 2);
	}
	
	@Test
	public void testParseNotNumberPositions() throws Exception {
		Exception exception = null;
		try {
			Position.parseString("a,b;c,d");
		} catch (Exception e) {
			exception = e;
		}
		assertNotNull(exception);
	}
}
