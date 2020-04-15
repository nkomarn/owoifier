package xyz.nkomarn.owoifier.util;

/**
 * Utility class containing methods to
 * programmatically "owoify" text.
 */
public class Owoification {
    /**
     * Uses a highly complex algorithm to programmatically
     * "owoify" a given string and output an "owoified" string.
     * @param text Un-"owoified" string of text
     * @return An "owoified" string of text
     */
    public static String owoify(final String text) {
        return text.replace("l", "w").replace("L", "W")
                .replace("r", "w").replace("R", "W")
                .replace("o", "u").replace("O", "U");
    }
}
