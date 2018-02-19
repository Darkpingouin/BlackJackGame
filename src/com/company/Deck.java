package com.company;
import java.util.Arrays;
import java.util.Random;

/**
 * Class representing a Deck of cards
 *
 * @author Oreo
 */
public class Deck {

    /** Cards contained in the deck. */
    private Card[] cards;

    /**
     * Constructor of the deck
     * Create a new deck of 52 cards
     */
    Deck() {
        int index = 0;
        cards = new Card[Suit.values().length * Value.values().length];
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                cards[index++] = new Card(value, suit);
            }
        }
    }

    /**
     * Method printing all the cards in the deck in order
     */
    public void Print()
    {
        for (Card card : cards)
        {
            card.print();
        }
    }

    /**
     * Method to shuffle the cards in the deck
     */
    public void Shuffle() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < cards.length; j++) {
                int x = r.nextInt(cards.length);
                int y = r.nextInt(cards.length);
                Card temp;
                temp = cards[x];
                cards[x] = cards[y];
                cards[y] = temp;
            }
        }

    }

    /**
     * Method to get the size of the deck
     * @return size of the deck
     */
    public int getSize()
    {
        return cards.length;
    }

    /**
     * Method to draw a card from the deck
     * @return first card of the deck
     */
    public Card Draw()
    {
        if (cards.length <= 0)
            return null;
        Card card = cards[0];
        cards = Arrays.copyOfRange(cards, 1, cards.length);
        return card;
    }
}

