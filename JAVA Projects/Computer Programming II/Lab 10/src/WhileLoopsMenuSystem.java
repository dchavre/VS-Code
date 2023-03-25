// Darsh Milind Chavre
// Lab 10 - While Loops Menu System
/* 
Using Switch Statements to make a menu system for a doughnut shop,
and incorporating tax as well as a while loop and decimal formatting
*/ 
// 3/21/2023


// Importing Libraries:
import java.util.Scanner;
import java.text.DecimalFormat;

public class WhileLoopsMenuSystem {
    public static void main(String[] args) throws Exception {

        // Setup: 
        DecimalFormat df1 = new DecimalFormat("0.00");
        Scanner input = new Scanner(System.in);

        // Variables: 
        double item = 0.0;
        double subtotal = 0.0;
        int itemtotal = 0; 
        double sales_tax = 0;
        double total = 0;
        int c = 1; // c = 1 to avoid automatic exit case.

        // Selection: 
        System.out.println("----------------------------------------------");
        System.out.println("The Java Coffee Shop \n");
        System.out.println("Please pick from a variety of items on our menu: \n" + 
                            "1 - Coffee and Donut - $3.50 \n" + 
                            "2 - Coffee and Bagel - $3.75 \n" +
                            "3 - Coffee, Donut and Juice - $4.00 \n" +
                            "4 - ½ dozen donuts - $6.00 \n" +
                            "5 - 1 dozen donuts - $9.50 \n" +
                            "0 - Exit System \n" +
                            "----------------------------------------------");

        // A while loop for as long as user doesn't input the exit system:
        while (c != 0) {

        // Selection: 
        System.out.println("Selection: ");
        c = input.nextInt();

        // Cases: 
        if (c == 0) {
            // Receipt:
        System.out.println("----------------------"); // empty space
        System.out.println("Items Ordered: " + itemtotal);
        System.out.println("Subtotal: $" + df1.format(subtotal));
        System.out.println("Sales Tax: $" + df1.format(sales_tax));
        System.out.println("Grand Total: $" + df1.format(total));
        System.out.println("----------------------"); // empty space to look better

        System.out.println(); // blank space;

        break;
        }
        else if (c > 5) {
            System.out.println("Invalid Choice - please order again.");
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
            
        }
    
        // Finds Quantity:
        System.out.println("Quantity: ");
        int q = input.nextInt();


        itemtotal += q; // item total
        subtotal += q * item; // total price

        System.out.println();
        System.out.println(q + " orders of number " + c);
        System.out.println("Cost: $" + df1.format(item));
        System.out.println("Subtotal: $" + df1.format(subtotal));

        
    

        sales_tax = (double) Math.round(subtotal * 8.625) / 100;
        total = subtotal + sales_tax;

        System.out.println(); // blank space
    }
        
}
input.close();
}
}