/**
 * 
 */
package dev.sylvain.algo.forest.conf.datasource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import dev.sylvain.algo.forest.conf.ConfigLoaderException;

/**
 * @author sbrunon
 *
 */
public abstract class InputStreamConfDataSource implements IConfDataSource {
	
	public Properties fillProperties(InputStream input) throws ConfigLoaderException {
		try {
			Properties props = new Properties();
			
			// Load properties from input stream
	        props.load(input);
	        
	        if (input != null) {
	        	input.close();
	        }
	        
	        return props;
		} catch (IOException e) {
			throw new ConfigLoaderException(e);
		}
	}
}
