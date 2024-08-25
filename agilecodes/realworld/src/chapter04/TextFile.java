package chapter04;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class TextFile {


    private final Map<String, String> attributes;
    private final List<String> lines;


    public TextFile(Map<String, String> attributes, List<String> lines) {
        this.attributes = attributes;
        this.lines = lines;
    }


    void addLineSuffix(final String prefix, final String attributeName) {
        for (final String line : lines) {
            if (line.startsWith(prefix)) {
                attributes.put(attributeName, line.substring(prefix.length()));
                break;
            }
        }
    }

    int addLine(
            final int start,
            final Predicate<String> isEnd,
            final String attributeName) {

        final StringBuilder accumlator = new StringBuilder();
        int lineNumber;

        for (lineNumber = start; lineNumber < lines.size(); lineNumber++) {
            final String line = lines.get(lineNumber);
            if (isEnd.test(line)) {
                break;
            }
            accumlator.append(line);
            accumlator.append("\n");
        }
        attributes.put(attributeName, accumlator.toString().trim());
        return lineNumber;
    }

}
