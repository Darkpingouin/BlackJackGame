package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class containing Methods to test the Player class methods
 */
class PlayerTest {

    /**
     * Method to test the getHand() method
     */
    @Test
    void getHand() {
        realPlayer player = new realPlayer();
        Card one = new Card(Value.Two, Suit.Diamond);
        Card two = new Card(Value.Ace, Suit.Club);
        player.setHand(one, two);
        Card[] hand = player.getHand();
        assertEquals(hand[0].getValue(), one.getValue());
        assertEquals(hand[0].getSuit(), one.getSuit());
        assertEquals(hand[1].getValue(), two.getValue());
        assertEquals(hand[1].getSuit(), two.getSuit());
    }

    /**
     * Method to test the drawCard() method
     */
    @Test
    void drawCard() {
        realPlayer player = new realPlayer();
        Card one = new Card(Value.Two, Suit.Diamond);
        Card two = new Card(Value.Ace, Suit.Club);
        player.setHand(one, two);
        Card card = new Card(Value.King, Suit.Spade);
        player.drawCard(card);
        Card[] hand = player.getHand();
        assertEquals(hand[2].getValue(), card.getValue());
        assertEquals(hand[2].getSuit(), card.getSuit());
    }

    /**
     * Method to test the setHand() method
     */
    @Test
    void setHand() {
        realPlayer player = new realPlayer();
        Card one = new Card(Value.Two, Suit.Diamond);
        Card two = new Card(Value.Ace, Suit.Club);
        player.setHand(one, two);
        Card[] hand = player.getHand();
        assertEquals(hand[0].getValue(), one.getValue());
        assertEquals(hand[0].getSuit(), one.getSuit());
        assertEquals(hand[1].getValue(), two.getValue());
        assertEquals(hand[1].getSuit(), two.getSuit());
    }

    /**
     * Method to test the getHandValue() method
     */
    @Test
    void getHandValue() {
        realPlayer player = new realPlayer();
        Card one = new Card(Value.Two, Suit.Diamond);
        Card two = new Card(Value.Ace, Suit.Club);
        player.setHand(one, two);
        int expectedValue = 13;
        assertEquals(expectedValue, player.getHandValue());
    }
}