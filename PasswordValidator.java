package labs6;

/**
 * Program Lab 6c
 * Using Methods to Create a Password Validator
 * CS 107-3
 * 21 Nov 2017
 * @author Jillian Tan
 **/
import java.util.Scanner;

public class PasswordValidator {
   public static void main (String[] args) {
      getValidPassword();
   }
   public static void getValidPassword() {
      Scanner scan = new Scanner(System.in);
      String password = scan.nextLine(); //get input from user
      while (!checkLength(password) || !checkUpperCase(password) || !checkLowerCase(password) || !checkNumbers(password)) {
      //checks passwords until all conditions are met
         System.out.println("Invalid password, try again");
         password = scan.nextLine();
      }
         System.out.println("Password accepted");
      }
   public static boolean checkLength(String password) {
      if (password.length() >= 8) { //password must be at least 8 characters
         return true;
      }
      else {
         return false;
      }
   }
   public static boolean checkUpperCase(String password) {
      int counter = 0;
      for (int i = 0; i <= password.length() - 1; i++) {
         if (Character.isUpperCase(password.charAt(i))) {
            counter++;
         }
      }
         if (counter >= 2) { //password must have at least 2 uppercase letters
            return true;
         }
         else {
            return false;
         }
   }
   public static boolean checkLowerCase(String password) {
      int counter = 0;
      for (int i = 0; i <= password.length() - 1; i++) {
         if (Character.isLowerCase(password.charAt(i))) {
            counter++;
         }
      }
         if (counter >= 1) { //password must have at least 1 lowercase letter
            return true;
         }
         else {
            return false;
         }
   }
   public static boolean checkNumbers(String password) {
      int counter = 0;
      for (int i = 0; i <= password.length() - 1; i++) {
         if (Character.isDigit(password.charAt(i))) {
            counter++;
         }
      }
         if (counter >= 2) { //password must have at least 2 numbers
            return true;
         }
         else {
            return false;
         }
   }
}