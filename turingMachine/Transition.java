package turingMachine;

public class Transition {

    private int read;
    private int write;
    private int direction;
    private int nextState;


    /**
     * Constructor for a turingMachine.Transition object
     * @param read the character to read from the tape
     * @param write the character to write to the tape
     * @param direction the direction to move the tape
     */
    public Transition( int read, int write, char direction, int nextState){
        this.read = read;
        this.write = write;
        this.direction = direction;
        this.nextState = nextState;
    }

    /**
     * Method to get the next state
     * @return the next state
     */
    public int getNextState() {
        return nextState;
    }

    /**
     * Method to get the character to read from the tape
     * @return the character to read from the tape
     */
    public int getRead(){
        return read;
    }

    /**
     * Method to get the character to write to the tape
     * @return the character to write to the tape
     */
    public int getWrite(){
        return write;
    }

    /**
     * Method to get the direction to move the tape
     * @return the direction to move the tape
     */
    public int getDirection(){
        return direction;
    }


    /**
     * Method to set the character to read from the tape
     * @param read the character to read
     * from the tape
     */
    public void setRead(int read){
        this.read = read;
    }

    /**
     * Returns a string representation of this transition.
     *
     * @return A string listing all the elements of this transition.
     */
    public String toString() {
        return "read: " + read +  ", write: " + write + ", direction: " + direction + ", next state: " + nextState;
    }

}
