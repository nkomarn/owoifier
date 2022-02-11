package xyz.nkomarn.owoifier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static xyz.nkomarn.owoifier.util.Owoification.owoify;

/**
 * Automated owo quality assurance.
 */
public class OwoTests {
    @Test
    public void testOwo() {
        Assertions.assertEquals("hewwo wuwwd", owoify("hello world"));
        Assertions.assertEquals("hewwo OwO wuwwd!", owoify("hello OwO world!"));
        Assertions.assertEquals("dat", owoify("that"));

        Assertions.assertEquals("naw", owoify("no"));
        Assertions.assertEquals("nawwwww", owoify("nooooo"));
        // make sure it doesn't replace in the middle of words, "nawt" is a bit weird
        Assertions.assertEquals("nut", owoify("not"));
    }
}
