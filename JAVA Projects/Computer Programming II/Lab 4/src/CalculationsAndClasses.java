// Darsh Milind Chavre
// Calculating and Classes
// Finding distance, volume, and surface area.
// 2/9/2023

public class CalculationsAndClasses {

	public static void main(String[] args) {
		// Part 1:
		double r;
		double sa;
		double v;
		
		r = 10;
		v = 4.0/3 * Math.PI * Math.pow(r, 3);
		sa = 4 *r * Math.PI * Math.pow(r, 2);
		
		System.out.println("Radius: " + r);
		System.out.println("Volume: " + v);
		System.out.println("Surface Area: " + sa);
		
		// Part 2:
		double x1;
		double x2;
		double y1;
		double y2;
		double d;
		
		x1 = 10;
		x2 = 20;
		y1 = 30;
		y2 = 15;
		d = Math.sqrt(Math.pow(x2-x1, 2)+ Math.pow(y2-y1,2));
		System.out.println("Distance: " + d);
		
	}

}
