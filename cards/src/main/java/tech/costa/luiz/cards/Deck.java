package tech.costa.luiz.cards;

import java.util.ArrayList;
import java.util.Objects;

/**
 * The type Deck.
 *
 * @param <T> the type parameter
 */
public class Deck <T extends Card> {

    private ArrayList<T> cards;
    private int deltaIndex;

    /**
     * Sets deck of cards.
     *
     * @param cards the cards
     */
    public void setDeckOfCards(ArrayList<T> cards) {
        this.cards = cards;
    }

    /**
     * Shuffle.
     */
    public void shuffle() {
        throw new UnsupportedOperationException();
    }

    /**
     * Remaining cards int.
     *
     * @return the int
     */
    public int remainingCards() {
        return Objects.requireNonNull(cards).size() - deltaIndex;
    }

    /**
     * Delta hand t [ ].
     *
     * @param number the number
     * @return the t [ ]
     */
    public T[] deltaHand(int number) {
        throw new UnsupportedOperationException();
    }

    /**
     * Deal card t.
     *
     * @return the t
     */
    public T dealCard() {
        throw new UnsupportedOperationException();
    }
}
