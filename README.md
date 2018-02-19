# BlackJackGame

Black Jack Game created during the **CECS274** Class at **CSULB**

![alt text](https://render.bitstrips.com/v2/cpanel/14980f25-7fb0-47b1-9e82-5262e2233e17-2159e7f4-ff2e-4eea-aa3d-f27c381c0ebb-v1.png?transparent=1&palette=1)

## Table of contents

- [Rules](#rules)
- [Card Values](#card-values)
- [Output](#output)
- [Sources](#sources)
- [UML](#uml)

## Rules

- Your program will play the simplified version of Blackjack, which plays at many casinos. The
computer will be the dealer and 1 user will play against the dealer. In this game the player/user
cannot split the card. The player will be given 100 initially and he must bet a positive number to
play. When the player runs out of money the game will stop.
- The dealer will win when there is a tie. Initially both dealer and player will get 2 cards. If the
dealer has 21, he wins. Otherwise if the player has 21, he wins. Both initial cards of the player
will be face-up. The dealer first card is face-down and the second card is face-up.
- When both sides do not have 21 initially, the user gets the chance to get more cards or stand.
The user can win by having more points than the dealer but not more than 21. He can also win
when dealer draws a total greater than 21. When the user draws a value larger than 21, he
looses the bet. When the player stands, it is time for the dealer to play. His first card must turn
its face up.
- The dealer will draw to a value of 17 or larger if his initial value is less than 17. It is a rule of the
black jack. When the dealer draws a value larger than 21, the user wins. The dealer wins when
there is a tie, or he draws a value higher than the user. 

## Card Values

| Card | Value | 
| :---:  |  :---: |
| Ace   | 1 or 11 (Programm takes best value for the player) | 
| King  | 10 | 
| Queen | 10 | 
| Jack  | 10 |
| Ten   | 10 | 
| Nine  | 9  | 
| Eight | 8  | 
| Seven | 7  | 
| Six   | 6  |
| Five  | 5  |
| Four  | 4  |
| Three | 3  |
| Two   | 2  |

## Output

![output](https://user-images.githubusercontent.com/15813261/36395304-63b89c94-156d-11e8-8f39-1970440c07be.png)

## Sources

You can find the sources [here](https://github.com/Darkpingouin/BlackJackGame/tree/master/src/com/company)

You can find the test classes [here](https://github.com/Darkpingouin/BlackJackGame/tree/master/test/com/company)

And you can read the JavaDoc [here]()

## UML

![blackjackuml](https://user-images.githubusercontent.com/15813261/36394250-373d96ce-1568-11e8-867a-5a8684927433.png)



