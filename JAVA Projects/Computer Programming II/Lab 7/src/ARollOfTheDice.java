// Darsh Milind Chavre
// A Roll Of The Dice
// 3/1/2023
// A simulated dice game, where the person who rolls a higher total (2 dice rolls per person) wins.

import java.util.Random;
import java.lang.Math;

public class ARollOfTheDice {
    public static void main(String[] args) {
        Random rand = new Random();

        // Player's Turn:
        int r1 = rand.nextInt(1, 7);
        int r2 = rand.nextInt(1, 7);

        System.out.println("Player Roll 1: " + r1);
        System.out.println("Player Roll 2: " + r2);

        int player_total = 0;
        int computer_total = 0;

        if (r1 == r2) {
            double p = Math.pow((r1 + r2), 2);
            player_total = (int) p;
        }
        else {
            double p = r1 + r2;
            player_total = (int) p;
        }
        System.out.println("Player Total: " + player_total);

        // Computer's Turn:
        int r3 = rand.nextInt(1, 7);
        int r4 = rand.nextInt(1, 7);

        System.out.println("Computer Roll 1: " + r3);
        System.out.println("Computer Roll 2: " + r4);

        if (r3 == r4) {
            double c = Math.pow(r3 + r4, 2);
            computer_total = (int) c;
        }
        else {
            double c = r3 + r4;
            computer_total = (int) c;
        }
        System.out.println("Computer Total: " + computer_total);
        
        // Finding the Winner:
        if (computer_total > player_total) {
            System.out.println("The computer wins!");
        }
        else if (computer_total < player_total) {
            System.out.println("The player wins!");
        }
        else if (computer_total ==  player_total) {
            System.out.println("It is a tie!");
        }
    }
}
