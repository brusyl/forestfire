package dev.sylvain.algo.forest;

import java.io.File;
import java.util.Properties;

import dev.sylvain.algo.forest.conf.ConfigLoader;
import dev.sylvain.algo.forest.conf.datasource.DefaultConfDataSource;
import dev.sylvain.algo.forest.conf.datasource.FileConfDataSource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Properties props = null;
        
        String filePath = System.getProperty("file");
        if (filePath != null) {
        	File file = new File(filePath);
        	if (file.exists()) {
        		FileConfDataSource fileDataSource = new FileConfDataSource(file);
        		ConfigLoader fileConfigLoader = new ConfigLoader(fileDataSource);
        		props = fileConfigLoader.loadProperties();
        	}
        }
        
        if (props == null) {
        	DefaultConfDataSource defaultDataSource = new DefaultConfDataSource();
        	ConfigLoader defaultConfigLoader = new ConfigLoader(defaultDataSource);
        	props = defaultConfigLoader.loadProperties();
        }
        
        System.out.println(props.getProperty(Constants.PROP_GRID_HEIGHT));
    }
}
