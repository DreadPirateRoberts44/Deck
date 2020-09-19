/**
 * Interface defining the methods used by Deck objects. I am defining deck to
 * mean group of cards, not just the actual deck, so player's hands would count
 * as decks.
 *
 * @author Michael Yamokoski
 *
 */

public interface DeckInterface extends DeckKernelInterface {

    /**
     * Give the assigned number of cards to each player
     */
    void deal(Deck[] players, int numCards);

}
