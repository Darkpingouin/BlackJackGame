package com.company;

/**
 * Enum representing the four suits of a deck of cards
 */
enum Suit {
    Spade, Heart, Club, Diamond
}

/**
 * Enum representing the different values present in a deck of cards
 */
enum Value {
    Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
}

/**
 * Class representing a card
 */
public class Card {

    /** Suit of the card. */
    private Suit suit;

    /** Value of the card. */
    private Value value;

    /**
     * Constructor of a card
     * @param value value of the card
     * @param suit suit of the card
     */
    public Card(Value value, Suit suit)
    {
        this.value = value;
        this.suit = suit;
    }

    /**
     * Method to get the suit of the card
     * @return suit of the card
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Method to get the value of the card
     * @return value of the card
     */
    public Value getValue() {
        return value;
    }

    /**
     * Method to print the card's value and suit
     */
    public void print()
    {
        if (getValue().ordinal() >= 10 || getValue().ordinal() == 0)
            System.out.println(getValue() + " of " + getSuit());
        else
            System.out.println(getValue().ordinal() + 1 + " of " + getSuit());
    }

}
