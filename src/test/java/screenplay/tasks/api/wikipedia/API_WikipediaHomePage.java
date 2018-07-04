// PACKAGE
package screenplay.tasks.api.wikipedia;

// IMPORT SECTION
import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import screenplay.commons.Constants;

// CLASS
public class API_WikipediaHomePage implements Task {

	// ---------------------------------
	// GLOBALS
	// ---------------------------------
	private static final Logger logger = LoggerFactory.getLogger(API_WikipediaHomePage.class);
	private Response restAPIResponse;
	
	// ---------------------------------
	// CONSTRUCTOR
	// ---------------------------------
	public API_WikipediaHomePage() {
		// DO SOMETHING
	}
	
	// ---------------------------------
	// TASKS
	// ---------------------------------
	@Override
	@Step("{0} makes a GET Request to wikipedia")
	public <T extends Actor> void performAs(T theActor) {
			// TODO: CODE
			RestAssured.baseURI = Constants.WIKIPEDIA_HOMEPAGE_API_URL;
			RequestSpecification reqSpec = RestAssured.given()
	                                    .header(":authority", "en.wikipedia.org").header(":method", "GET")
	                                    .accept("accept: application/json; charset=utf-8;")
	                                    .accept("accept-encoding: gzip, deflate, br")
	                                    .accept("accept-language: en-GB,en-US;q=0.9,en;q=0.8")
	                                    .contentType("application/json");
	                                    //.cookie("key", "val");
			// Make request now
			restAPIResponse = reqSpec.get(Constants.WIKIPEDIA_HOMEPAGE_API_URL);
			
			// Remember the response code
			theActor.remember("wikihome-response-code", restAPIResponse.statusCode());
			
			// FLOW
			if(restAPIResponse.statusCode() == 200) {
			        logger.debug("something: SUCCESS");
			        theActor.remember("wikihome-response-body", restAPIResponse.getBody().asString());
			        //System.out.println(restAPIResponse.getBody().asString());
	        } else {
	        			logger.debug("something: FAILURE");
	        }
	}
	
	// ---------------------------------
	// BUIDERS
	// ---------------------------------
	public static API_WikipediaHomePage makeGetRequest() {	
		return instrumented(API_WikipediaHomePage.class);
	}

}
