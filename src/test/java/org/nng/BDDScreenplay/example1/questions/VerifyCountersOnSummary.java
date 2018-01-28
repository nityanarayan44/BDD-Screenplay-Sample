//Package
package org.nng.BDDScreenplay.example1.questions;

//Import
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

//Class
public class VerifyCountersOnSummary implements Question<Boolean>{

	// Globals
	private float counterAsBefore;
	private float counterAsAfter;
	private Boolean counterAssertionStatus;
	private String action;
	
	// Constructors
	public VerifyCountersOnSummary() {}
	public VerifyCountersOnSummary(float afterCounter, float beforeCounter, String action) {
		this.counterAsAfter = afterCounter;
		this.counterAsBefore= beforeCounter;
		this.action			= action;
	}
	
	/* 
	 * Question's execution for answer
	 * Veifies the Counter on the summary page
	 * ------------------------------------------------
	 * -- [Question Execution to get boolean answer] --
	 * ------------------------------------------------
	 */
	public Boolean answeredBy(Actor actor) {
		
		// Process
		switch(this.action) {
			case "FilterApplied":
				// When filter is applied then Before value should be greater than or equals to the current value
				this.counterAssertionStatus = (this.counterAsBefore >= this.counterAsAfter) ? true : false;
				break;
			case "FilterRemoved": 
				// When filter is removed then Before value should be equals the current value
				this.counterAssertionStatus = (this.counterAsBefore == this.counterAsAfter) ? true : false;
				break;
			default: 
				// do nothing;
		}
		
		// Return the answer for the asked criteria
			return this.counterAssertionStatus;
	}
	
	// Questions
	public VerifyCountersOnSummary isApplicableWithFilter(float afterCounter, float beforeCounter) {
		return new VerifyCountersOnSummary(afterCounter, beforeCounter, "FilterApplied");
	}
	public VerifyCountersOnSummary isApplicableWithOutFilter(float afterCounter, float beforeCounter) {
		return new VerifyCountersOnSummary(afterCounter, beforeCounter, "FilterRemoved");
	}
	
	/** ----------------------------
	 *  -- [Private Modification] --
	 *  ----------------------------
	 */
	
	/**
	 * creates target xpath for chart Edit/Pencil Button
	 * @return Target
	 */
	/*private Target chartEditButton() {
		return Target.the(chartAttribute + " chart").locatedBy(SummaryPageTargets.chartEditBtn.replace("AttributeName", chartAttribute));
	}*/
	
}/*EOC*/