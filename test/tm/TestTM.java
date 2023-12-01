package test.tm;

import org.junit.*;

import tm.State;
import tm.Transition;
import tm.TuringMachine;

import static org.junit.Assert.*;

public class TestTM {

    @Test
    public void testGetStartState() {
        TuringMachine tm1 = new TuringMachine();
        TuringMachine tm2 = new TuringMachine();
        TuringMachine tm3 = new TuringMachine();
        State s0 = new State(0);
        State s1 = new State(1);
        State s2 = new State(2);

        tm1.addState(s0);
        tm1.addState(s1);
        tm1.addState(s2);
        tm2.addState(s1);
        tm2.addState(s2);
        tm2.addState(s0);
        tm3.addState(s1);
        tm3.addState(s2);

        assertEquals(s0, tm1.getStartState());
        assertEquals(s0, tm2.getStartState());
        assertNull(tm3.getStartState());
    }

    @Test
    public void testGetHaltState() {
        TuringMachine tm1 = new TuringMachine();
        TuringMachine tm2 = new TuringMachine();
        TuringMachine tm3 = new TuringMachine();
        State s0 = new State(0);
        State s1 = new State(1);
        State s2 = new State(2);

        tm1.addState(s0);
        tm1.addState(s1);
        tm1.addState(s2);
        tm2.addState(s1);
        tm2.addState(s2);
        tm2.addState(s0);
        tm3.addState(s1);
        tm3.addState(s0);

        assertEquals(s2, tm1.getHaltState());
        assertEquals(s2, tm2.getHaltState());
        assertEquals(s1, tm3.getHaltState());
    }

    private static TuringMachine t1() {
        TuringMachine tm = new TuringMachine();
        State s0 = new State(0);
        State s1 = new State(1);
        s0.addTransition(new Transition(1, 1, 'R', s0));
        s0.addTransition(new Transition(0, 0, 'R', s1));
        tm.addState(s0);
        tm.addState(s1);
        return tm;
    }

    @Test
    public void testT1_111() {
        TuringMachine tm = t1();
        assertTrue(tm.run("111"));
        assertEquals("11100", tm.getTape().toString());
    }

    @Test
    public void testFile0() {
        TuringMachine tm = new TuringMachine();
        State[] states = new State[4];
        for (int i = 0; i < 4; i++) {
            states[i] = new State(i);
        }
        states[0].addTransition(new Transition(0, 1, 'R', states[1]));
        states[0].addTransition(new Transition(1, 1, 'L', states[2]));
        states[1].addTransition(new Transition(0, 1, 'L', states[0]));
        states[1].addTransition(new Transition(1, 1, 'R', states[1]));
        states[2].addTransition(new Transition(0, 1, 'L', states[1]));
        states[2].addTransition(new Transition(1, 1, 'R', states[3]));
        for (int i = 0; i < 4; i++) {
            tm.addState(states[i]);
        }

        assertTrue(tm.run(""));
        assertEquals("111111", tm.getTape().toString());
        assertTrue(tm.run("111"));
        assertEquals("1111111", tm.getTape().toString());
    }

    @Test
    public void testFile2(){
        TuringMachine tm = new TuringMachine();
        State[] states = new State[5];
        for (int i = 0; i < 5; i++) {
            states[i] = new State(i);
        }
        states[0].addTransition(new Transition(0, 1, 'L', states[2]));
        states[0].addTransition(new Transition(1, 2, 'L', states[4]));
        states[0].addTransition(new Transition(2, 0, 'L', states[1]));
        states[0].addTransition(new Transition(3, 0, 'L', states[3]));
        states[1].addTransition(new Transition(0, 3, 'R', states[3]));
        states[1].addTransition(new Transition(1, 3, 'L', states[3]));
        states[1].addTransition(new Transition(2, 3, 'L', states[3]));
        states[1].addTransition(new Transition(3, 1, 'R', states[1]));
        states[2].addTransition(new Transition(0, 3, 'L', states[1]));
        states[2].addTransition(new Transition(1, 3, 'L', states[2]));
        states[2].addTransition(new Transition(2, 1, 'R', states[0]));
        states[2].addTransition(new Transition(3, 1, 'R', states[2]));
        states[3].addTransition(new Transition(0, 1, 'R', states[0]));
        states[3].addTransition(new Transition(1, 0, 'R', states[1]));
        states[3].addTransition(new Transition(2, 2, 'R', states[0]));
        states[3].addTransition(new Transition(3, 2, 'R', states[2]));
        for (int i = 0; i < 5; i++) {
            tm.addState(states[i]);
        }

        assertTrue(tm.run(""));
        String output = tm.getTape().toString(true);
        assertEquals(140, output.length());
        int sum = 0;
        for(int i = 0; i < output.length(); i++){
            sum += Character.digit(output.charAt(i), 10);
        }
        assertEquals(414, sum);
    }

    @Test
    public void testFile5(){
        TuringMachine tm = new TuringMachine();
        State[] states = new State[4];
        for (int i = 0; i < 4; i++) {
            states[i] = new State(i);
        }
        states[0].addTransition(new Transition(0, 3, 'R', states[1]));
        states[0].addTransition(new Transition(1, 0, 'R', states[0]));
        states[0].addTransition(new Transition(2, 0, 'L', states[2]));
        states[0].addTransition(new Transition(3, 2, 'L', states[2]));
        states[1].addTransition(new Transition(0, 1, 'L', states[2]));
        states[1].addTransition(new Transition(1, 0, 'R', states[2]));
        states[1].addTransition(new Transition(2, 3, 'L', states[1]));
        states[1].addTransition(new Transition(3, 2, 'R', states[2]));
        states[2].addTransition(new Transition(0, 3, 'R', states[0]));
        states[2].addTransition(new Transition(1, 0, 'R', states[1]));
        states[2].addTransition(new Transition(2, 3, 'R', states[3]));
        states[2].addTransition(new Transition(3, 0, 'L', states[1]));
        for (int i = 0; i < 4; i++) {
            tm.addState(states[i]);
        }

        assertTrue(tm.run(""));
        String output = tm.getTape().toString(true);
        assertEquals(20430, output.length());
        int sum = 0;
        for(int i = 0; i < output.length(); i++){
            sum += Character.digit(output.charAt(i), 10);
        }
        assertEquals(47189, sum);
    }
}
