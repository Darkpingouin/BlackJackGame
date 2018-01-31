package com.company;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    /**
     * Method to test the getSuit() method
     */
    @Test
    void getSuit() {
        Card card = new Card(Value.Ace, Suit.Club);
        assertEquals(Suit.Club, card.getSuit());
    }

    /**
     * Method to test the getValue() method
     */
    @Test
    void getValue() {
        Card card = new Card(Value.Ace, Suit.Club);
        assertEquals(Value.Ace, card.getValue());
    }


    /**
     * Method to test the print() method
     */
    @Test
    void print() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Card card = new Card(Value.Ace, Suit.Club);
        card.print();
        String expectedOutput = "Ace of Club";
        assertEquals(expectedOutput, outContent.toString().replaceAll("\n", "").replaceAll("\r", ""));


        ByteArrayOutputStream outContentTwo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentTwo));
        Card cardTwo = new Card(Value.Two, Suit.Diamond);
        cardTwo.print();
        expectedOutput = "2 of Diamond";
        assertEquals(expectedOutput, outContentTwo.toString().replaceAll("\n", "").replaceAll("\r", ""));
    }
}