// PACKAGE
package org.nng.qa.framework.BDDScreenplay.ui;

// IMPORT
import net.serenitybdd.screenplay.targets.Target;

// CLASS
public class Samples {

		// XPath Axis to be used further
		// For Next Sibling:: //*/following-sibling::<Conditions>
		// For Childs:: //*/descendant::<Conditions>
		// For Parent:: //*/ancestor::<Conditions>
		
		// XPATH SAMPLES WITH AXIS
		public static Target SAMPLE_WITH_PROPERTY_CAONTAINS = Target.the("Element that contains some property").locatedBy("//*[contains(@class, 'primary-header')]");
		
}
