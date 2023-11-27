package turingMachine;

/**
 * turingMachine.Tape class to represent the  bi-infinite tape of a Turing Machine
 */
public class Tape {
   private  Node curr, first, last;

    /**
     * Constructor for an empty tape
     */
    public Tape(){
        curr = new Node(0);
        curr.left = curr.right = null;
        first = curr;
        last = curr;
    }

    /**
     * Constructor for a tape with initial input
     * @param input the initial input on the tape
     */
    public Tape(String input){
        this();
        for(int i = 0; i < input.length();i++ ){
            this.setValue(Character.getNumericValue(input.charAt(i)));
            this.moveRight();
        }
        curr = first;
    }

    /**
     * Move the tape to the right
     */
    public void moveRight(){
        if(curr.right == null){
            curr.right = new Node(0);
            curr.right.left = curr;
            last = curr.right;
        }
        curr = curr.right;
    }

    /**
     * Move the tape to the left
     */
    public void moveLeft(){
        if(curr.left == null){
            curr.left = new Node(0);
            curr.left.right = curr;
            first = curr.left;
        }
        curr = curr.left;
    }

    /**
     * Get the contents of the tape at the current position
     * @return the contents of the tape at the current position
     */
    public int getValue(){
        return curr.value;
    }

    /**
     * Set the value for the contents of the tape at the current position
     * @param value the value to set the current position on the tape to.
     */
    public void setValue(int value){
        curr.value = value;
    }

    /**
     * Get the contents of the tape at the current position
     */
    public void printTape(){
        Node temp = this.first;
        while(temp != null){
            System.out.print(temp.value + " ");
            temp = temp.right;
        }
    }

    /**
     * Class to represent one "cell" of the tape
     */
    private static class Node{
        private int value;
        private Node left;
        private Node right;
        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }

        private int getValue(){
            return value;
        }

        private Node getLeft(){
            return left;
        }
        private Node getRight(){
            return right;
        }
    }
    public static class NodeWrapper{
        private Node node;
       public NodeWrapper(int val){
            node = new Node(val);
        }
        public int getValue(){
            return node.getValue();
        }
        public Node getLeft(){
            return node.getLeft();
        }
        public Node getRight(){
            return node.getRight();
        }
    }
}