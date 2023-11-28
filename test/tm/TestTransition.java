package test.tm;

import org.junit.Test;

import static org.junit.Assert.*;

import tm.State;
import tm.Tape;
import tm.Transition;

public class TestTransition {

    @Test
    public void testTransitionConstructor() {
        State s = new State(0);
        Transition t = new Transition(1, 0, 'R', s);
        assertEquals(1, t.getRead());
        assertEquals(0, t.getWrite());
        assertEquals(Tape.Direction.RIGHT, t.getDirection());
        assertEquals(s, t.getNextState());
    }
}
