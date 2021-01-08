import data.SimulateGame;

import java.io.File;

/**
 * Entry point to the simulation
 */
public final class Main {

    private Main() { }

    /**
     * Main function which reads the input file and starts simulation
     *
     * @param args input and output files
     * @throws Exception might error when reading/writing/opening files, parsing JSON
     */
    public static void main(final String[] args) throws Exception {
       File in = new File(args[0]);
      //  File in = new File("complex_1.json");
       File out = new File(args[1]);
      //  File out = new File("rezultat.json");
        SimulateGame game = new SimulateGame();
        game.simulate(in,out);


    }
}
