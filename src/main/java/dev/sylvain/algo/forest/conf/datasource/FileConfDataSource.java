/**
 * 
 */
package dev.sylvain.algo.forest.conf.datasource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import dev.sylvain.algo.forest.conf.ConfigLoaderException;

/**
 * Load config from file
 * @author sbrunon
 *
 */
public class FileConfDataSource extends InputStreamConfDataSource {
	
	private File file;

	/**
	 * @param filePath
	 */
	public FileConfDataSource(File file) {
		super();
		this.file = file;
	}

	@Override
	public Properties loadProperties() throws ConfigLoaderException {
		System.out.println("Load custom configuration");

		// If config file exists, fill properties in object
		if (this.file != null && this.file.exists()) {
			try {
				InputStream input = new FileInputStream(this.file);
				Properties props = this.fillProperties(input);
				input.close();
				return props;
			} catch (FileNotFoundException e) {
				throw new ConfigLoaderException(e);
			} catch (IOException e) {
				throw new ConfigLoaderException(e);
			}
		}

		// If file not exists return null
		return null;
	}

}
