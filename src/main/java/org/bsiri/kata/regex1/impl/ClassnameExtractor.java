package org.bsiri.kata.regex1.impl;

import org.bsiri.kata.regex1.LogExtractor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ClassnameExtractor implements LogExtractor {
	@Override
	public List<String> extract(List<String> logLines) {
		Pattern p = Pattern.compile(".*== ([^\\s]*).*");

		return logLines.stream()
			.map(line -> {
				Matcher matcher = p.matcher(line);
				matcher.matches();
				return matcher.group(1);
			}).collect(Collectors.toList());
	}
}
