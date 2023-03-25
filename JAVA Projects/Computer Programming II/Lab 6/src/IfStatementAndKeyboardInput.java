// Darsh Milind Chavre
// Lab 6 - If Statements & Keyboard Inputs in Java
// 3/1/2023
// Takes 3 grades, averages it, and then outputs a lettered grade.


import java.util.Scanner;
import java.text.DecimalFormat;

public class IfStatementAndKeyboardInput {

public static void main(String[] args) {
Scanner input = new Scanner(System.in);
DecimalFormat df1 = new DecimalFormat("0.00");

System.out.println("Grade 1: ");
double G1;
G1 = input.nextInt();
System.out.println("Grade 2: ");
double G2;
G2 = input.nextInt();
System.out.println("Grade 3: ");
double G3;
G3 = input.nextInt();

double avg = (G1 + G2 + G3)/3;

System.out.println("Average of 3 Grades: " + avg);

if (avg >= 90) {
System.out.println("You got an A. Good job!");
}
else if (avg <= 89 && avg >= 80) {
System.out.println("You got a B.");
}
else if (avg <= 79 && avg >= 70) {
System.out.println("You got a C.");
}
else if (avg <= 69 && avg >= 65) {
System.out.println("You got a D.");
}
else if (avg <= 65) {
System.out.println("You got an F.");
}
}

}