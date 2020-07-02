package org.bsiri.kata.regex1.impl;

import org.bsiri.kata.regex1.LogExtractor;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GoodDoppleGangerExtractor implements LogExtractor {
	private String classname;

	public GoodDoppleGangerExtractor(String classname) {
		this.classname = classname;
	}

	@Override
	public List<String> extract(List<String> logLines) {
		return logLines.stream()
			.filter(line -> {
				Pattern p = Pattern.compile("\\Q"+classname+"\\E");
				return p.matcher(line).find();
			})
			.collect(Collectors.toList());
	}
}
