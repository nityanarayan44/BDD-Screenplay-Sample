//---------------------------------------------------------
// Package
//---------------------------------------------------------
package screenplay.runner;

//---------------------------------------------------------
// Import Section
//---------------------------------------------------------
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import screenplay.config.Configuration;

//---------------------------------------------------------
// Cucumber+Serenity Runner Configurations
//---------------------------------------------------------
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
	plugin		= { "json:reports/cucumber.json" },
	features		= { "src/test/resources/features/" }, 
	glue 		= { "screenplay.stepDefs" },
	dryRun 		= false,
	monochrome 	= true
	,tags = {"@Demo"}
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
