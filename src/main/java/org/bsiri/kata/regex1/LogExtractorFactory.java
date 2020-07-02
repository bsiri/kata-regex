package org.bsiri.kata.regex1;

import org.bsiri.kata.regex1.impl.AfternoonNoInfoExtractor;
import org.bsiri.kata.regex1.impl.BeastListExtractor;
import org.bsiri.kata.regex1.impl.ClassFilterExtractor;
import org.bsiri.kata.regex1.impl.ClassnameExtractor;
import org.bsiri.kata.regex1.impl.GoodDoppleGangerExtractor;
import org.bsiri.kata.regex1.impl.GiantMessReporterExtractor;
import org.bsiri.kata.regex1.impl.PrettyPrinterExtractor;
import org.bsiri.kata.regex1.impl.SneezingLimiterExtractor;
import org.bsiri.kata.regex1.impl.TimeTwisterExtractor;
import org.bsiri.kata.regex1.impl.WorkdayExtractor;

public class LogExtractorFactory {

	private LogExtractorFactory(){}

	// ********************* Level 1 ***********************************************

	// easy !
	public static LogExtractor createClassFilterExtractor(String classname){
		return new ClassFilterExtractor(classname);
	}

	// meet the Matcher and capture groups if not done already
	public static LogExtractor createClassnameExtractor(){
		return new ClassnameExtractor();
	}


	// If you've gone so far you should have no problem here, just to demonstrate how useful RE can be
	public static LogExtractor createMonsterWorkdayExtractor(String classname){
		return new WorkdayExtractor(classname);
	}

	// Sorcerer ? Barbarian ? Choose your Character Class wisely ! (winks, winks)
	public static LogExtractor createAfternoonNoInfoExtractor(){
		return new AfternoonNoInfoExtractor();
	}

	// try to replace directly from the Matcher
	public static LogExtractor createTimeTwisterExtractor(){
		return new TimeTwisterExtractor();
	}

	// ********************* Level 2 ***********************************************

	// If it helps, remember that you also can negate expressions
	public static LogExtractor createBeastListExtractor(){
		return new BeastListExtractor();
	}

	// practice with 'Matcher.find' if you can
	public static LogExtractor createGiantReporter(){
		return new GiantMessReporterExtractor();
	}

	// hmm, how can you use that argument as-is ?
	public static LogExtractor createDoppelGangerCapturer(String classname){
		return new GoodDoppleGangerExtractor(classname);
	}

	// mostly a matter of quantification
	public static LogExtractor createSneezingLimiter(){
		return new SneezingLimiterExtractor();
	}


	// ********************* Level 3 ***********************************************

	// a good synthesis, but don't be too greedy (winks, winks)
	public static LogExtractor createPrettyPrinterExtractor(){
		return new PrettyPrinterExtractor();
	}



	public static LogExtractor passThrough = (lines) ->  lines;
}
