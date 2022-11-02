//****************************************************************
//                  Name: Elaine Ulsh
//                  Data Structures Date: 09/21/22
//                  Project 2: Pokemon Battle
//****************************************************************
//          This program is a battle between two people.
//          They choose their pokemon and whichever pokemon
//          has the high speed goes first. The rounds
//          proceed until one of the pokemon's hit points
//          are 0 or less. Which ever pokemon is left standing
//          wins that round.
//
//          Note: if the speeds are equal, whoever goes first
//          is randomized.
//
//          After all of the rounds are complete, the program
//          prints the final scores, determines which player
//          has the higher number of wins, and prints that that
//          player has won the game.
//****************************************************************

//imports Scanner method for use
import java.util.Scanner;

public class PokemonBattle {
    public static void main(String[] args) {
        System.out.println("POKEMON BATTLE");

        //sets up for use of PokemonSelection class
        PokemonSelection test = new PokemonSelection();

        //sets up the Scanner method for use
        Scanner input = new Scanner(System.in);

        //rounds undefined
        int rounds;

        //sets up how many rounds there will be
        System.out.println("Enter an odd number of rounds:");
        //ensures that there will be an off number of rounds
        int temp = input.nextInt();
        if (temp%2 == 0) {
            System.out.println("That is not an odd number of rounds.\nTry again: ");
            rounds = input.nextInt();
        }
        else {
            rounds = temp;
        }

        //each players' totals
        int player1Total = 0;
        int player2Total = 0;

        //iterates each round
        for (int i = 1; i <= rounds; i++) {
            System.out.println("Round " + i + "\n--------");

            Pokemon one = test.assignPokemon(1);
            System.out.println();
            Pokemon two = test.assignPokemon(2);

            //line break
            System.out.println();

            //iterates until one of the pokemon no longer has hit points
            do {
                if (one.goesFirst(two)) {
                    //player 1 going first
                    //subtracting hit point
                    two.subtractHitPoints(one.getPower());

                    //checking to see if player 2's hit points is 0 or less
                    if(0 >= two.checkHitPoints()) {
                        System.out.println("Player 1's " + one.getName() + " wins this round!");
                        player1Total++;
                    }

                    else {
                        //player 2's turn
                        //subtracting hit points
                        one.subtractHitPoints(two.getPower());

                        //checking to see if player 1's hit points is 0 or less
                        if (0 >= one.checkHitPoints()) {
                            System.out.println("Player 2's " + two.getName() + " wins this round!");
                            player2Total++;
                        }
                    }
                }
                else {
                    //player 2 going first
                    //subtracting hit point
                    one.subtractHitPoints(two.getPower());

                    //checking to see if player 1's hit points is 0 or less
                    if(0 >= one.checkHitPoints()) {
                        System.out.println("Player 2's " + two.getName() + " wins this round!");
                        player2Total++;
                    }

                    else {
                        //player 1's turn
                        //subtracting hit points
                        two.subtractHitPoints(one.getPower());

                        //checking to see is player 2's hit points is 0 or less
                        if (0 >= two.checkHitPoints()) {
                            System.out.println("Player 1's " + one.getName() + " wins this round!");
                            player1Total++;
                        }
                    }
                }

            } while (one.checkHitPoints() > 0 && two.checkHitPoints() > 0);

            //if this is the last time the for loop will iterate, it prints out the final score
            if (i == rounds) {
                System.out.println("\nFinal Score\n----\nPlayer 1: " + player1Total + "\nPlayer 2: " + player2Total);
                System.out.println();
            }
            //if it still has more iterations left, it prints out the running score
            else {
                System.out.println("\nWins\n----\nPlayer 1: " + player1Total + "\nPlayer 2: " + player2Total);
                System.out.println();
            }
        }

        //if player 1's total number of points is higher than player 2's, then player 1 wins
        if (player1Total > player2Total) {
            System.out.println("Player 1 Wins!");
        }
        //otherwise, player 2 wins
        else {
            System.out.println("Player 2 Wins!");
        }

        //there cannot be a tie because there should always be an odd number of rounds
    }
}
