package org.bsiri.kata.regex1.impl;

import org.bsiri.kata.regex1.LogExtractor;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AfternoonNoInfoExtractor implements LogExtractor {
	@Override
	public List<String> extract(List<String> logLines) {
		return logLines.stream()
			.filter(line -> line.matches("\\[(DEBUG|ERROR)\\] 1[2-9].*"))
				   .collect(Collectors.toList());
	}
}
