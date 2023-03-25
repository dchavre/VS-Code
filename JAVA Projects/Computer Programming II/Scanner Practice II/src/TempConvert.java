import java.util.Scanner;
public class TempConvert {

	public static void main(String[] args) {
		Scanner temp = new Scanner(System.in);
		
		// Input number and determine Celsius:
		System.out.println("Enter Temperature (F): ");
		
		int iResult = temp.nextInt();
		int celsius = (iResult -31) * 5/9;
		
		// Input day:
		System.out.println("Enter a day: ");
		String day = temp.next();
		
		// Displays results:
		
		System.out.println("Today is " + day);
		System.out.println("It is also " + celsius + " (C) degrees outside.");

		temp.close();
	}

}
