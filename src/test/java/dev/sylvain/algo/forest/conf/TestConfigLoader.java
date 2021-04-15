/**
 * 
 */
package dev.sylvain.algo.forest.conf;

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
public class TestConfigLoader {
		
	@Test
	public void testConstructor() {
		IConfDataSource dataSource = new DefaultConfDataSource();
		ConfigLoader loader = new ConfigLoader(dataSource);
		assertNotNull(loader);
	}
	
	@Test
	public void testDefaultConfigLoader() throws Exception {
		IConfDataSource dataSource = new DefaultConfDataSource();
		ConfigLoader loader = new ConfigLoader(dataSource);
		Properties props = loader.loadProperties();
		assertNotNull(props);
		assertTrue("10".equals(props.getProperty(Constants.PROP_GRID_WIDTH)));
		assertTrue("5".equals(props.getProperty(Constants.PROP_GRID_HEIGHT)));
		assertTrue("0.5".equals(props.getProperty(Constants.PROP_PROBABILITY)));
		assertTrue("3,3".equals(props.getProperty(Constants.PROP_START_POSITIONS)));
	}
	
	@Test
	public void testFileConfigLoader() throws Exception {
		ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("fileconfig.properties");
		File configFile = new File(resource.toURI());
		IConfDataSource dataSource = new FileConfDataSource(configFile);
		ConfigLoader loader = new ConfigLoader(dataSource);
		Properties props = loader.loadProperties();
		assertNotNull(props);
		assertTrue("20".equals(props.getProperty(Constants.PROP_GRID_WIDTH)));
		assertTrue("10".equals(props.getProperty(Constants.PROP_GRID_HEIGHT)));
		assertTrue("1".equals(props.getProperty(Constants.PROP_PROBABILITY)));
		assertTrue("4,4".equals(props.getProperty(Constants.PROP_START_POSITIONS)));
	}
	
	@Test
	public void testNotFoundFileConfigLoader() throws Exception {
		String configFilePath = System.getProperty("user.dir") + File.separator + "unknow.properties";
		File configFile = new File(configFilePath);
		IConfDataSource dataSource = new FileConfDataSource(configFile);
		ConfigLoader loader = new ConfigLoader(dataSource);
		Properties props = loader.loadProperties();
		assertNull(props);
	}

}
