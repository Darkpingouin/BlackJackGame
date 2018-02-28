package com.company;

import java.util.Scanner;

public class BlackJack {
    private realPlayer player;
    private Dealer dealer;
    private Deck deck;
    private Scanner reader = new Scanner(System.in);

    /**
     * Black Constructor initialises player and computer
     */
    BlackJack() {
        player = new realPlayer();
        dealer = new Dealer();
        System.out.println("Welcome to Black Jack, what is your Name ?");
        String name = reader.next();
        player.setName(name);
    }

    /**
     * Menu of the game
     */
    public void Menu()
    {
        int option;
        while (true) {
            System.out.println("\n---------------------------GAME-MENU----------------------------");
            System.out.println("\t1- Create a new deck.");
            System.out.println("\t2- Deal 4 cards and show the number of remaining cards.");
            System.out.println("\t3- Shuffle the deck and show the cards.");
            System.out.println("\t4- Play the Blackjack game.");
            System.out.println("\t5- Quit.");
            System.out.println("----------------------------------------------------------------\n");
            option = reader.nextInt();
            switch (option) {
                case 1:
                    System.out.println("New deck created");
                    createDeck();
                    break;
                case 2:
                    dealCards();
                    break;
                case 3:
                    shuffleDeck();
                    break;
                case 4:
                    deck = null;
                    Play();
                    break;
                case 5:
                    System.out.println("Goodbye " + player.getName() + ". It was a great time. See you again soon.\nOr maybe not, who am I to judge you ? ¯\\_(ツ)_/¯\n ");
                    return;
                default:
                    System.out.println("Error: " + option + " is not a valid option.");
                    break;
            }
        }
    }

    /**
     * Game loop
     */
    private void Play() {
        while (player.getMoney() > 0 && askBet(player)) {
            if (deck == null || deck.getSize() < 20) {
                deck = new Deck();
                deck.Shuffle();
            }
            player.setHand(deck.Draw(), deck.Draw());
            dealer.setHand(deck.Draw(), deck.Draw());
            player.printHand();
            dealer.printHand();
            player.play(deck);
            if (player.getHandValue() <= 21)
                dealer.play(deck);
            dealer.revealHand();
            player.printHand();
            if (player.getHandValue() > dealer.getHandValue() && player.getHandValue() <= 21 || dealer.getHandValue() > 21) {
                System.out.println("Player " + player.getName() + " wins.\n");
                player.addMoney(player.getBet() * 2);
            } else {
                System.out.println("Dealer wins.\n");
                player.addMoney(player.getBet() * -1);
            }
            player.setHand(deck.Draw(), deck.Draw());
            dealer.setHand(deck.Draw(), deck.Draw());
        }
        if (player.getMoney() == 0)
            System.out.println("You lost all your money Bro.");
    }

    /**
     * Method to ask to the player to bet
     * @param player player to ask
     * @return boolean representing if the player still wants to play.
     */
    private boolean askBet(realPlayer player) {
        int bet = -1;

        while (bet < 0 || bet > player.getMoney()) {
            System.out.println("You have $" + player.getMoney() + ". How much do you want to bet?");
            bet = reader.nextInt();
            if (bet < 0)
                System.out.println("The amount of your bet can't be negative");
            else if (bet > player.getMoney())
                System.out.println("You only have $" + player.getMoney());
        }
        player.setBet(bet);
        System.out.print("\n");
        return bet != 0;
    }


    /**
     * Method to create a new deck
     */
    private void createDeck() {
        deck = new Deck();
    }

    /**
     * Method to shuffle the deck;
     */
    private void shuffleDeck() {
        if (deck == null)
            System.out.println("Please create a deck first by using option 1 in the menu.");
        else {
            deck.Shuffle();
            deck.Print();
        }
    }

    /**
     * Method that deals 4 cards from the deck and shows the amount of cards remaining
     */
    private void dealCards() {
        if (deck == null)
            System.out.println("Please create a deck first by using option 1 in the menu.");
        else {
            deck.Draw();
            deck.Draw();
            deck.Draw();
            deck.Draw();
            System.out.println("The size of the deck is " + deck.getSize());
            deck.Print();
        }
    }
}
