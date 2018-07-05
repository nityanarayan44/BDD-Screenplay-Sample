package screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class StepInStoryPageUi {
	public static Target NEW_STORY_BUTTON  = Target.the("Button to create story").locatedBy("//span[text()='New story']/..");
	public static Target POST_BODY   = Target.the("Body of the story").locatedBy("//*[contains(text(),'Begin writing your story')]/../../../../..");
	
	public static Target POST_TITLE = Target.the("Title of the story").locatedBy("//textarea[@placeholder='Post Title']");
	public static Target PUBLISH_DROPDOWN = Target.the("Title of the story").locatedBy("//span[text()='Publish']");
	public static Target SET_IT_LIVE_NOW = Target.the("Set it live Now option radiobutton").locatedBy("//div[text()='Set it live now']/parent::div/preceding::div/parent::div[contains(@class,'active')]");
	public static Target PUBLISH_BUTTON  = Target.the("Publish button").locatedBy("(//span[text()='Publish'])[1]");
	public static Target CANCEL_BUTTON  = Target.the("Cancel Button").locatedBy("(//span[text()='Publish'])[1]");
	public static Target USER_BLOG  = Target.the("user blog").locatedBy("//div[text()='user Blog']");
	public static Target LOGOUT  = Target.the("logout button").locatedBy("//a[contains(@href,'signout')]");
	public static Target PUBLISHED = Target.the("logout button").locatedBy(".//span[text()='Published']");
}
