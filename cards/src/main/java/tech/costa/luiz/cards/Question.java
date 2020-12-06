package tech.costa.luiz.cards;

import tech.costa.luiz.cards.blackjack.BlackJackGameAutomator;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Question.
 */
public class Question {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int numberOfPlayers = 5;
        int faceValues = 13; //A.4,5,.K

        BlackJackGameAutomator automator = new BlackJackGameAutomator(numberOfPlayers, faceValues);
        automator.initializeDeck();
        boolean success = automator.dealInitial();
        if (!success) {
            System.out.println("Error. Out of cards.");
        } else {
            System.out.println("-- Initial --");
            automator.printHandsAndScore();
            List<Integer> blackjacks = automator.getBlackJacks();
            if (blackjacks.size() > 0) {
                System.out.println("Blackjack at "+blackjacks.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(",")));

            } else {
                success = automator.playAllHands();
                if (!success) {
                    System.out.println("Error. Out of cards.");
                } else {
                    System.out.println("\n-- Completed Game --");
                    automator.printHandsAndScore();
                    List<Integer> winners = automator.getWinners();
                    if (!winners.isEmpty()) {
                        System.out.println("Winners: "+winners.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining(",")));
                    } else {
                        System.out.println("Draw. All players have busted.");
                    }
                }
            }
        }
    }

}
