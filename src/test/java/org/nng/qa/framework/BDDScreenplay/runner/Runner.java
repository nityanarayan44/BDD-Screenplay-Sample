//---------------------------------------------------------
// Package
//---------------------------------------------------------
package org.nng.qa.framework.BDDScreenplay.runner;

//---------------------------------------------------------
// Import Section
//---------------------------------------------------------
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.nng.qa.framework.BDDScreenplay.config.Configuration;

//---------------------------------------------------------
// Cucumber+Serenity Runner Configurations
//---------------------------------------------------------
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
	format		= { "json:reports/cucumber.json" },
	features		= { "src/test/resources/features/" }, 
	glue 		= { "org.nng.qa.framework.BDDScreenplay.stepDefs" },
	dryRun 		= false,
	monochrome 	= true

)

//---------------------------------------------------------
// Runner Class
//---------------------------------------------------------
public class Runner {
	
	// Setup Before the Runner class executes stepDefs
	@BeforeClass
	public static void setUp() {
		// Initialize the configurations
		System.out.println("\n\n\n>>>>> Initializing the Configurations ");
		//Initialize.initialize();
		Configuration.initialize();
	}
}
