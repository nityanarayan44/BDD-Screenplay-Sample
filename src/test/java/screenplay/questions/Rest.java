// PACKAGE
package screenplay.questions;

// IMPORT SECTION
import java.util.Arrays;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import screenplay.commons.Constants;

@Subject("Fetch data from rest request")
public class Rest implements Question<String[]> {

	
	private Response restAPIResponse;
	
	public String[] answeredBy(Actor actor) {
		
		RestAssured.baseURI = Constants.REST_URL;
		RequestSpecification reqSpec = RestAssured.given().contentType("application/json");

		// Make request now
		restAPIResponse = reqSpec.get("/posts");
		
		// Remember the response code
		String [] arrayofId = restAPIResponse.body().prettyPrint().split("\\},");
		//ids.addAll(Arrays.asList(arrayofId));
		actor.remember("REST-response", arrayofId);

		System.out.println("rest data is :" + Arrays.toString(arrayofId));
		System.out.println("Size "+ arrayofId.length);
		
		return arrayofId;
		
		
		
}
	
	public static Rest getData() {
		
		return new Rest();
	}
	

}
