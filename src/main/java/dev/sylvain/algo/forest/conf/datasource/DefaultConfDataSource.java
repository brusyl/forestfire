/**
 * 
 */
package dev.sylvain.algo.forest.conf.datasource;

import java.io.InputStream;
import java.util.Properties;

import dev.sylvain.algo.forest.conf.ConfigLoaderException;

/**
 * Load config from resource
 * @author sbrunon
 *
 */
public class DefaultConfDataSource extends InputStreamConfDataSource {
	
	private static final String CONF_FILE_NAME = "config.properties";

	@Override
	public Properties loadProperties() throws ConfigLoaderException {
		System.out.println("Load default configuration");
		InputStream input = DefaultConfDataSource.class.getClassLoader().getResourceAsStream(CONF_FILE_NAME);

		return this.fillProperties(input);
	}

}
