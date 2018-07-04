package screenplay.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class HasLabel implements Question<List<String>> {


  private Target target;
  private List<String> listString = new ArrayList<>();

  public HasLabel(Target target) {

    this.target = target;
  }

  public HasLabel() {
  }

  @Override
  public List<String> answeredBy(Actor actor) {
    // TODO Auto-generated method stub

     Assert.assertNotNull(listString);
     return  target.resolveAllFor(actor).stream().map(WebElementFacade::getText).collect(Collectors.toList());
 
  }
 

  public HasLabel of(Target target) {
    return new HasLabel(target);
  }

}
