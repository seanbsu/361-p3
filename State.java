import java.util.ArrayList;

/**
 * A State object for a turing machine with a name, aka the label for the machine in the context of this project is the state number.
 * A State contains its name, a list of its transitions and a boolean to indicate if it's a final state (halt state)
 */
public class State {
    private int name;
    private boolean accept;
    private  ArrayList<Transition> transitions;

    /**
     * Constructor for a State object
     * @param name the name of the state. all states will be integer values
     */
    public State(int name){
        this.name = name;
    }

    /**
     *  Add a transition to the list of transitions for this state
     * @param t the transition to add
     */
    public void addTransition(Transition t){
        transitions.add(t);
    }

    /**
     * Method to get the state's transition list
     * @return the list of transitions for this state
     */
    public ArrayList<Transition> getTransitions(){
        return transitions;
    }

    /**
     * Method to set the states transition list from a predefined list of transitions
     * @param transitions the list of transitions to set
     */
    public void setTransitions(ArrayList<Transition> transitions){
        this.transitions = transitions;
    }

    /**
     * Method to set whether this state is the accept state or not
     * @param accept true if this state is the accept state, false otherwise
     */
    public void setAccept(boolean accept){
        this.accept = accept;
    }

    /**
     * Method to check if this state is an accept state or not
     * @return true if this state is an accept state, false otherwise
     */
    public boolean isAccept(){
        return accept;
    }

    /**
     * Method to get the name of this state
     * @return the name of this state
     */
    @Override
    public String toString(){
        return ""+ name;
    }



}
