package org.bsiri.kata.regex1.impl;

import org.bsiri.kata.regex1.LogExtractor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WorkdayExtractor implements LogExtractor {
	private String classname;

	public WorkdayExtractor(String classname) {
		this.classname = classname;
	}

	@Override
	public List<String> extract(List<String> logLines) {
		return logLines.stream()
			.filter(line -> line.contains(classname))
			.map(line -> {
				Pattern p = Pattern.compile("(\\d+:\\d+:\\d+).*:(.*)");
				Matcher m = p.matcher(line);
				m.find();
				String hour = m.group(1);
				String activity = m.group(2);
				return String.format("%s :%s", hour, activity);
			}).collect(Collectors.toList());
	}
}
