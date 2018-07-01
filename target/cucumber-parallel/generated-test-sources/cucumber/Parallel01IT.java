import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = { "pretty", "json:reports/cucumber.json" }, 
        strict = true,
        features = {"/Users/ashutosh/NNG_WORKSPACE/PERSONAL/CODE_WORKSPACE/eclipse-workspace/BDD-Screenplay-Sample/src/test/resources/features/Wikipedia_Search/SearchWikipedia.feature:15"},
        
        monochrome = false,
        glue = {"org.nng.BDDScreenplay.example1.features.stepDefs"})
public class Parallel01IT {
}
