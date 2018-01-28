/**
 * 
 */
package org.nng.utils;

import net.serenitybdd.screenplay.targets.Target;

public class CreateTarget {

  /**
   * Create target for provided xpath
   * @param xpath xpath or css in String 
   * @param toReplace  the text which we want to replace in xpath
   * @param replaceWith the text we want to replace with
   * @param titleOfTarget title for target
   * @return
   */
  public static Target using(String xpath, String toReplace, String replaceWith, String titleOfTarget) {

          xpath = xpath.replaceAll(toReplace, replaceWith); 
          return Target.the(titleOfTarget).locatedBy(xpath);
  }
  
}
