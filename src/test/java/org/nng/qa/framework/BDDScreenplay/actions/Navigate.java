package org.nng.qa.framework.BDDScreenplay.actions;

// Imports
import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

// Class
public class Navigate implements Task {

	//---------------------------------------------------------
	// GLOBALs
	//---------------------------------------------------------
	private String url;
	
	//---------------------------------------------------------
	// Constructor
	//---------------------------------------------------------
	public Navigate (String url) {
		this.url = url;
	}
	
	//---------------------------------------------------------
	// Action to be perform
	//---------------------------------------------------------
	@Override
	@Step("{0} navigate to #url")
	public <T extends Actor> void performAs(T actor) {
		if (url.contains("http")) {
			actor.attemptsTo(Open.url(url));
		}
	}
	
	//---------------------------------------------------------
	// Builder
	//---------------------------------------------------------
	public static Navigate to(String url) {
		return instrumented(Navigate.class, url);
	}

}