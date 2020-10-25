package tech.costa.luiz.cards;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Hand.
 *
 * @param <T> the type parameter
 */
public class Hand<T extends Card> {

    /**
     * The Cards.
     */
    protected List<T> cards = new ArrayList<>();

    /**
     * Score int.
     *
     * @return the int
     */
    public int score() {
        int score = 0;
        for (T card : cards) {
            score += card.value();
        }
        return score;
    }

    /**
     * Add card.
     *
     * @param card the card
     */
    public void addCard(T card) {
        cards.add(card);
    }

    /**
     * Print.
     */
    public void print() {
        for (T card : cards) {
            System.out.println(card);
        }
    }
}
