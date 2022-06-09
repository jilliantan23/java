package labs3;

import java.util.Scanner;
public class Months {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String userMonth = "";
      String numberMonth = "";
      
      System.out.println("Enter the month: ");
      userMonth = scnr.next();
      
      System.out.println("You entered " + userMonth);
      
      char firstLetter = userMonth.charAt(0);
      char secondLetter = userMonth.charAt(1);
      char thirdLetter = userMonth.charAt(2);
      
      firstLetter = Character.toUpperCase(firstLetter);
      secondLetter = Character.toUpperCase(secondLetter);
      thirdLetter = Character.toUpperCase(thirdLetter);
      //generates the first three letters of the month name in capital letters
      
      System.out.println("Its abbreviation is " + firstLetter + secondLetter + thirdLetter);
      
      if (firstLetter == 'J' && secondLetter == 'A' && thirdLetter == 'N') {
         System.out.println("This is month number 1");
      }
      else if (firstLetter == 'F' && secondLetter == 'E' && thirdLetter == 'B') {
         System.out.println("This is month number 2");
      }
      else if (firstLetter == 'M' && secondLetter == 'A' && thirdLetter == 'R') {
         System.out.println("This is month number 3");
      }
      else if (firstLetter == 'A' && secondLetter == 'P' && thirdLetter == 'R') {
         System.out.println("This is month number 4");
      }
      else if (firstLetter == 'M' && secondLetter == 'A' && thirdLetter == 'Y') {
         System.out.println("This is month number 5");
      }
      else if (firstLetter == 'J' && secondLetter == 'U' && thirdLetter == 'N') {
         System.out.println("This is month number 6");
      }
      else if (firstLetter == 'J' && secondLetter == 'U' && thirdLetter == 'L') {
         System.out.println("This is month number 7");
      }
      else if (firstLetter == 'A' && secondLetter == 'U' && thirdLetter == 'G') {
         System.out.println("This is month number 8");
      }
      else if (firstLetter == 'S' && secondLetter == 'E' && thirdLetter == 'P') {
         System.out.println("This is month number 9");
      }
      else if (firstLetter == 'O' && secondLetter == 'C' && thirdLetter == 'T') {
         System.out.println("This is month number 10");
      }
      else if (firstLetter == 'N' && secondLetter == 'O' && thirdLetter == 'V') {
         System.out.println("This is month number 11");
      }
      else if (firstLetter == 'D' && secondLetter == 'E' && thirdLetter == 'C') {
         System.out.println("This is month number 12");
      }
      else {
         System.out.println("This is month number 0");
      } //nested if statements to generate month number
      return;
   }
}