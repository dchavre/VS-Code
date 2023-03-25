import java.util.Scanner; // Imports Library
public class Object {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter in a number: ");
		int iResult = input.nextInt();
		
		System.out.println("Enter in your name: ");
		String name = input.next();
		
		System.out.println("Numerical Input: " + iResult);
		System.out.println("Name Input: " + name);

		input.close();
	}

}
