package tech.costa.luiz.cards;

/**
 * The type Black jack card.
 */
public class BlackJackCard extends Card {

    /**
     * Instantiates a new Card.
     *
     * @param faceValue the face value
     * @param suit      the suit
     */
    public BlackJackCard(int faceValue, Suit suit) {
        super(faceValue, suit);
    }

    @Override
    public int value() {
        if (isAce()) return 1;
        else if (faceValue >= 11 && faceValue <= 13) return 10;
        else return faceValue;
    }

    /**
     * Min value int.
     *
     * @return the int
     */
    public int minValue() {
        if (isAce()) return 1;
        else return value();
    }

    /**
     * Max value int.
     *
     * @return the int
     */
    public int maxValue() {
        if (isAce()) return 11;
        else return value();
    }

    /**
     * Is face card boolean.
     *
     * @return the boolean
     */
    public boolean isFaceCard() {
        return faceValue >= 11 && faceValue <= 13;
    }

    private boolean isAce() {
        return faceValue == 1;
    }
}
