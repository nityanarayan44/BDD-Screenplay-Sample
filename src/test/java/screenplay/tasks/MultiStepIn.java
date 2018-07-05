//------------------------------------------------
// Package
//------------------------------------------------
package screenplay.tasks;

//------------------------------------------------
// Imports
//------------------------------------------------
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import screenplay.commons.Constants;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;

// Class
public class MultiStepIn implements Task {

	//======================
    // Globals
	//======================
	private int first, second;
	
	//======================
	// Constructor Methods
	//======================
		public MultiStepIn(int first, int second) {
			this.first = first;
			this.second = second;
			
			//
			System.out.println("1: " + first + ", 2: " + second);
		}
    
	//==================
	// Overridden Task
	//==================
		@Override
	    @Step("{0} navigates to #url")
	    public <T extends Actor> void performAs(T actor) { 
			
			//
			ExecutorService es = Executors.newCachedThreadPool();
			
			// Using Threads
			//for(int index=0; index<5; index++)
			es.execute(new Runnable() {

					@Override
					public void run() {
						try {
							//BrowseTheWeb.as(actor).getDriver().manage().window().setSize(new Dimension(600, 800));	
							//actor.wasAbleTo(Open.url("https://google.com"));
							//actor.wasAbleTo(Open.url(Constants.STEPIN_LOGIN_URL));
							//actor.attemptsTo( StepInLogin.withCredentials("tm1@testmile.org/Testing123") );
							
							// Displaying the thread that is running
			    	            System.out.println ("Thread " + Thread.currentThread().getId() + " is running");
			    	        } catch (Exception e)
			    	        {
			    	            // Throwing an exception
			    	        		e.printStackTrace();
			    	            System.out.println ("Exception is caught");
			    	        }
						
					} /*  your task */ });
			es.shutdown();
			try {
				boolean finshed = es.awaitTermination(2, TimeUnit.MINUTES);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //actor.attemptsTo(Open.url(url));
	    }
	
	//=================
	// Builders
	//=================
		public static MultiStepIn to(int prevRandomIndex, int nextRandomIndex) {
	        return instrumented(MultiStepIn.class, prevRandomIndex, nextRandomIndex);
	    }
    
}

