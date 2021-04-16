package dev.sylvain.algo.forest;

import java.io.File;
import java.util.Properties;

import dev.sylvain.algo.forest.conf.ConfigLoader;
import dev.sylvain.algo.forest.conf.datasource.DefaultConfDataSource;
import dev.sylvain.algo.forest.conf.datasource.FileConfDataSource;
import dev.sylvain.algo.forest.map.TreeMapBuilder;
import dev.sylvain.algo.forest.model.Position;
import dev.sylvain.algo.forest.print.BasicLogView;
import dev.sylvain.algo.forest.print.IView;
import dev.sylvain.algo.forest.simulator.SimulatorManager;
import dev.sylvain.algo.forest.simulator.SimulatorParameter;
import dev.sylvain.algo.forest.simulator.TreeSimulator;
import dev.sylvain.algo.forest.simulator.TreeSimulatorResult;

/**
 * Simulator
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Properties props = null;
        
        // Get properties
        if (args.length > 0 && args[0] != null) {
        	File file = new File(args[0]);
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
        
        // Format properties
        Position[] startPositions = Position.parseString(props.getProperty(Constants.PROP_START_POSITIONS));
        float probability = Float.parseFloat(props.getProperty(Constants.PROP_PROBABILITY));
        int rows = Integer.parseInt(props.getProperty(Constants.PROP_GRID_ROWS));
        int columns = Integer.parseInt(props.getProperty(Constants.PROP_GRID_COLUMNS));
        
        // Initialize simulator
        IView view = new BasicLogView();
        view.message("Simulation d'incendie : O = OK, B = Brule, X = En cendre");
        
        TreeMapBuilder mapBuilder = new TreeMapBuilder(columns, rows);
        SimulatorParameter parameter = new SimulatorParameter(mapBuilder.build(), startPositions, probability);
        TreeSimulator simulator = new TreeSimulator(parameter);
        SimulatorManager manager = new SimulatorManager(simulator, view);
        
        // Play simulator
        manager.process();
        TreeSimulatorResult simulatorResult = (TreeSimulatorResult) manager.result();
         
        view.message("Incendie sur " + simulatorResult.getLastStep().getStepNumber() + " étapes, il y a " + simulatorResult.countAshTrees() + " arbres en cendre");
    }
}
