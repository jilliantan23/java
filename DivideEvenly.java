package labs4;

import java.util.Scanner;

public class DivideEvenly {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int startNumber = 0;
      int endNumber = 0;
      int factorNum = 0;
      
      startNumber = scnr.nextInt(); //get starting number from user
      endNumber = scnr.nextInt(); //get ending number from user
      
      for (startNumber = startNumber; startNumber <= endNumber; startNumber++) { //outer loop from starting number to ending number
          System.out.print(startNumber + " is evenly divisible by ");
          for (factorNum = 1; factorNum <= startNumber; factorNum++) { //inner loop from 1 to starting number
             if (startNumber % factorNum == 0) { //number must be divided evenly with no remainder
                System.out.print(factorNum + " ");
             }
         }
         System.out.println();
      }
      return;
   }
}