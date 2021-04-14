/**
 * 
 */
package dev.sylvain.algo.forest.conf;

import java.util.Properties;

import dev.sylvain.algo.forest.conf.datasource.IConfDataSource;

/**
 * @author sbrunon
 *
 */
public class ConfigLoader implements IConfLoader {
	
	private IConfDataSource dataSource;

	/**
	 * @param dataSource
	 */
	public ConfigLoader(IConfDataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public Properties loadProperties() throws ConfigLoaderException {
		return this.dataSource.loadProperties();
	}
	
	/**
	 * @return the dataSource
	 */
	public IConfDataSource getDataSource() {
		return dataSource;
	}

}
