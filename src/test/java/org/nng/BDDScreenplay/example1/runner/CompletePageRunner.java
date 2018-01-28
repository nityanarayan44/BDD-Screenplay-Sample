package org.nng.BDDScreenplay.example1.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

//execute complete test suite
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
	format		= {"json:reports/cucumber.json"},
	features		= { "src/test/resources/features/" }, 
	glue 		= {"org.nng.BDDScreenplay.example1.features.stepDefs" },
	dryRun 		= false,
	monochrome 	= true
//    ,tags			= "@test1"

)

// Runner Class
public class CompletePageRunner {
}
