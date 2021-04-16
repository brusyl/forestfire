/**
 * 
 */
package dev.sylvain.algo.forest.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;
import java.util.Properties;

import org.junit.Test;

import dev.sylvain.algo.forest.Constants;
import dev.sylvain.algo.forest.conf.datasource.DefaultConfDataSource;
import dev.sylvain.algo.forest.conf.datasource.FileConfDataSource;
import dev.sylvain.algo.forest.conf.datasource.IConfDataSource;

/**
 * @author sbrunon
 *
 */
public class TestPosition {
		
	@Test
	public void testConstructor() {
		Position position = new Position(0, 1);
		assertNotNull(position);
		assertTrue(position.getX() == 0);
		assertTrue(position.getY() == 1);
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
		assertTrue(positions[1].getX() == 1);
		assertTrue(positions[1].getY() == 3);
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
		assertTrue(positions[0].getX() == 1);
		assertTrue(positions[0].getY() == 2);
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
