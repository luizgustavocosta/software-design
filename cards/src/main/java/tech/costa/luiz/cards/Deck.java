package tech.costa.luiz.cards;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Deck.
 *
 * @param <T> the type parameter
 */
public class Deck<T extends Card> {

    private List<T> cards;
    private int deltaIndex;

    /**
     * Sets deck of cards.
     *
     * @param cards the cards
     */
    public void setDeckOfCards(List<T> cards) {
        this.cards = cards;
    }

    /**
     * Shuffle.
     */
    public void shuffle() {
        for (int index = 0; index < cards.size(); index++) {
            int origin = index;
            int bound = cards.size() - index - 1;
            if (bound < origin) bound=origin+1;
            int changePosition = ThreadLocalRandom.current().nextInt(origin, bound);
            T card = cards.get(index);
            T otherCard = cards.get(changePosition);
            cards.set(index, otherCard);
            cards.set(changePosition, card);
        }
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
        if (remainingCards() < number) {
            return null;
        }

        T[] hand = (T[]) new Card[number];
        int count = 0;
        while (count < number) {
            T card = dealCard();
            if (card != null) {
                hand[count] = card;
                count++;
            }
        }
        return hand;
    }

    /**
     * Deal card t.
     *
     * @return the t
     */
    public T dealCard() {
        if (remainingCards() == 0) {
            return null;
        }
        T card = cards.get(deltaIndex);
        card.markUnavailable();
        deltaIndex++;
        return card;
    }

    /**
     * Print.
     */
    public void print() {
        for (Card card : cards) {
            card.print();
        }
    }
}
