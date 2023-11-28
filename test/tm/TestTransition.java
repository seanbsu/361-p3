package test.tm;

import org.junit.Test;

import static org.junit.Assert.*;

import tm.Transition;

public class TestTransition {

    @Test
    public void testTransitionConstructor() {
        Transition t = new Transition(1, 0, 'R', 3);
        assertEquals(1, t.getRead());
        assertEquals(0, t.getWrite());
        assertEquals('R', t.getDirection());
        assertEquals(3, t.getNextState());
    }
}
