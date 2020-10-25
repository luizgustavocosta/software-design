package tech.costa.luiz.cards;

/**
 * The type Card.
 */
public abstract class Card {

    // Used for game where the card used is discarded
    private boolean available = true;

    /**
     * The Face value.
     */
    protected int faceValue;
    /**
     * The Suit.
     */
    protected Suit suit;

    /**
     * Instantiates a new Card.
     *
     * @param faceValue the face value
     * @param suit      the suit
     */
    public Card(int faceValue, Suit suit) {
        this.faceValue = faceValue;
        this.suit = suit;
    }

    /**
     * Value int.
     * Each play has the own cards to play
     *
     * @return the int
     */
    public abstract int value();

    /**
     * Gets suit.
     *
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Is available boolean.
     *
     * @return the boolean
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Mark available.
     */
    public void markAvailable() {
        available = true;
    }

    /**
     * Mark unavailable.
     */
    public void markUnavailable() {
        available = false;
    }

    /**
     * Print.
     */
    public void print() {
        String[] faceValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        System.out.print(faceValues[faceValue - 1]);
        switch (suit) {
            case CLUB:
                System.out.print("c");
                break;
            case HEART:
                System.out.print("h");
                break;
            case DIAMOND:
                System.out.print("d");
                break;
            case SPADE:
                System.out.print("s");
                break;
        }
        System.out.print(" ");
    }
}
