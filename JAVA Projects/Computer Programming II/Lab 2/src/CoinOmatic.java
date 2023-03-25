
public class CoinOmatic {

	public static void main(String[] args) {
	int q;
	int n;
	int d;
	int p;
	
	q = 210;
	n = 119;
	d = 300;
	p = 444;
	double totQ = q * .25;
	double totD = d * .1;
	double totP = p*0.01;
	double totN = n*0.05;
	double total = totQ + totD + totN + totP;
	System.out.println("Total amount " + total);
	}

}
