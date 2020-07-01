package org.bsiri.kata.regex1;


public class LogExtractorFactory {

	private LogExtractorFactory(){}

	public static LogExtractor createClassFilterExtractor(String classname){
		return passThrough;
	}

	public static LogExtractor createClassnameExtractor(){
		return passThrough;
	}


	public static LogExtractor passThrough = (lines) ->  lines;
}
