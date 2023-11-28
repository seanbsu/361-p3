package test.tm;

import org.junit.*;

import tm.State;
import tm.Transition;
import tm.TuringMachine;

import static org.junit.Assert.assertTrue;

public class TestTM {
    private static TuringMachine t1(){
        TuringMachine tm = new TuringMachine();
        State s0 = new State(0);
        State s1 = new State(1);
        s0.addTransition(new Transition(1, 1, 'R', 0));
        s0.addTransition(new Transition(0, 0, 'R', 1));
        tm.addState(s0);
        tm.addState(s1);
        return tm;
    }

    @Test
    public void testT1_111() {
        TuringMachine tm = t1();
        assertTrue(tm.run("111"));
    }
}
