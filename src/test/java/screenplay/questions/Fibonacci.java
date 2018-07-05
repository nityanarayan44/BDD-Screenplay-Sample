package screenplay.questions;

//Imports
import java.util.ArrayList;
import java.util.Collections;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

//CLASS
public class Fibonacci implements Question<ArrayList<Integer>> {

	// GLOBAL
	private ArrayList<Integer> fSeries;
	//private int result = 0, current = 0, previous = 0, limit = 0;
	private int seed=1, limit=100, current=1, previous = 0, result = 0;
	
	// CONSTRUCTOR
	public Fibonacci(int seed, int limit) {
		this.fSeries = new ArrayList<Integer>();
		this.limit = limit;
		this.current = seed;
	}

	// QUESTION
	@Override
	@Step("{0} Getting the febonicci series")
	public ArrayList<Integer> answeredBy(Actor actor) {
		// Logic
		for(int loop=this.current; this.result < this.limit; loop++) {
			
			// Add
			result = current + previous;
			
			// Set back
			previous = current;
			current  = result;
			
			// Set the value to list
			this.fSeries.add(this.result);
		}
		//shuffle list
		fSeries.subList(0, fSeries.size()-1);
		Collections.shuffle(fSeries);
		// Return the febonicci
		return this.fSeries;
	}
	
	// Builder
	public static Fibonacci getList(int seed, int limit) {
			return new Fibonacci(seed, limit);		
	}

}
