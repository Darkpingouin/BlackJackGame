package com.company;

import java.util.Scanner;

public class BlackJack {
    public realPlayer player;
    public Dealer dealer;
    public Deck deck;
    public Scanner reader = new Scanner(System.in);
    public boolean continueDrawing;
    public boolean continueGame;

    public BlackJack() {
        this.player = new realPlayer();
        this.dealer = new Dealer();
        System.out.println("Welcome to Black Jack, what is your Name ?");
        String name = reader.next();
        this.player.setName(name);
    }

    public void Play() {
        if (this.deck == null || this.deck.getSize() < 20) {
            deck = new Deck();
            deck.Shuffle();
        }
        if (this.player.getMoney() > 0 && askBet(this.player)) {
            this.continueDrawing = true;
            this.player.setHand(deck.Draw(), deck.Draw());
            this.dealer.setHand(deck.Draw(), deck.Draw());
            this.player.printHand();
            this.dealer.printHand();
            while (this.continueDrawing && this.player.getHandValue() < 21 && this.dealer.getHandValue() < 21)
                this.continueDrawing = this.askDraw(this.player);
            while (this.dealer.getHandValue() < 17 && this.player.getHandValue() <= 21)
                this.dealer.drawCard(deck.Draw());
            this.dealer.revealHand();
            this.player.printHand();
            if (this.player.getHandValue() > this.dealer.getHandValue() && this.player.getHandValue() <= 21 || this.dealer.getHandValue() > 21) {
                System.out.println("Player " + this.player.getName() + " wins.\n");
                this.player.addMoney(this.player.getBet() * 2);
            } else {
                System.out.println("Dealer wins.\n");
                this.player.addMoney(this.player.getBet() * -1);
            }
            this.player.setHand(deck.Draw(), deck.Draw());
            this.dealer.setHand(deck.Draw(), deck.Draw());
            Play();
        }
        if (this.player.getMoney() == 0)
            System.out.println("You lost all your money Bro.");
    }

    public boolean askBet(realPlayer player) {
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
        if (bet == 0)
            return false;
        return true;
    }

    public boolean askDraw(realPlayer player) {
        String response = "";
        while (!response.contains("y") && !response.contains("n") && player.getHandValue() < 21) {
            System.out.println("Do you want a card [y/n]?");
            response = reader.next();
            System.out.print("\n");
        }
        if (response.contains("y")) {
            player.drawCard(deck.Draw());
            player.printHand();
            return true;
        }
        return false;
    }

    public void createDeck() {
        this.deck = new Deck();
    }

    public void shuffleDeck() {
        this.deck.Shuffle();
        this.deck.Print();
    }

    public void dealCards() {
        this.deck.Draw();
        this.deck.Draw();
        this.deck.Draw();
        this.deck.Draw();
        System.out.println("The size of the deck is " + this.deck.getSize());
    }

}
