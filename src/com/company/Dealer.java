package com.company;


import java.util.Arrays;


/**
 * Class representing the Dealer in the BlackJack game
 *
 * @author Oreo
 */
public class Dealer extends Player {

    /**
     * Simple constructor for the dealer
     */
    public Dealer()
    {
    }


    /**
     * Method to print the dealer's hand showing only the first card clear
     */
    public void printHand() {
        System.out.println("Dealer Hand:");
        int i = 0;
        for (Card card : this.hand)
        {
            if (i == 0)
                card.print();
            else
                System.out.println("? of ?????");
            i++;
        }
        System.out.print("\n");
    }

    /**
     * Method to print the dealer's hand completely with it's value
     */
    public void revealHand() {
        System.out.println("Dealer has a total of " + this.getHandValue());
        for (Card card : this.hand)
        {
                card.print();
        }
        System.out.print("\n");
    }

    /**
     * Method to add a card to the dealer's hand
     * @param card card to add to his hand
     */
    public void drawCard(Card card)
    {
        System.out.print("Dealer get a card of ");
        card.print();
        Card[] newHand = Arrays.copyOf(this.hand, this.hand.length + 1);
        newHand[this.hand.length] = card;
        this.hand = newHand;
    }

}
