/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Card {

    private String suit;
    private int number;

    public Card(int val, String suit) {
        this.suit = suit;
        this.number = val;

    }

    @Override
    public String toString() {
        String numberName;

        if (this.number >= 2 && this.number <= 10) {
            numberName = Integer.toString(this.number);
        } else if (this.number == 11) {
            numberName = "Jack";
        } else if (this.number == 12) {
            numberName = "Queen";
        } else if (this.number == 13) {
            numberName = "King";
        } else {
            numberName = "Ace";
        }

        String name = numberName + " of " + this.suit;

        return name;
    }

}
