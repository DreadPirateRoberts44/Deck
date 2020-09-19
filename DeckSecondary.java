/**
 *
 *
 *
 * @author Michael Yamokoski
 *
 */

public abstract class DeckSecondary implements DeckInterface {

    @Override
    public void deal(Deck[] players, int numCards) {
        if (this.drawPileSize() <= (players.length * numCards)) {
            this.shuffle();
        }

        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < numCards; j++) {
                players[i].add(this.draw());
            }
        }

    }

}
