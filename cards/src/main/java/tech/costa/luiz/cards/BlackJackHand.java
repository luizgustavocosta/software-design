package tech.costa.luiz.cards;

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
        return null;
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
        throw new UnsupportedOperationException();
    }
}
