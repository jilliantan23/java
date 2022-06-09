/**
  * Program 2b
  * Using Recursive Methods
  * CS108-3
  * 13-Feb-2018
  * @author Jillian Tan
  * Partner: Thong Le
  */

public class FunFunFun {
	public static void main(String[] args) {
		FunFunFun app = new FunFunFun();
		System.out.println(app.fastCountDown(3));
		app.gcd(1440, 408, 0); //Call GCD method
		System.out.println( "T(4) = " + app.eTime(4) );
	}
	public String fastCountDown(int num) {
		String countNum = Integer.toString(num);
		//Convert int to string
		
		if (num < 0) {
			System.out.println("Error: user entered a negative number.");
			return countNum;
		}
		else if (num <= 1) { //Base case
			return countNum + " ";
		}
		else {
			countNum = countNum + " " + fastCountDown(num - 2); //Count down by 2
			return countNum;
		}
	}
	public int gcd(int p, int q, int level) {
		
		String indentation = ""; //Initial three spaces
		for (int i = 0; i < level; i++) {
			indentation += "   ";
		}
		if (q == 0) {
			System.out.println(indentation + "gcd(" + p + "," + q + ")");
			for (int i = 0; i < level + 1; level--) {
				//Indentation decreases by three spaces for every return print out
				indentation = "";
				for (int j = 0; j < level + 1; j++) {
					//Indentation increases by three spaces after every GCD print out
					indentation += "   ";
				}
				System.out.println(indentation + "return " + p);
			}
			return p;
		}
		else {
			if (p > q) { //GCD print outs while q > 0
				System.out.println(indentation + "gcd(" + p + "," + q + ")");
				return gcd(q, (p % q), (level + 1));
			}
			else { //Final GCD print out
				System.out.println(indentation + "gcd(" + p + "," + q + ")");
				return gcd(q, p, (level + 1));
			}
		}
			
	}
	public int eTime(int n) {
		
		if (n == 0) {
			return n;
		}
		else {
			return 2 * (eTime(n - 1)) + 1; //Formula of exponential time growth
		}
	}
	public String getIdentificationString() {
		String studentID = "Program 2b, Jillian Tan";
		return studentID;
	}
}
