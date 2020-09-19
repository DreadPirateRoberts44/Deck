import java.util.Random;

import components.queue.Queue;
import components.queue.Queue1L;
import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * Kernel implementation of Deck
 *
 * @author Michael Yamokoski
 *
 */
public final class Deck extends DeckSecondary {

    /**
     * Helpers
     */

    /**
     * Finds {@code x} in {@code q} and, if such exists, moves it to the front
     * of {@code q}.
     *
     * @param <T>
     *            type of {@code Queue} entries
     * @param q
     *            the {@code Queue} to be searched
     * @param x
     *            the entry to be searched for
     * @updates q
     * @ensures <pre>
     * perms(q, #q)  and
     * if <x> is substring of q
     *  then <x> is prefix of q
     * </pre>
     */
    private static <T> void moveToFront(Queue<T> q, T x) {
        assert q != null : "Violation of: q is not null";

        int i = 0;
        while (i < q.length() && !q.front().equals(x)) {

            T y = q.dequeue();

            q.enqueue(y);

            i++;
        }

    }

    private String[] suits = { "Spades", "Clubs", "Hearts", "Diamonds" };

    private void createNewRep(int numDecks) {
        this.drawPile = new Queue1L<>();

        this.shuffler = new Sequence1L<>();

        this.discardPile = new Queue1L<>();

        this.hand = new Queue1L<>();

        //add one of each card times the number of decks
        for (int i = 0; i < numDecks; i++) {
            for (int j = 1; j <= 13; j++) {
                for (int k = 0; k < this.suits.length; k++) {
                    Card c = new Card(j, this.suits[k]);
                    this.drawPile.enqueue(c);
                }
            }
        }
    }

    /**
     * Constructors
     */

    /**
     * No arg constructor
     */
    public Deck() {
        this.createNewRep(1);
    }

    public Deck(int numDecks) {
        this.createNewRep(numDecks);
    }

    private Queue<Card> drawPile;

    private Queue<Card> discardPile;

    private Queue<Card> hand;//will probably be turned into it's own hand object

    private Sequence<Card> shuffler;

    @Override
    public Card draw() {
        Card c = this.drawPile.dequeue();
        return c;
    }

    @Override
    public void add(Card c) {
        this.drawPile.enqueue(c);
    }

    @Override
    public int drawPileSize() {
        return this.drawPile.length();
    }

    @Override
    public void discard(Card c) {
        this.discardPile.enqueue(c);
    }

    @Override
    public Card play(Card c) {
        moveToFront(this.discardPile, c);

        return this.drawPile.dequeue();
    }

    @Override
    public boolean hasCard(Card c) {
        moveToFront(this.drawPile, c);
        boolean hasCard = false;

        if (this.drawPile.front().equals(c)) {
            hasCard = true;
        }

        return hasCard;
    }

    @Override
    public void shuffle() {

        while (this.discardPile.length() > 0) {
            Card c = this.discardPile.dequeue();
            this.shuffler.add(this.shuffler.length(), c);
        }
        while (this.drawPile.length() > 0) {
            Card c = this.drawPile.dequeue();
            this.shuffler.add(this.shuffler.length(), c);
        }
        Random rnd = new Random();
        while (this.shuffler.length() > 0) {
            int x = rnd.nextInt(this.shuffler.length());
            Card c = this.shuffler.remove(x);
            this.drawPile.enqueue(c);
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (Card c : this.drawPile) {
            str += c.toString();
            str += ", ";
        }
        return str;
    }
}
