import data.SimulateGame;

import java.io.File;

public final class Main {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(final String[] args) throws Exception {
//         File in = new File(args[0]);
       File in = new File("complex_2.json");
//         File out = new File(args[1]);
        File out = new File("rezultat.json");
        SimulateGame game = new SimulateGame();
        game.simulate(in, out);
    }
}
