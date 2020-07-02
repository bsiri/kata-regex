package org.bsiri.kata.regex1.impl;

import org.bsiri.kata.regex1.LogExtractor;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ClassFilterExtractor implements LogExtractor {
	private String classname;
	public ClassFilterExtractor(String classname){
		this.classname = classname;
	}
	@Override
	public List<String> extract(List<String> logLines) {
		Pattern p = Pattern.compile(".*== "+classname);
		return logLines.stream()
			.filter(line -> p.matcher(line).find())
			.collect(Collectors.toList());
	}
}
