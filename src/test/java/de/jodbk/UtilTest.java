package de.jodbk;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UtilTest {
    @Test
    public void test_istErstesHalbjahr_returns_true() {
        boolean result = Util.istErstesHalbjahr(1);

        assertTrue("should be true", result);
    }

    @Test
    public void test_istErstesHalbjahr_returns_false() {
        boolean result = Util.istErstesHalbjahr(7);

        assertFalse("should be false", result);
    }
}
