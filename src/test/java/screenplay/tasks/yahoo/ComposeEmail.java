package screenplay.tasks.yahoo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import screenplay.ui.yahoo.Yahoo;

public class ComposeEmail implements Task {

	private String email;
	private String subject;
	private String body;
	
	public ComposeEmail(String email, String subject, String body) {
		this.email = email;
		this.subject = subject;
		this.body = body;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
		actor.attemptsTo(Click.on(Yahoo.COMPOSE_BTN));
		actor.attemptsTo(Click.on(Yahoo.RECIPIENT), Enter.theValue(email).into(Yahoo.RECIPIENT));
		actor.attemptsTo(Enter.theValue(subject).into(Yahoo.SUBJECT));
		actor.attemptsTo(Enter.theValue(body).into(Yahoo.MESSAGE_BODY));
		actor.attemptsTo(Click.on(Yahoo.SEND));

	}

	

	public static ComposeEmail sendEmail(String email, String subject, String body) {
		return Instrumented.instanceOf(ComposeEmail.class).withProperties(email, subject, body);
	}

}
