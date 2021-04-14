/**
 * 
 */
package dev.sylvain.algo.forest.conf;

import java.util.Properties;

/**
 * @author sbrunon
 *
 */
public interface IConfLoader {
	
	/**
	 * Load properties from source. 
	 * @return Properties 
	 * @throws ConfigLoaderException
	 */
	public Properties loadProperties() throws ConfigLoaderException;

}
