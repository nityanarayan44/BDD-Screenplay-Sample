package screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class GmailHomePage {
	public static Target composeButton = Target.the("button of compose mail").locatedBy(".//div[text()='COMPOSE']");

}
