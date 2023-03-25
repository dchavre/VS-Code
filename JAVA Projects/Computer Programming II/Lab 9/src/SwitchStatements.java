// Darsh Milind Chavre
// Lab 9 - Switch Statements
// Using Switch Statements to make a menu system for a doughnut shop.
// 3/15/2023

import java.util.Scanner;
import java.text.DecimalFormat;

public class SwitchStatements {
    public static void main(String[] args) throws Exception {
        DecimalFormat df1 = new DecimalFormat("0.00");
        Scanner input = new Scanner(System.in);
        double item = 0.0;
        double total = 0.0;

        System.out.println("The Java Coffee Shop");
        System.out.println("Please pick from a variety of items on our menu: \n" + 
                            "1 - Coffee and Donut - $3.50 \n" + 
                            "2 - Coffee and Bagel - $3.75 \n" +
                            "3 - Coffee, Donut and Juice - $4.00 \n" +
                            "4 - ½ dozen donuts - $6.00 \n" +
                            "5 - 1 dozen donuts - $9.50 \n" +
                            "0 - Exit System");

        System.out.println("Selection: ");
        int c = input.nextInt();

        if (c == 0) {
            System.out.println("Goodbye!");
        }
        else {
        switch(c) {

        case 1: item = 3.50;
        break;

        case 2: item = 3.75;
        break;

        case 3: item = 4.00;
        break;

        case 4: item = 6.00;
        break;

        case 5: item = 9.50;
        break;

        case 6: item = 3.50;
        break;

        default: System.out.println("Error - Invalid Choice");
        break;
            
        }
    

        System.out.println("Quantity: ");
        int q = input.nextInt();

        total = item * q;
        System.out.println(q + " orders of number " + c);
        System.out.printf("Total: " + df1.format(total));
        }
        input.close();
    }
}
