package org.nng.qa.framework.BDDScreenplay.ui;

import net.serenitybdd.screenplay.targets.Target;


public class WikipediaMain {

	//On main home page of wiki-pedia
		public final static Target searchBox 	= Target.the("Wiki Search input box on main page").locatedBy("//input[@id='searchInput']");
		public final static Target searchButton= Target.the("Wiki Search button on main page").locatedBy("//button[@type='submit']");
		  
}

