// Darsh Milind Chavre
// Rock Paper Scissors
// This project is designed to simulate rock paper scissors.


import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    // Define the choices for each option
    static String[] rock = {"scissors", "rock", "paper"};
    static String[] paper = {"rock", "paper", "scissors"};
    static String[] scissors = {"paper", "scissors", "rock"};

    // Keep track of player and code wins
    static int playerWins = 0;
    static int codeWins = 0;
    static String cont = "n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Rock Paper Scissors: ");
        System.out.println("Rock wins against scissors; paper wins against rock; and scissors wins against paper. Type your choice in, and hit enter.");
        System.out.println("First to 5 points wins (you get a point for each win you get).");

        // Start the game
        play(scanner, random);

        scanner.close();
    }

    public static void play(Scanner scanner, Random random) {
        // Prompt the player for their choice
        System.out.print("Pick between rock, paper, or scissors: ");
        String choice = scanner.nextLine().toLowerCase();
        String codeChoice = randomChoice(random);

        // Determine the outcome of the game based on the player's choice
        if (choice.equals("rock")) {
            if (codeChoice.equals(rock[0])) {
                // Player wins
                System.out.println("You win!");
                System.out.println(choice + " beats " + codeChoice);
                playerWins++;
            } else if (codeChoice.equals(rock[1])) {
                // Tie
                System.out.println("You tied!");
                System.out.println(codeChoice + " and " + choice + " broke each other apart");
            } else if (codeChoice.equals(rock[2])) {
                // Code wins
                System.out.println("You lost!");
                System.out.println(codeChoice + " beats " + choice);
                codeWins++;
            }
        } else if (choice.equals("paper")) {
            if (codeChoice.equals(paper[0])) {
                // Player wins
                System.out.println("You win!");
                System.out.println(choice + " beats " + codeChoice);
                playerWins++;
            } else if (codeChoice.equals(paper[1])) {
                // Tie
                System.out.println("You tied!");
                System.out.println(codeChoice + " and " + choice + " broke each other apart");
            } else if (codeChoice.equals(paper[2])) {
                // Code wins
                System.out.println("You lost!");
                System.out.println(codeChoice + " beats " + choice);
                codeWins++;
            }
        } else if (choice.equals("scissors")) {
            if (codeChoice.equals(scissors[0])) {
                // Player wins
                System.out.println("You win!");
                System.out.println(choice + " beats " + codeChoice);
                playerWins++;
            } else if (codeChoice.equals(scissors[1])) {
                // Tie
                System.out.println("You tied!");
                System.out.println(codeChoice + " and " + choice + " broke each other apart");
            } else if (codeChoice.equals(scissors[2])) {
                // Code wins
                System.out.println("You lost!");
                System.out.println(codeChoice + " beats " + choice);
                codeWins++;
            } else {
                // Invalid choice
                System.out.println("Make sure you pick between rock, paper, or scissors.");
                return;
            }
        } else {
            // Invalid choice
            System.out.println("Make sure you pick between rock, paper, or scissors.");
            return;
        }

        // Print the current scores
        System.out.println("Player Score: " + playerWins);
        System.out.println("Computer Score: " + codeWins);

        // Check if a player has won the game
        if (codeWins < 5 && playerWins < 5) {
            play(scanner, random);
        } else if (codeWins == 5) {
            System.out.println("You lost!");

            // Ask if the player wants to continue
            System.out.print("Would you like to continue? (y/n): ");
            cont = scanner.nextLine().toLowerCase();

            if (cont.equals("y")) {
                // Continue the game
                codeWins = 0;
                playerWins = 0;
                play(scanner, random);
            }
        } else if (playerWins == 5) {
            System.out.println("You won!");

            // Ask if the player wants to continue
            System.out.print("Would you like to continue? (y/n): ");
            cont = scanner.nextLine().toLowerCase();

            if (cont.equals("y")) {
                // Continue the game
                codeWins = 0;
                playerWins = 0;
                play(scanner, random);
            }
        }
    }

    public static String randomChoice(Random random) {
        // Generate a random choice for the computer
        String[] choices = {"rock", "paper", "scissors"};
        int index = random.nextInt(choices.length);
        return choices[index];
    }
}
