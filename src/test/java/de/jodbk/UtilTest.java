package de.jodbk;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UtilTest {


    @Test(expected = IllegalArgumentException.class)
    public void test_istErstesHalbjahr_returns_IllegalStateException_with_0() {
        Util.istErstesHalbjahr(0);
    }


    @Test
    public void test_istErstesHalbjahr_returns_true_with_1() {
        boolean result = Util.istErstesHalbjahr(1);

        assertTrue("should be true", result);
    }


    @Test
    public void test_istErstesHalbjahr_returns_true_with_6() {
        boolean result = Util.istErstesHalbjahr(6);

        assertTrue("should be true", result);
    }


    @Test
    public void test_istErstesHalbjahr_returns_false_with_7() {
        boolean result = Util.istErstesHalbjahr(7);

        assertFalse("should be false", result);
    }

    @Test
    public void test_istErstesHalbjahr_returns_false_with_12() {
        boolean result = Util.istErstesHalbjahr(12);

        assertFalse("should be false", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_istErstesHalbjahr_returns_IllegalStateException_with_13() {
        Util.istErstesHalbjahr(13);
    }
}
