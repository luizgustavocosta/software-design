package tech.costa.luiz.cards;

/**
 * The enum Suit.
 */
public enum Suit {

    /**
     * Club suit.
     */
    CLUB(0),
    /**
     * Diamond suit.
     */
    DIAMOND(1),
    /**
     * Heart suit.
     */
    HEART(2),
    /**
     * Spade suit.
     */
    SPADE(3);

    private int value;

    Suit(int value) {
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * Gets suit from value.
     *
     * @param value the value
     * @return the suit from value
     */
    public static Suit getSuitFromValue(int value) {
        return Suit.values()[value];
    }
}
