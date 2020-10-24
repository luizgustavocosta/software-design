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
     * Sets available.
     *
     * @param available the available
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }
}
