package tech.costa.luiz.cards.blackjack;

import tech.costa.luiz.cards.Deck;
import tech.costa.luiz.cards.Suit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Objects.isNull;

/**
 * The type Black jack game automator.
 */
public class BlackJackGameAutomator {
    private Deck<BlackJackCard> deck;
    private final BlackJackHand[] hands;
    private final int faceValues;
    private static final int HIT_UNTIL = 16;

    /**
     * Instantiates a new Black jack game automator.
     *
     * @param numberOfPlayers the num players
     */
    public BlackJackGameAutomator(int numberOfPlayers, int faceValues) {
        hands = new BlackJackHand[numberOfPlayers];
        this.faceValues = faceValues;
        IntStream.range(0, numberOfPlayers)
                .forEach(index -> hands[index] = new BlackJackHand());
    }

    /**
     * Deal initial boolean.
     *
     * @return the boolean
     */
    public boolean dealInitial() {
        for (BlackJackHand hand : hands) {
            BlackJackCard card = deck.dealCard();
            BlackJackCard otherCard = deck.dealCard();
            if (isNull(card) || isNull(otherCard)) {
                return false;
            }
            hand.addCard(card);
            hand.addCard(otherCard);
        }
        return true;
    }

    /**
     * Gets black jacks.
     *
     * @return the black jacks
     */
    public List<Integer> getBlackJacks() {
        List<Integer> winners = new ArrayList<>();
        for (int index = 0; index < hands.length; index++) {
            if (hands[index].isBlackJack()) {
                winners.add(index);
            }
        }
        return winners;
    }

    /**
     * Play hand boolean.
     *
     * @param i the
     * @return the boolean
     */
    public boolean playHand(int i) {
        BlackJackHand hand = hands[i];
        return playHand(hand);
    }

    /**
     * Play hand boolean.
     *
     * @param hand the hand
     * @return the boolean
     */
    public boolean playHand(BlackJackHand hand) {
        while (hand.score() < HIT_UNTIL) {
            BlackJackCard card = deck.dealCard();
            if (isNull(card)) {
                return false;
            }
            hand.addCard(card);
        }
        return true;
    }

    /**
     * Play all hands boolean.
     *
     * @return the boolean
     */
    public boolean playAllHands() {
        for (BlackJackHand hand : hands) {
            if (!playHand(hand)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Gets winners.
     *
     * @return the winners
     */
    public List<Integer> getWinners() {
        List<Integer> winners = new ArrayList<>();
        int winningScore = 0;
        for (int index = 0; index < hands.length; index++) {
            BlackJackHand hand = hands[index];
            if (!hand.busted()) {
                if (hand.score() > winningScore) {
                    winningScore = hand.score();
                    winners.clear();
                    winners.add(index);
                } else if (hand.score() == winningScore) {
                    winners.add(index);
                }
            }
        }
        return winners;
    }

    /**
     * Initialize deck.
     */
    public void initializeDeck() {
        List<BlackJackCard> cards = new ArrayList<>();
        for (int index = 1; index <= faceValues; index++) {
            for (int otherIndex = 0; otherIndex <= Suit.values().length - 1; otherIndex++) {
                Suit suit = Suit.getSuitFromValue(otherIndex);
                BlackJackCard card = new BlackJackCard(index, suit);
                cards.add(card);
            }
        }
        deck = new Deck<>();
        deck.setDeckOfCards(cards);
        deck.shuffle();
    }

    /**
     * Print hands and score.
     */
    public void printHandsAndScore() {
        for (int index = 0; index < hands.length; index++) {
            System.out.print("Hand " + index + " (" + hands[index].score() + "): \n");
            hands[index].print();
            System.out.println("");
        }
    }
}