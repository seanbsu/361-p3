package tm;

public class TMSimulator {

    public static void main (String[] args) {
        // basic machine, will move to test
        TuringMachine tm = new TuringMachine();
        State s0 = new State(0);
        State s1 = new State(1);
        s0.addTransition(new Transition(1, 1, 'R', 1));
        s1.addTransition(new Transition(1, 1, 'R', 1));
        tm.addState(s0);
        tm.addState(s1);

        String input = "111";

        tm.run(input);
    }
}
