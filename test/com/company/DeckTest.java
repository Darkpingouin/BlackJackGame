package com.company;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class to test all the methods from the Deck class
 */
class DeckTest {

    /**
     * Method to test the print() method
     */
    @Test
    void print() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Deck deck = new Deck();
        deck.Print();
        String expectedOutput = "Ace of Spade" +
                "2 of Spade" +
                "3 of Spade" +
                "4 of Spade" +
                "5 of Spade" +
                "6 of Spade" +
                "7 of Spade" +
                "8 of Spade" +
                "9 of Spade" +
                "10 of Spade" +
                "Jack of Spade" +
                "Queen of Spade" +
                "King of Spade" +
                "Ace of Heart" +
                "2 of Heart" +
                "3 of Heart" +
                "4 of Heart" +
                "5 of Heart" +
                "6 of Heart" +
                "7 of Heart" +
                "8 of Heart" +
                "9 of Heart" +
                "10 of Heart" +
                "Jack of Heart" +
                "Queen of Heart" +
                "King of Heart" +
                "Ace of Club" +
                "2 of Club" +
                "3 of Club" +
                "4 of Club" +
                "5 of Club" +
                "6 of Club" +
                "7 of Club" +
                "8 of Club" +
                "9 of Club" +
                "10 of Club" +
                "Jack of Club" +
                "Queen of Club" +
                "King of Club" +
                "Ace of Diamond" +
                "2 of Diamond" +
                "3 of Diamond" +
                "4 of Diamond" +
                "5 of Diamond" +
                "6 of Diamond" +
                "7 of Diamond" +
                "8 of Diamond" +
                "9 of Diamond" +
                "10 of Diamond" +
                "Jack of Diamond" +
                "Queen of Diamond" +
                "King of Diamond";
        assertEquals(expectedOutput, outContent.toString().replaceAll("\n", "").replaceAll("\r", ""));

    }


    /**
     * Method to test the getSize() method
     */
    @Test
    void getSize() {
        Deck deck = new Deck();
        assertEquals(52, deck.getSize());
        for (int i = 0; i < 10; i++)
            deck.Draw();
        assertEquals(42, deck.getSize());
    }

    /**
     * Method to test the draw() method
     */
    @Test
    void draw() {
        Deck deck = new Deck();
        Card expectedCard = new Card(Value.Ace, Suit.Spade);
        Card actualCArd = deck.Draw();
        assertEquals(expectedCard.getSuit(), actualCArd.getSuit());
        assertEquals(expectedCard.getValue(), actualCArd.getValue());
    }
}