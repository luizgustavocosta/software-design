package tech.costa.luiz.cards;

import java.util.ArrayList;

/**
 * The type Hand.
 *
 * @param <T> the type parameter
 */
public class Hand<T extends Card> {

    private ArrayList<T> cards = new ArrayList<>();

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
}
