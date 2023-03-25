import java.util.Scanner;

public class LoopDemo2 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int count = 0, sum = 0, value = 0, choice = -1;
        System.out.println("Choice: ");
        choice = input.nextInt();

        while (choice != 0) {
            System.out.println("Your choice: " + choice);
            System.out.println("Enter your choice: ");

            choice = input.nextInt();
        }
        System.out.println("The program ended.");

        input.close();
    }
}
