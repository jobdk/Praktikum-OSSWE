package de.jodbk;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {

    private Queue queue;

    @Before
    public void init() {
        queue = new Queue(3);
    }

    @Test(expected = IllegalStateException.class)
    public void test_dequeue_returns_IllegalStateException() {
        queue.dequeue();
    }

}
