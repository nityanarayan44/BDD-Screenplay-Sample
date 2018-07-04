package org.nng.qa.framework.BDDScreenplay.questions.yahoo;

import org.nng.qa.framework.BDDScreenplay.actions.Select;
import org.nng.qa.framework.BDDScreenplay.ui.yahoo.Yahoo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ReadYahoo implements Question<String> {

	private String subject;
	
	public ReadYahoo(String subject) {
		this.subject = subject;
	}

	@Override
	public String answeredBy(Actor actor) {

		actor.attemptsTo(Select.byVisibleText(Yahoo.MAIL_SUBJECT, subject));
		System.out.println("Mail : "+Text.of(Yahoo.MAIL_DATA).viewedBy(actor).asString());
		return Text.of(Yahoo.MAIL_DATA).viewedBy(actor).asString();
	}
	
	
	public static ReadYahoo mail(String subject) {
		
			return new ReadYahoo(subject);		
	}

}
