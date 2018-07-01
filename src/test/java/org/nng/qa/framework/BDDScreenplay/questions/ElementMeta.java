// Package
	package org.nng.qa.framework.BDDScreenplay.questions;

// Imports
	import net.serenitybdd.screenplay.Actor;
	import net.serenitybdd.screenplay.Question;
	import net.serenitybdd.screenplay.targets.Target;

// Class
public class ElementMeta implements Question<String> {

	// Globals
		private String value;
		private Target element;
		private String elementAttribute;
		
	// Constructor
		public ElementMeta() {}
		public ElementMeta(Target element, String elementAttribute) {
			this.value = "";
			this.element = element;
			this.elementAttribute = elementAttribute;
		}
		
	/* 
	 * Question's execution for answer
	 * Query for an attribute value of an Element
	 * @param actor
	 * @return String
	 * --------------------------------------------------
	 * -- [Question Execution to get answer as String] --
	 * --------------------------------------------------
	 */
		public String answeredBy(Actor actor) {
			// Getting the element's requested attribute value
			this.value = this.element.resolveFor(actor).getAttribute(this.elementAttribute);
			  
			// Return the final value
			return this.value;
		}
	
	// ---------------------------------
	// Questions [Overloaded approach]
	// ---------------------------------
		public ElementMeta getAttribute(Target ele, String eleAttrib) {
			return new ElementMeta(ele, eleAttrib);
		}
}
