package org.bsiri.kata.regex1.impl;

import org.bsiri.kata.regex1.LogExtractor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SneezingLimiterExtractor implements LogExtractor {

	@Override
	public List<String> extract(List<String> logLines) {
		return logLines.stream()
			.filter(line -> line.contains("snowwhite"))
			.map(line -> {
				Pattern p = Pattern.compile("(a{1,3})a*\\.{3}");
				Matcher m = p.matcher(line);

				StringBuffer buffer = new StringBuffer();

				while(m.find()){
					m.appendReplacement(buffer, "$1...");
				}
				m.appendTail(buffer);

				return buffer.toString();

			}).collect(Collectors.toList());
	}
}
