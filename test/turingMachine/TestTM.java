package test.turingMachine;

import org.junit.*;
import turingMachine.State;
import turingMachine.Transition;
import turingMachine.Tape;

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
        assertFalse(s.isAccept());
    }

    @Test
    public void testPrivateNodeConstructor(){
        Tape.NodeWrapper nw = new Tape.NodeWrapper(1);
        assertEquals(1, nw.getValue());
        assertNull(nw.getLeft());
        assertNull(nw.getRight());
    }
}