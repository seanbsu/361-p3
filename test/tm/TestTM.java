package test.tm;

import org.junit.*;
import tm.State;
import tm.Transition;
import tm.Tape;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestTM {

    @Test
    public void testTransitionConstructor() {
        Transition t = new Transition(1, 0, 'R', 3);
        assertEquals(1, t.getRead());
        assertEquals(0, t.getWrite());
        assertEquals('R', t.getDirection());
        assertEquals(3, t.getNextState());
    }

    @Test
    public void testStateConstructor() {
        State s = new State(1);
        assertEquals("1", s.toString());
    }

    @Test
    public void testAddTransition() {
        State state = new State(1);
        Transition t1 = new Transition(1, 0, 'R', 3);
        Transition t2 = new Transition(0, 1, 'L', 2);

        state.addTransition(t1);
        state.addTransition(t2);

        List<Transition> transitions = state.getTransitions();
        assertEquals(2, transitions.size());
        assertTrue(transitions.contains(t1));
        assertTrue(transitions.contains(t2));
    }

    @Test
    public void testSetTransitions() {
        State state = new State(1);
        Transition t1 = new Transition(1, 0, 'R', 3);
        Transition t2 = new Transition(0, 1, 'L', 2);

        ArrayList<Transition> newTransitions = new ArrayList<>();
        newTransitions.add(t1);
        newTransitions.add(t2);

        state.setTransitions(newTransitions);

        List<Transition> transitions = state.getTransitions();
        assertEquals(2, transitions.size());
        assertTrue(transitions.contains(t1));
        assertTrue(transitions.contains(t2));
    }

    @Test
    public void testToString() {
        State state = new State(5);
        assertEquals("5", state.toString());
    }

// Add more tests as needed for specific functionality or edge cases


    @Test
    public void testPrivateNodeConstructor() {
        Tape.NodeWrapper nw = new Tape.NodeWrapper(1);
        assertEquals(1, nw.getValue());
        assertNull(nw.getLeft());
        assertNull(nw.getRight());
    }
}