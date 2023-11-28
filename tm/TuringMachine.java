package tm;

import java.util.HashMap;
import java.util.Map;

public class TuringMachine {

    private final Map<Integer, State> states;
    private int numStates; // needed to look up the highest(halting) state

    public TuringMachine() {
        states = new HashMap<>();
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

    public static void run() {

    }
}
