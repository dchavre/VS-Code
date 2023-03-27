// Darsh Milind Chavre
// Lab 11 - PowerLoop
// 3/27/2023
// Creates a for loop to determine the values of an inputted number to the 1st, 2nd, 3rd, and 4th power.


import java.util.*;

public class PowerLoop  {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int numInput1 = 0;

        System.out.println("Enter an integer: ");
        numInput1 = input.nextInt();
        System.out.println();

        System.out.println("n" + "\t" + "n^2" + "\t" + "n^3" + "\t" + "n^4");

        for(int i =0; i < 4; i++) {
            System.out.print(numInput1);
            System.out.print("\t" + (int) Math.pow(numInput1,2));
            System.out.print("\t" + (int) Math.pow(numInput1,3));
            System.out.print("\t" + (int) Math.pow(numInput1,4) + "\n");
            numInput1 ++;
        }

        input.close();

    }
}
