/**
	 * Program 1a
	 * Writing A One Non-static Method
	 * CS108-3
	 * 26-Jan-2018
	 * @author Jillian Tan
	 */

import java.util.Scanner;
public class Digits {
	public void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
	}
	public int firstDigit(int number) {
		String stringNum= Integer.toString(Math.abs(number)); //convert int to string
		int firstNum = Integer.parseInt(stringNum.substring(0,1)); //identifies first digit 
		return firstNum;
	}
	public int lastDigit(int number) {
		String stringNum = Integer.toString(number); //converts int to string
		int lastNum = Integer.parseInt(stringNum.substring(stringNum.length() - 1, stringNum.length()));
		//identifies last digit
		return lastNum;
	}
	public int digits(int number) {
		String firstString = Integer.toString(Math.abs(number)); //convert int to string
		int numDigits = firstString.length();
		return numDigits;
	}
}
