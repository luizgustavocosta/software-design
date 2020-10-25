package tech.costa.luiz.cards.blackjack;

import tech.costa.luiz.cards.Card;
import tech.costa.luiz.cards.Suit;

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

    /**
     * Is ace boolean.
     *
     * @return the boolean
     */
    public boolean isAce() {
        return faceValue == 1;
    }

    @Override
    public String toString() {
        return "BlackJackCard{" +
                "faceValue=" + faceValue +
                ", suit=" + suit +
                '}';
    }
}
