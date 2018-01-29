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
    public Deck() {
        int index = 0;
        this.cards = new Card[Suit.values().length * Value.values().length];
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                this.cards[index++] = new Card(value, suit);
            }
        }
    }

    /**
     * Method printing all the cards in the deck in order
     */
    public void Print()
    {
        for (Card card : this.cards)
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
            for (int j = 0; j < this.cards.length; j++) {
                int x = r.nextInt(this.cards.length);
                int y = r.nextInt(this.cards.length);
                Card temp;
                temp = this.cards[x];
                this.cards[x] = this.cards[y];
                this.cards[y] = temp;
            }
        }

    }

    /**
     * Method to get the size of the deck
     * @return size of the deck
     */
    public int getSize()
    {
        return this.cards.length;
    }

    /**
     * Method to draw a card from the deck
     * @return first card of the deck
     */
    public Card Draw()
    {
        if (this.cards.length <= 0)
            return null;
        Card card = this.cards[0];
        this.cards = Arrays.copyOfRange(this.cards, 1, this.cards.length);
        return card;
    }
}

