
/**
 * Interface defining the kernel methods used by Deck objects. I am defining
 * deck to mean group of cards, not just the actual deck, so player's hands
 * would count as decks.
 *
 * @author Michael Yamokoski
 *
 */

public interface DeckKernelInterface {

    /**
     * Shuffles the deck, including cards from the discard.
     *
     * @ensures the new value of this is a permutation of the original value of
     *          this perms(this.draw, #this.draw * #this.discard)
     */
    void shuffle();

    /**
     * Removes and returns the top Card object from this.
     *
     */
    Card draw();

    /**
     * Check how many cards are in draw pile
     */
    int drawPileSize();

    /**
     * Player chooses a card to play from their hand, removes and returns it
     */
    Card play(Card c);//hand

    /**
     * Adds a non random card to your hand
     */
    void add(Card c);//hand

    /**
     * Add a card to the discard
     */
    void discard(Card c);

    boolean hasCard(Card c);//hand

    /**
     * Adds all cards to this.discard
     */
    //void discard(Deck d);
}
