package org.bsiri.kata.regex1.impl;

import org.bsiri.kata.regex1.LogExtractor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TimeTwisterExtractor implements LogExtractor {
	@Override
	public List<String> extract(List<String> logLines) {
		return logLines.stream()
			.map(line -> {
				Pattern p = Pattern.compile("(\\d+):(\\d+):(\\d+)");
				Matcher m = p.matcher(line);
				m.find();
				return m.replaceFirst("$3:$2:$1");
			}).collect(Collectors.toList());
	}
}
