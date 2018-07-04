// Package
package screenplay.config;

// Import Section
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import library.utils.io.FileSystem;
import screenplay.commons.Constants;

// Class
public class Configuration {

	// ----------------------------------------------
	// GLOBAL VARIABLES
	// ----------------------------------------------
	public static Properties projectConfigurations;
	public static PropertiesConfiguration serenityConfigurations;
	private static String propertyFileName = "";
	private static Integer defaultWait = 120*1000;
	private static final Logger logger = LoggerFactory.getLogger(Configuration.class);

	/** 
	 * ==============================================
	 * Function to Load the configuration file
	 * ============================================== 
	 */
	public static Properties loadProjectConfig(String propertyFile) throws Exception {
		// Set the file name
		propertyFileName = propertyFile;
		FileInputStream configFile = null;
		
		// Load the configuration property file, if its totally null
		if (Configuration.projectConfigurations == Constants.NULL) {
			Configuration.projectConfigurations = new Properties();
			configFile = new FileInputStream( FileSystem.fullPathOfFile(propertyFile) );
			Configuration.projectConfigurations.load(configFile);
			logger.debug("Configuration/Properties file loaded successfully");
		} 
		
		// Return the project Configuration
		return Configuration.projectConfigurations;
	}
	
	public static PropertiesConfiguration loadSerenityConfig(String propertyFile) throws Exception {
		// Set the file name
		propertyFileName = propertyFile;
		
		// Load the Serenity configuration property file, if its totally null
		if (serenityConfigurations == Constants.NULL) {
			serenityConfigurations = new PropertiesConfiguration(propertyFile);
			serenityConfigurations.save();
			logger.info("Serenity Properties File loaded Successfully");
		}
		
		// Return the Serenity Properties Configurations
		return serenityConfigurations;
	}
	
	/** 
	 * ==============================================
	 * Function to Get the Value for the provided key
	 * ==============================================
	 */
	public static String getValueFromConfigurations(String key) {
		
		// Final value to be returned
		String result_ValueForKey = "";
		
		// KEY [ Do Convert to lower case and replace spaces with "-" hyphen]
		// It will help to understand
		key = key.replaceAll(" ", "-").toLowerCase();
		
		// Get the value for the wanted KEY
		try {
			// If Configuration file does not contains, then load the configuration file all again
			Configuration.projectConfigurations = (Configuration.projectConfigurations == Constants.NULL) ? Configuration.projectConfigurations = Configuration.loadProjectConfig( propertyFileName ) : Configuration.projectConfigurations ;
			Configuration.serenityConfigurations = (Configuration.serenityConfigurations == Constants.NULL) ? Configuration.serenityConfigurations = Configuration.loadSerenityConfig( propertyFileName ) : Configuration.serenityConfigurations ;
			
			logger.debug(">>>> [CONFIG] SEARCHING FOR: " + key);
			// Get the KEY from various ENVIRONMNET [SYSTEM ENV > PROJECT_CONFIG > SERENITY_CONFIG]
			if(System.getenv(key) == Constants.NULL) { 
				if(Configuration.serenityConfigurations.containsKey(key)) {
					result_ValueForKey = Configuration.serenityConfigurations.getProperty(key).toString();
				}
			}
			else {
				result_ValueForKey = System.getenv(key);
			}
			logger.debug(">>>> [CONFIG] SEARCH RESULT: " + result_ValueForKey);
			
		} catch (Throwable e) {
			logger.error("[CONFIG] Problem during getting the Value for Provided Key: " + key);
			logger.error("[CONFIG] Please Refer to this Error: " + e.getMessage());
			Assert.assertTrue("[CONFIG] Error while fetching value for "+ key + " :: " + e.getMessage(), false);
		}
	    	// Return the final value
		return result_ValueForKey;
	  }

	/** 
	 * ==============================================
	 * Function to Merge the Properties File
	 * ==============================================
	 */
	public static PropertiesConfiguration mergeTheProjectConfigInToSerenityConfig() throws Exception { 
		// Check for NULL
		if(Configuration.projectConfigurations == Constants.NULL || Configuration.serenityConfigurations == Constants.NULL) {
			logger.error("Can not proceed with merge because one of the Configuration is not loaded yet. ");
			throw new Exception("Can not proceed for Configurations merge, because of the configuration is not loaded yet.");
		}
		// Proceed for merge
		Configuration.projectConfigurations.forEach(
				// Verify, before merging the property
				// It will merge all the config property to the serenity
				(key, value) -> Configuration.verifyAndMergeProperty((String) key, (String) value)
		);
		
		// Save this again
		Configuration.serenityConfigurations.save();
		
		// Return the appended configurations
		return Configuration.serenityConfigurations;
	}
	
	/** 
	 * ==============================================
	 * Function to Merge the Properties/Variables
	 * ==============================================
	 */
	public static void verifyAndMergeProperty(String key, String value) {
		// If property is not duplicate then add
		if( !Configuration.serenityConfigurations.containsKey(key) ) {
			Configuration.serenityConfigurations.addProperty(key, value);
		}
		
	}
	
	/** 
	 * ==============================================
	 * Function to Get the default wait time
	 * ==============================================
	 */
	public static Integer getDefaultWait() {
		// Check for the timeout on the current environment/Properties, if not avaiallble then pass defaultWait from the Configuration
		//if ( (System.getenv("timeout") != Constants.NULL) || !(System.getenv("timeout").isEmpty()) ) return Integer.parseInt(System.getenv("timeout"));
		if ( (Configuration.getValueFromConfigurations("timeout") != Constants.NULL) || !(Configuration.getValueFromConfigurations("timeout").isEmpty()) )
			return Integer.parseInt( Configuration.getValueFromConfigurations("timeout") );
		else
			return Configuration.defaultWait;
	}
	
	/** 
	 * ==============================================
	 * Function to Load the properties file // Initialization
	 * ==============================================
	 */
	public static void initialize() {
		
		 logger.info("[DEBUG] Proceeding with Configurations Initializations");
		// Proceed with the Properties File
		try {
			// 1: Load the configuration file from config.properties
			Configuration.loadProjectConfig(Constants.PROJECT_CONFIG_FILENAME);
			
			// 2: Load the Serenity properties file
			Configuration.loadSerenityConfig(Constants.SERENITY_PROPERTY_FILENAME);
			
			// 3: Merge the Project CONFIG With Serenity Properties
			Configuration.mergeTheProjectConfigInToSerenityConfig();
			
			// Log the status
			logger.info("All the settings/Properties files loaded successfully.");
		} catch(Exception propertyFile) {
			logger.info("FAILED: Error occured in loading Property file, " + "Because of " + propertyFile.getMessage());
			
		}
	}
} // EOClass
