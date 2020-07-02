package org.bsiri.kata.regex1;

public class LogExtractorFactory {

	private LogExtractorFactory(){}

	// ********************* Level 1 ***********************************************

	// easy !
	public static LogExtractor createClassFilterExtractor(String classname){
		return passThrough;
	}

	// meet the Matcher and capture groups if not done already
	public static LogExtractor createClassnameExtractor(){
		return passThrough;
	}


	// If you've gone so far you should have no problem here, just to demonstrate how useful RE can be
	public static LogExtractor createMonsterWorkdayExtractor(String classname){
		return passThrough;
	}

	// Sorcerer ? Barbarian ? Choose your Character Class wisely ! (winks, winks)
	public static LogExtractor createAfternoonNoInfoExtractor(){
		return passThrough;
	}

	// try to replace directly from the Matcher
	public static LogExtractor createTimeTwisterExtractor(){
		return passThrough;
	}

	// ********************* Level 2 ***********************************************

	// If it helps, remember that you also can negate expressions
	public static LogExtractor createBeastListExtractor(){
		return passThrough;
	}

	// practice with 'Matcher.find' if you can
	public static LogExtractor createGiantReporter(){
		return passThrough;
	}

	// hmm, how can you use that argument as-is ?
	public static LogExtractor createDoppelGangerCapturer(String classname){
		return passThrough;
	}

	// mostly a matter of quantification
	public static LogExtractor createSneezingLimiter(){
		return passThrough;
	}


	// ********************* Level 3 ***********************************************

	// a good synthesis, but don't be too greedy (winks, winks)
	public static LogExtractor createPrettyPrinterExtractor(){
		return passThrough;
	}



	public static LogExtractor passThrough = (lines) ->  lines;
}