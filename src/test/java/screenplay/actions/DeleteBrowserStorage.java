// Package
package screenplay.actions;

// Import Section
import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.openqa.selenium.JavascriptExecutor;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import screenplay.commons.Constants;

// Class
public class DeleteBrowserStorage implements Interaction {
	//---------------------------------------------------------
	// GLOBALs
	//---------------------------------------------------------	
	private String storageVarNameToBeDeleted;
	//---------------------------------------------------------
	// Constructors
	//---------------------------------------------------------		
	public DeleteBrowserStorage() {}
	public DeleteBrowserStorage(String storageVarName) { this.storageVarNameToBeDeleted = storageVarName; }
	
	//---------------------------------------------------------
	// GLOBALs
	//---------------------------------------------------------	
	@Override
	@Step("{0} deletes the browser storage")
	@Screenshots(disabled = true)
	public <T extends Actor> void performAs(T actor) {
		// Wait for the Element, Based on Timeout
		if(this.storageVarNameToBeDeleted != Constants.NULL) {
			// Delete specific storage
			
		} else {
			// Delete all storage
			// Initialize JSExecutor
			JavascriptExecutor js = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
			// clear local session storage
			js.executeScript(String.format("window.localStorage.clear();"));
		}
	}

	//---------------------------------------------------------
	// Action Builders
	//---------------------------------------------------------		
	public static DeleteBrowserStorage all() {
		return instrumented(DeleteBrowserStorage.class);
	}
	public static DeleteBrowserStorage byVariableName(String storageVariableName) {
		return instrumented(DeleteBrowserStorage.class, storageVariableName);
	}
}
