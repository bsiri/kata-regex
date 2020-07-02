package org.bsiri.kata.regex1.impl;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.bsiri.kata.regex1.LogExtractor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GiantMessReporterExtractor implements LogExtractor {
	@Override
	public List<String> extract(List<String> logLines) {
		List<String> result = logLines.stream()
			.filter(line -> line.contains("Giant"))
			.flatMap(line -> {
				Pattern p = Pattern.compile("([\\w\\s]+);");
				Matcher m = p.matcher(line);

				List<String> report = new ArrayList<>();

				int lastColumnIdx = line.lastIndexOf(":");
				m.find(lastColumnIdx);

				do{
					report.add(m.group(1));
				}
				while(m.find());

				return report.stream();

			})
			.map((String line) -> line.trim())
			.collect(Collectors.toList());

		result.add(0, "What happened is : ");
		return result;
	}
}
