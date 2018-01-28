//Package
package org.nng.BDDScreenplay.example1.questions;

// Imports
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

//Class
public class Assert implements Question<Boolean>{

	// Globals
	private String str_One;
	private String str_Two;
	private boolean status;
	
	// Constructor
	public Assert() {}
	public Assert(String str1, String str2) {
		this.str_One = str1;
		this.str_Two = str2;
		this.status = false;
	}
	
	/* 
	 * Question's execution for answer
	 * ------------------------------------------------
	 * -- [Question Execution to get boolean answer] --
	 * ------------------------------------------------
	 */
	public Boolean answeredBy(Actor actor) {
		
		// Match the criteria and set the boolean status
		this.status = ( (this.str_One.toLowerCase()).contains(this.str_Two.toLowerCase()) || (this.str_One.toLowerCase()).equalsIgnoreCase(this.str_Two.toLowerCase()) ) ? true : false;
				
		// Return the answer for the asked criteria
		return this.status;
	}
	
	// Questions [Overloaded approach]
	public Assert string(String s1, String s2) {
		return new Assert(s1, s2);
	}
	
}/*EOC*/