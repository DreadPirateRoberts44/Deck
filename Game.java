import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Game {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Game() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static void myMethod() {
        /*
         * Put your code for myMethod here
         */
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Put your main program code here; it may call myMethod as shown
         */
        Deck d = new Deck();
        d.shuffle();
        out.println(d.drawPileSize());
        Deck[] players = new Deck[4];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Deck(0);
        }
        d.deal(players, 5);
        for (int i = 0; i < players.length; i++) {
            out.println(players[i].toString());
        }
        out.println(d.drawPileSize());

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
