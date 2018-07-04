package screenplay.ui.google;

import net.serenitybdd.screenplay.targets.Target;

public class GoogleSettings {

	// Setting Button 
	public static Target GOOGLE_SETTING_BUTTON = Target.the("Account Setting button").locatedBy("//*[@role='button' and @data-tooltip='Settings']");
	
	// Dropdown of setting list
	public static Target GOOGLE_USER_ICON = Target.the("User Icon button").locatedBy("//*[@role='button' and contains(@title, 'Google Account:')]");
	public static Target GOOGLE_USER_ICON_CHANGE_BUTTON = Target.the("User Icon change button").locatedBy("//*[contains(@aria-label, 'Change profile picture.')]//*[contains(text(), 'Change')]");
	public static Target GOOGLE_USER_ICON_UPLOAD_BUTTON = Target.the("User Icon change button").locatedBy("//*[@role='button' and contains(text(), 'Select a photo from your computer')]/../..");
	//
	//
	public static Target DRAGGABLE_AREA = Target.the("Draggable area").locatedBy("//*[text()='Drag a profile photo here']");
	
	public static Target SET_IMAGE_BUTTON = Target.the("Set Image as User Icon button").locatedBy("(//*[@role='button' and contains(text(), 'Set as profile photo')])[8]");
	//
	
}
