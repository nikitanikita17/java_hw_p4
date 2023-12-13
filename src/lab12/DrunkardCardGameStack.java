package lab12;

import java.util.Collections;
import java.util.Stack;

public class DrunkardCardGameStack{

    public static void main(String[] args) {
        Stack<Integer> deck = createDeck();
        Collections.shuffle(deck);

        Stack<Integer> player1Deck = new Stack<>();
        Stack<Integer> player2Deck = new Stack<>();

        splitDeck(deck, player1Deck, player2Deck);

        while (!player1Deck.isEmpty() && !player2Deck.isEmpty()) {
            int card1 = player1Deck.pop();
            int card2 = player2Deck.pop();

            System.out.println("Player 1 plays: " + card1);
            System.out.println("Player 2 plays: " + card2);

            if ((card1 == 0 && card2 == 9) || (card1 > card2 && !(card1 == 9 && card2 == 0))) {
                player1Deck.add(0, card1);
                player1Deck.add(0, card2);
                System.out.println("Player 1 wins this round!");
            } else {
                player2Deck.add(0, card1);
                player2Deck.add(0, card2);
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

    private static Stack<Integer> createDeck() {
        Stack<Integer> deck = new Stack<>();
        for (int i = 0; i < 10; i++) {
            deck.push(i);
        }
        return deck;
    }

    private static void splitDeck(Stack<Integer> deck, Stack<Integer> player1Deck, Stack<Integer> player2Deck) {
        while (!deck.isEmpty()) {
            player1Deck.push(deck.pop());
            player2Deck.push(deck.pop());
        }
    }
}
