package de.jodbk;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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


    @Test
    public void test_dequeue_returns_3() {
        Queue queue = new Queue(2);
        queue.enqueue(3);
        queue.enqueue(2);

        assertEquals("", 3, queue.dequeue());
    }

    @Test
    public void test_dequeue_replacesLastAdded() {
        Queue queue = new Queue(2);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(4);

        assertEquals("The last added number should be replaced", 4, queue.queue[queue.queue.length - 1]);
    }


}
