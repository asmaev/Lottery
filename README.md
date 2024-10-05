### Assignment - Lottery Game: Tolo

### Project Description

Tolo is a lottery game where players choose numbers and the amount of money they wish to bet. The game consists of a draw that determines the winnings based on the player's selected numbers. The draw includes four distinct random numbers between 1 and 20 and one additional "lucky number" between 1 and 10.

### Game Mechanics

### Types of Bets

1. **Bet Game**: 
   - The player selects 4 numbers between 1 and 20.
   - Payouts are as follows:
     - **3 correct numbers**: 5 times the bet amount.
     - **4 correct numbers**: 50 times the bet amount.

2. **Super Bet Game**: 
   - The player selects 4 numbers between 1 and 20 and one additional lucky number between 1 and 10.
   - Payouts are as follows:
     - If the lucky number is not found, payouts are the same as the Bet Game.
     - If the lucky number is found, the payout is 5 times the payout of the Bet Game.

### Graphical User Interface

The application features two graphical user interfaces (GUIs) using `JFrame`:
1. The first GUI allows the user to choose their numbers, place their bets, and launch the Tolo draw.
2. The second GUI displays the results of the draw and the calculated payout.

### GUI Example
- The extra number choice TextField is only visible if the user selects the Super Bet option.



