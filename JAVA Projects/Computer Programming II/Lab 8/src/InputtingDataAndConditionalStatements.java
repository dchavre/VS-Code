// Darsh Milind Chavre
// Inputting Data and Conditional Statements
/* Calculates your net earnings, tax deductions, insurance deducations, and gross pay 
from your hours worked, hourly rate, marrital status, and the number of dependents. */


import java.util.Scanner;

public class InputtingDataAndConditionalStatements {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int standard = 40; 
        int insurance_cost = 0;
        double tax = 0;
        double gross_pay = 0.0; 
        System.out.println("Hours Worked: "); 
        int hours = input.nextInt();
        System.out.println("Hourly Rate: ");
        double rate = input.nextDouble();
        System.out.println("Marrital Status (m/s): ");
        char ms = input.next().charAt(0);
        System.out.println("Number of Dependents (including yourself): ");
        int dependents = input.nextInt();
        
        if (hours > standard) {
            gross_pay = standard * rate + (hours - standard) * (rate * 1.5);
        } 
        else {
            gross_pay = hours * rate;
        }

        if (ms == 's') {
            tax = 0.85;
        }
        if (ms == 'm') {
            tax = 0.9;
        }
        
        if (dependents == 1) {
            insurance_cost = 10;
        }
        else {
            insurance_cost = 5 * (dependents - 1) + 10;
        }

        double net_pay = (gross_pay * tax) - insurance_cost;
        double tax_cost = gross_pay - tax * gross_pay;

        System.out.println("Gross Pay: $" + gross_pay);
        System.out.println("Tax Deductions: $" + tax_cost);
        System.out.println("Insurance Deductions: $" + insurance_cost);
        System.out.println("Net Pay: $" + net_pay);
        
        input.close();
    }
}
