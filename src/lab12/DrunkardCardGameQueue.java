package lab12;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class DrunkardCardGameQueue {

    public static void main(String[] args) {
        Queue<Integer> deck = createDeck();
        Collections.shuffle((LinkedList<Integer>) deck);

        Queue<Integer> player1Deck = new LinkedList<>();
        Queue<Integer> player2Deck = new LinkedList<>();

        splitDeck(deck, player1Deck, player2Deck);

        while (!player1Deck.isEmpty() && !player2Deck.isEmpty()) {
            int card1 = player1Deck.poll();
            int card2 = player2Deck.poll();

            System.out.println("Player 1 plays: " + card1);
            System.out.println("Player 2 plays: " + card2);

            if ((card1 == 0 && card2 == 9) || (card1 > card2 && !(card1 == 9 && card2 == 0))) {
                player1Deck.offer(card1);
                player1Deck.offer(card2);
                System.out.println("Player 1 wins this round!");
            } else {
                player2Deck.offer(card1);
                player2Deck.offer(card2);
                System.out.println("Player 2 wins this round!");
            }

            System.out.println("Player 1 deck: " + player1Deck);
            System.out.println("Player 2 deck: " + player2Deck);
            System.out.println();
        }

        if (player1Deck.isEmpty()) {
            System.out.println("Player 1 has no cards left. Player 2 wins!");
        } else {
            System.out.println("Player 2 has no cards left. Player 1 wins!");
        }
    }

    private static Queue<Integer> createDeck() {
        Queue<Integer> deck = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            deck.offer(i);
        }
        return deck;
    }

    private static void splitDeck(Queue<Integer> deck, Queue<Integer> player1Deck, Queue<Integer> player2Deck) {
        int half = deck.size() / 2;
        for (int i = 0; i < half; i++) {
            player1Deck.offer(deck.poll());
            player2Deck.offer(deck.poll());
        }
    }
}

