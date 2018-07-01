// PACKAGE
package org.nng.qa.framework.BDDScreenplay.questions;

// IMPORT SECTION
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

// CLASS
@Subject("Text of #target")
public class TextOf implements Question<String> {

	//---------------------------------------------------------
	// GLOBALS
	//---------------------------------------------------------
	private final Target target;

	public TextOf(Target target) {
		this.target = target;
	}

	//---------------------------------------------------------
	// Questen's answer : as String
	//---------------------------------------------------------
	@Override
	public String answeredBy(Actor actor) {
		// Scroll the element in view to see it on Screenshot
		actor.attemptsTo(Scroll.to(this.target));
		// Get the text of the Target element
		return Text.of(target).viewedBy(actor).asString();
	}
	
	//---------------------------------------------------------
	// BUIDLERs
	//---------------------------------------------------------

	public static TextOf target(Target target) {
		return (new TextOf(target));
	}
}
