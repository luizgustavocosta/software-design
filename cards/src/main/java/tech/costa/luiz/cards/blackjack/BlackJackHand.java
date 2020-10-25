package tech.costa.luiz.cards.blackjack;

import tech.costa.luiz.cards.Hand;

import java.util.ArrayList;

/**
 * The type Black jack hand.
 */
public class BlackJackHand extends Hand<BlackJackCard> {

    @Override
    public int score() {
        ArrayList<Integer> scores = possibleScores();
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;
        assert scores != null;
        for (Integer score : scores) {
            if (score > 21 && score < minOver) {
                minOver = score;
            } else if (score <=21 && score > maxUnder) {
                maxUnder = score;
            }
        }
        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    }

    private ArrayList<Integer> possibleScores() {
        ArrayList<Integer> scores = new ArrayList<>();
        if (cards.size() == 0) {
            return scores;
        }
        for (BlackJackCard card : cards) {
            addCardToScoreList(card, scores);
        }
        return scores;
    }

    private void addCardToScoreList(BlackJackCard card, ArrayList<Integer> scores) {
        if (scores.size() == 0) {
            scores.add(0);
        }
        int length = scores.size();
        for (int i = 0; i < length; i++) {
            int score = scores.get(i);
            scores.set(i, score + card.minValue());
            if (card.minValue() != card.maxValue()) {
                scores.add(score + card.maxValue());
            }
        }
    }

    /**
     * Busted boolean.
     *
     * @return the boolean
     */
    public boolean busted(){return score() > 21;}

    /**
     * Is 21 boolean.
     *
     * @return the boolean
     */
    public boolean is21(){return score() == 21;}

    /**
     * Is black jack boolean.
     *
     * @return the boolean
     */
    public boolean isBlackJack(){
        if (cards.size() != 2) { // Need to flip 3 cards
            return false;
        }
        BlackJackCard first = cards.get(0);
        BlackJackCard second = cards.get(1);
        return (first.isAce() && second.isFaceCard()) || (second.isAce() && first.isFaceCard());
    }
}
