// Package
package org.nng.BDDScreenplay.example1.tasks;

//Imports
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.nng.BDDScreenplay.example1.common.Constants;

//Class
public class Navigate implements Task {

    // Globals
		private String url;

	// Constructor Methods
		public Navigate() {
			this.url =  Constants.url;
		}
		public Navigate(String url) {
			this.url = url; 
		}
    
	// Overridden Task
	@Override
    @Step("{0} navigates to #url")
    public <T extends Actor> void performAs(T actor) {  
        actor.attemptsTo(Open.url(url));
    }
	
	// Builders
	public Performable to() {
        return instrumented(Navigate.class);
    }
	public Performable to(String url) {
        return instrumented(Navigate.class, url);
    }
    
}

