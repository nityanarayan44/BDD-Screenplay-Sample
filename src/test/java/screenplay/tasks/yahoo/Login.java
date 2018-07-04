package screenplay.tasks.yahoo;

import library.utils.Manupulate;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.PerformsTasks;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import screenplay.actions.WaitUntil;
import screenplay.commons.Constants;
import screenplay.ui.yahoo.Yahoo;

public class Login implements Performable {

	
	String user, password;
	
	public Login(String user) {
		String[] credentials = Manupulate.extractUserCredentials(user);
		this.user = credentials[Constants.ZERO].toString();
		this.password = credentials[Constants.ONE].toString();
	}


	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(WaitUntil.elementIsClickable(Yahoo.EMAIL_INPUT));
		actor.attemptsTo(Enter.theValue(user).into(Yahoo.EMAIL_INPUT), Click.on(Yahoo.NEXT_BTN));
		actor.attemptsTo(WaitUntil.elementIsClickable(Yahoo.PASSWORD_INPUT));
		actor.attemptsTo(Enter.theValue(password).into(Yahoo.PASSWORD_INPUT), Click.on(Yahoo.SIGN_IN_BTN));
		actor.attemptsTo(WaitUntil.elementIsClickable(Yahoo.MAIL_BTN), Click.on(Yahoo.MAIL_BTN));

	
	}
	
	
	public static Login as(String user) {
		
		return Instrumented.instanceOf(Login.class).withProperties(user);
	}

	

}
