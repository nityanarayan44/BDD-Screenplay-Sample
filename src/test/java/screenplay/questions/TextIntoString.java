package screenplay.questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TextIntoString implements Question<String>{

  
  private Target target;
  private String pattern;
  private String replacement;

  /**
   * @param target 
   * 
   */
  public TextIntoString(Target target, String pattern, String replacement) {

    this.target = target;
    this.pattern = pattern;
    this.replacement = replacement;
  }
  
  /**
   * 
   */
  public TextIntoString() {
    // TODO Auto-generated constructor stub
  }

  /* (non-Javadoc)
   * @see net.serenitybdd.screenplay.Question#answeredBy(net.serenitybdd.screenplay.Actor)
   */
  @Override
  public String answeredBy(Actor actor) {
    
    actor.attemptsTo(WaitUntil.the(target, isVisible()));
    return  Text.of(target).viewedBy(actor).asString().replaceAll(pattern, replacement);
  }
  
  /**
   * Method to get text from an element 
   * @param target
   * @param pattern
   * @param replacement
   * @return replaced text from element with provide patter  
   */
  public TextIntoString of(Target target, String pattern, String replacement) {
    return new TextIntoString( target, pattern, replacement);
    
    
  }

  
  
  

  
  
}
