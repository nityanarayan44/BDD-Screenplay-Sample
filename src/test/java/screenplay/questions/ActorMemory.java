//Package
package screenplay.questions;

// Imports
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

//Class
public class ActorMemory implements Question<String>{

	// Globals
	private String key, result;
	
	// Constructor
	public ActorMemory(String key) {
		this.key = key;
		this.result = "";
	}
	
	/* 
	 * Question's execution for answer
	 * ------------------------------------------------
	 * -- [Question to get a key from actor memory ] --
	 * ------------------------------------------------
	 */
	public String answeredBy(Actor actor) {
		
		// Get the key from actor memory
		this.result = actor.recall(this.key).toString();
				
		// Return the answer for the asked criteria
		return this.result;
	}
	
	// Questions [Overloaded approach]
	public static ActorMemory recall(String key) {
		return new ActorMemory(key);
	}
	
}/*EOC*/