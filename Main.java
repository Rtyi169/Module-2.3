import java.util.*;

enum Suit {
    SPADES,
    HEARTS,
    CLUBS,
    DIAMONDS
}

class Card {
    private Suit suit;
    private int value;

    public Card(Suit suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        String cardValue;
        switch (value) {
            case 1:
                cardValue = "Ace";
                break;
            case 11:
                cardValue = "Jack";
                break;
            case 12:
                cardValue = "Queen";
                break;
            case 13:
                cardValue = "King";
                break;
            default:
                cardValue = String.valueOf(value);
        }
        return cardValue + " of " + suit.toString();
    }
}

class SuitComparator implements Comparator<Card> {
    private List<Suit> suitOrder;

    public SuitComparator() {
        suitOrder = Arrays.asList(Suit.SPADES, Suit.HEARTS, Suit.CLUBS, Suit.DIAMONDS);
    }

    @Override
    public int compare(Card card1, Card card2) {
        int suitIndex1 = suitOrder.indexOf(card1.getSuit());
        int suitIndex2 = suitOrder.indexOf(card2.getSuit());

        if (suitIndex1 != suitIndex2) {
            return suitIndex1 - suitIndex2;
        } else {
            return card1.getValue() - card2.getValue();
        }
    }
}

class NumericalValueComparator implements Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2) {
        int suitComparison = card1.getSuit().compareTo(card2.getSuit());
        if (suitComparison != 0) {
            return suitComparison;
        } else {
            return card1.getValue() - card2.getValue();
        }
    }

    
    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();

        System.out.println("Original Deck:");
        deck.printDeck();

        System.out.println("\nDeck sorted by Suit and Numerical Value:");
        deck.sortDeckBySuitAndValue();
        deck.printDeck();

        System.out.println("\nDeck sorted by suits");
    }
}