import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DeckOfCards extends Main {
    private LinkedList<Card> deck;

    public DeckOfCards() {
        deck = new LinkedList<>();
        createDeck();
        shuffle();
    }

    private void createDeck() {
        for (Suit suit : Suit.values()) {
            for (int value = 1; value <= 13; value++) {
                deck.add(new Card(suit, value));
            }
        }
    }

    private void shuffle() {
        Collections.shuffle(deck);
    }

    public Card drawCard() {
        return deck.poll();
    }

    public List<Card> drawHand(int handSize) {
        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < handSize; i++) {
            hand.add(deck.poll());
        }
        return hand;
    }

    public int getRemainingCards() {
        return deck.size();
    }

    public void printDeck() {
        for (Card card : deck) {
            System.out.println(card.toString());
        }
    }
    public void sortDeckBySuitAndValue() {
        Collections.sort(deck, new SuitComparator());
    }

    public void sortDeckByNumericalValue() {
        Collections.sort(deck, new NumericalValueComparator());
    }

}
