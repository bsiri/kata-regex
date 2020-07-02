package org.bsiri.kata.regex1.impl;

import org.bsiri.kata.regex1.LogExtractor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PrettyPrinterExtractor implements LogExtractor {
	private static final String PATTERN_OF_DEATH =
		".*?(DEBUG|INFO|ERROR).*?\\s*?(\\d+).(\\d+).(\\d+)\\s*.{2}\\s*([\\w]+\\.)*(\\w*)\\s*.(.*)";
	@Override
	public List<String> extract(List<String> logLines) {
		Pattern p = Pattern.compile(PATTERN_OF_DEATH);
		String formatString = "[%s] %s:%s:%s == org.bsiri.randomcode.monster.%s : %s";

		return logLines.stream()
			.filter(line -> p.matcher(line).matches())
			.map(line -> {
				Matcher m = p.matcher(line);
				m.matches();
				String formatted = String.format(formatString,
					m.group(1),
					m.group(2),
					m.group(3),
					m.group(4),
					m.group(6),
					m.group(7));
				return formatted.replaceAll("\\s+", " ");
			}).collect(Collectors.toList());
	}
}
