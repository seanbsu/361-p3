package tm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TMSimulator {

    public static String simulate(String filename){
        TuringMachine tm = new TuringMachine();
        int numStates;
        int numSymbols;
        String input;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // read first 2 lines
            numStates = Integer.parseInt(reader.readLine());
            numSymbols = Integer.parseInt(reader.readLine());

            // create states
            State[] states = new State[numStates];
            for (int i = 0; i < numStates; i++) {
                states[i] = new State(i);
                tm.addState(states[i]);
            }

            // add transitions
            for (int i = 0; i < numStates - 1; i++) {
                for (int j = 0; j <= numSymbols; j++) {
                    String[] splitLine = reader.readLine().split(",");
                    states[i].addTransition(new Transition(
                            j, // read symbol
                            Integer.parseInt(splitLine[1]), // write symbol
                            splitLine[2].charAt(0), // direction
                            states[Integer.parseInt(splitLine[0])] // next State
                    ));
                }
            }
            input = reader.readLine();
            if (input == null) input = "";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        tm.run(input);
        return tm.getTape().toString();
    }

    public static void main(String[] args) {
        System.out.println(simulate(args[0]));
        // System.out.println(simulate("file0.txt"));
    }
}
