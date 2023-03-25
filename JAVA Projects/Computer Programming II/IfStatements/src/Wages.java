import java.util.Scanner;

public class Wages {

	public static void main(String[] args) {
	
		double rate = 8.25;
		int standard = 40;
		double pay = 0;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Hours Worked: ");
		int hours = input.nextInt();
		
		System.out.println();
		
		if (hours > standard) {
		pay = standard * rate + (hours - standard) * (rate*1.5);
		}
		else {
		pay = hours*rate;
		}
		
		System.out.println("Gross earnings: $" + pay);
		
		input.close();
	}

}
