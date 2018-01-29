package com.company;

import java.util.Arrays;

/**
 * Player is the class representing a player of the BlackJack game
 *
 * @author Oreo
 */
public class realPlayer extends Player {

    /** Name of the player. */
    private String name;

    /** Amount of money the player has. */
    private int money;

    /** Amount of money the player wants to bet. */
    private int bet;

    /**
     * Basic constructor for a player
     * Init the amount of money to $100
     * Init the bet to 0
     * Set default name to "Jack Black"
     */
    public realPlayer()
    {
        this.money = 100;
        this.bet = 0;
        this.name = "Jack Black";
    }

    /**
     * Method to get the @name of the player
     * @return name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set the name of the player
     * @param name name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get the amount of money the player has
     * @return amount of money the player has
     */
    public int getMoney() {
        return money;
    }


    /***
     * Method to add money to player's total
     * @param amount amount to add to the player's money total
     */
    public void addMoney(int amount)
    {
        this.money += amount;
    }

    /***
     * Method to set the amount of the bet of the player
     * @param amount amount of the bet
     */
    public void setBet(int amount)
    {
        this.bet = amount;
    }

    /***
     * Method to get the amount of the bet of the player
     * @return amount of the bet
     */
    public int getBet()
    {
        return this.bet;
    }

    /***
     * Method to print the player's hand
     */
    public void printHand() {
        System.out.println("Your hand has a value " + this.getHandValue());
        for (Card card : this.hand)
        {
            card.print();
        }
        System.out.print("\n");
    }

    /***
     * Method to add a card to player's hand
     * @param card card to add to player's hand
     */
    public void drawCard(Card card)
    {
        System.out.print("Player " + this.getName() + " get a card of ");
        card.print();
        Card[] newHand = Arrays.copyOf(this.hand, this.hand.length + 1);
        newHand[this.hand.length] = card;
        this.hand = newHand;
    }
}
