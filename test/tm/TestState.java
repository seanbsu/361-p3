package test.tm;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import tm.State;
import tm.Transition;


public class TestState {

    @Test
    public void testStateConstructor() {
        State s = new State(1);
        assertEquals("1", s.toString());
    }

    @Test
    public void testAddTransition() {
        State state = new State(1);
        Transition t1 = new Transition(1, 0, 'R', state);
        Transition t2 = new Transition(0, 1, 'L', state);

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
        Transition t1 = new Transition(1, 0, 'R', state);
        Transition t2 = new Transition(0, 1, 'L', state);

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
}
