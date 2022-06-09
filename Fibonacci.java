import java.util.Scanner;
public class Fibonacci {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Fibonacci optionFib = new Fibonacci();
		System.out.println("Iteration Time: " + optionFib.getTime(scan.nextInt(), scan.nextInt()));
		System.out.println("Recursion Time: " + optionFib.getTime(scan.nextInt(), scan.nextInt()));
		System.out.println(optionFib.iFib(scan.nextInt()));
		System.out.println(optionFib.rFib(scan.nextInt()));
	}
	public String getIdentificationString() {
		String studentID = "Program 2, Jillian Tan, csscxxxx";
		return studentID;
	}
	public int iFib(int n) {
		//counts the Fibonacci sequence through iteration
		int fibNum = 0;
		if (n <= 0) {
			return 0;
		}
		else if (n == 1) {
			return 1;
		}
		else {
			int firstNum = 1;
			int secondNum = 0;
			
			for (int i = 2; i <= n; i++) {
				fibNum = firstNum + secondNum; //adds first two Fib numbers to create a new Fib number
				secondNum = firstNum; //assigns the value of firstnum to secondNum
				firstNum = fibNum; //new firstNum is the sum of the previous firstNum and secondNum
			}
		}
	
			return fibNum;
	}
	public int rFib(int n) {
		//counts the Fibonacci sequence through recursion
		if (n <= 0) {
			return 0;
		}
		else if (n == 1) {
			return 1;
		}
		else {
			return iFib(n - 1) + iFib(n - 2);
		}
	}
	public long getTime(int algorithmType, int n) {
		long startTime = 0;
		long elapsedTime = 0;
		if (algorithmType == 1) { //calculates time elapsed with iteration
			startTime = System.nanoTime();
			iFib(n);
			elapsedTime = System.nanoTime() - startTime;
			
		}
		if (algorithmType == 2) { //calculates time elapsed with recursion
			startTime = System.nanoTime();
			rFib(n);
			elapsedTime = System.nanoTime() - startTime;
		}
			return elapsedTime;
	}
}


