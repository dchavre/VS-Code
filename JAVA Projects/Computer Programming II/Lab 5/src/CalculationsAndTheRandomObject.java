// Darsh Milind Chavre
// Calculations and the Random Object
// Generates a random number of seconds, and converts it into hours, minutes and seconds.
// 2/15/2023

import java.util.Random;

public class CalculationsAndTheRandomObject {

	public static void main(String[] args) {
		Random rand = new Random();
		int h;
		int m;
		int rs;
		int s = rand.nextInt(50000);
		
		h = s/3600;
		m = (s - (h*3600))/60;
		rs = (s - ((h*3600) + m*60));
		
		System.out.println("Seconds: " + s);
		System.out.println("Hours: " + h);
		System.out.println("Remaining Minutes: " + m);
		System.out.println("Remaining Seconds:" + rs);
	}

}
