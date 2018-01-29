package com.company;

import java.util.Arrays;

/**
 * Player is a class representing the several player types present in the BlackJack Game
 *
 * @author Oreo
 */
public abstract class Player {


    /** Cards he has in hand. */
    protected Card[] hand;


    /**
     * Method to get the cards the player has in hand
     * @return an array of Card
     */
    public Card[] getHand() {
        return hand;
    }


    /**
     * Method to print the player's hand
     */
    public abstract void printHand();

    /**
     * Methid to add a Card to the player's hand
     * @param card card to add to the hand
     */
    public abstract void drawCard(Card card);


    /***
     * Method to (re) set player's hand on new turn
     * @param cardOne first card to add to hand
     * @param cardTwo second card to add to hand
     */
    public void setHand(Card cardOne, Card cardTwo)
    {
        this.hand = new Card[2];
        this.hand[0] = cardOne;
        this.hand[1] = cardTwo;
    }

    /**
     * Method to calculate the value of the hand of the player
     * @return value of the hand
     */
    public int getHandValue() {
        int handValue = 0;
        int aceNumber = 0;
        for (Card card : this.hand) {
            if (card.getValue() == Value.Ace) {
                handValue += 11;
                aceNumber++;
            } else if (card.getValue().ordinal() >= Value.Two.ordinal() && card.getValue().ordinal() <= Value.Ten.ordinal()) {
                handValue += card.getValue().ordinal() + 1;
            } else {
                handValue += 10;
            }
        }
        while (aceNumber > 0 && handValue > 21) {
            aceNumber--;
            handValue -= 10;
        }
        return handValue;
    }

}
