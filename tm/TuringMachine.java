package tm;

import java.util.HashMap;
import java.util.Map;

public class TuringMachine {

    private Tape tape;
    private final Map<Integer, State> states;
    private int numStates; // needed to look up the highest(halting) state

    public TuringMachine() {
        states = new HashMap<>();
        numStates = 0;
    }

    /**
     * Gets the Tape from the last successful run
     * May return null
     *
     * @return the tape from the last run
     */
    public Tape getTape() {
        return tape;
    }

    /**
     * Adds a state to this machine
     * The state with name 0 is the start state
     * The state with the highest number name will be the accept state
     *
     * @param state the state to add
     */
    public void addState(State state) {
        states.put(state.getName(), state);
        numStates++;
    }

    /**
     * Uses the state labels to get the start state
     *
     * @return the state with label 0
     */
    public State getStartState() {
        return states.get(0);
    }

    /**
     * Uses the state labels to get the halting state
     *
     * @return the state with label (numStates - 1)
     */
    public State getHaltState() {
        return states.get(numStates - 1);
    }

    /**
     * Runs the turing machine with the given input
     *
     * @param input the input string to be loaded into tape
     * @return true if the machine halted
     */
    public boolean run(String input) {
        tape = new Tape(input);
        State current = getStartState();

        Transition nextTrans;
        while ((nextTrans = current.getTransition(tape.getValue())) != null) { // read until tm halts
            tape.setValue(nextTrans.getWrite()); // write
            tape.move(nextTrans.getDirection()); // move
            current = nextTrans.getNextState(); // go to next state
        }

        return current == getHaltState();
    }
}
