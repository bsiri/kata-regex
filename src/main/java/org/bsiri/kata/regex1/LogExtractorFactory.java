package org.bsiri.kata.regex1;

public class LogExtractorFactory {

	private LogExtractorFactory(){}

	// ********************* Level 1 ***********************************************

	public static LogExtractor createClassFilterExtractor(String classname){
		return passThrough;
	}

	public static LogExtractor createClassnameExtractor(){
		return passThrough;
	}

	public static LogExtractor createMonsterWorkdayExtractor(String classname){
		return passThrough;
	}

	public static LogExtractor createAfternoonNoInfoExtractor(){
		return passThrough;
	}

	public static LogExtractor createTimeTwisterExtractor(){
		return passThrough;
	}

	// ********************* Level 2 ***********************************************

	public static LogExtractor createBeastListExtractor(){
		return passThrough;
	}

	// practice with 'Matcher.find' if you can
	public static LogExtractor createGiantReporter(){
		return passThrough;
	}

	public static LogExtractor createSneezingLimiter(){
		return passThrough;
	}

	// don't cheat and use the argument as is
	public static LogExtractor createEscapistCapturer(String escapistName){
		return passThrough;
	}

	// ********************* Level 3 ***********************************************

	public static LogExtractor createPrettyPrinterExtractor(){
		return passThrough;
	}



	public static LogExtractor passThrough = (lines) ->  lines;
}
