package tm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A turingMachine.State object for a turing machine with a name, aka the label for the machine in the context of this project is the state number.
 * A turingMachine.State contains its name, a list of its transitions and a boolean to indicate if it's a final state (halt state)
 */
public class State {
    private final int name; // state label
    private final Map<Integer, Transition> transitions;

    /**
     * Constructor for a turingMachine.State object
     *
     * @param name the name of the state. all states will be integer values
     */
    public State(int name) {
        this.name = name;
        transitions = new HashMap<>();
    }

    /**
     * Add a transition to the list of transitions for this state
     *
     * @param t the transition to add
     */
    public void addTransition(Transition t) {
        transitions.put(t.getRead(), t);
    }

    /**
     * Method to get the state's transition list
     *
     * @return the list of transitions for this state
     */
    public List<Transition> getTransitions() {
        return transitions.values().stream().collect(Collectors.toList());
    }

    /**
     * Method to set the states transition list from a predefined list of transitions
     *
     * @param transitions the list of transitions to set
     */
    public void setTransitions(List<Transition> transitions) {
        this.transitions.clear();
        transitions.forEach(this::addTransition);
    }

    /**
     * Method to get the name of this state as a string
     *
     * @return the name of this state as a string
     */
    @Override
    public String toString() {
        return "" + name;
    }


    /**
     * Method to get the name of this state as an int
     *
     * @return the name of this state
     */
    public int getName() {
        return name;
    }

    /**
     * Gets the transition with a given read symbol
     *
     * @param symbol read symbol
     * @return transition with read symbol, null if not present
     */
    public Transition getTransition(int symbol) {
        return transitions.get(symbol);
    }
}
