package xyz.nkomarn.owoifier.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class containing methods to
 * programmatically "owoify" text.
 */
public class Owoification {

    static final Pattern NO_PATTERN = Pattern.compile("n(o+)");

    public static final String[] EXPRESSIONS = {
            ">_<", ":3", "ʕʘ‿ʘʔ", ":D", "._.",
            ";3", "xD", "ㅇㅅㅇ", "(人◕ω◕)",
            ">_>", "ÙωÙ", "UwU", "OwO", ":P",
            "(◠‿◠✿)", "^_^", ";_;", "XDDD",
            "x3", "(• o •)", "<_<"
    };

    /**
     * Uses a highly complex algorithm to programmatically
     * "owoify" a given string and output an "owoified" string.
     *
     * @param text Un-"owoified" string of text
     * @return An "owoified" string of text
     */
    public static String owoify(final String text) {
        final String[] words = text.split(" ");
        final List<String> out = new ArrayList<>();

        for (String word : words) {
            // if it's an expression, leave it intact
            if (Arrays.asList(EXPRESSIONS).contains(word)) {
                out.add(word);
                continue;
            }

            // "nooo" -> "nawww"
            final Matcher noMatcher = NO_PATTERN.matcher(word);
            if (noMatcher.matches()) {
                out.add("na" + "w".repeat(noMatcher.group(1).length()));
                continue;
            }

            out.add(
                    // owo speak just doesn't hit the same in caps
                    word.toLowerCase(Locale.ROOT)
                            .replace("l", "w")
                            .replace("r", "w")
                            // replace all 'o's unless at the end of a word
                            .replaceAll("o(?!$)", "u")
                            .replace("th", "d")
            );
        }

        return String.join(" ", out);
    }
}
