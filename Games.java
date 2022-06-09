package labs2;

/**
 *  Program 2d
 *  Strings and Numerical Data for Games
 *  CS 107-3
 *  21-Sep-17
 *  @author Jillian Tan
 */

import java.util.Scanner;
import java.util.Random;
   public class Games {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      Random randGen = new Random();
      Random rand = new Random(340L);
      
      String nounOne    = "";
      String nounTwo    = "";
      String nounThree  = "";
      String nounFour   = "";
      String nounFive   = "";
      
      nounOne = scnr.next();
      System.out.println("But his " + nounOne + " was mad.");
      
      nounTwo = scnr.next();
      System.out.println("Being alone in the " + nounTwo + ",");
      
      nounThree = scnr.next();
      System.out.println("it had looked within " + nounThree + " and,");
      
      nounFour = scnr.next();
      System.out.println("by " + nounFour + " I tell you,");
      
      nounFive = scnr.next();
      System.out.println(nounFive + " had gone mad.");
      
      int numMin = 0;
      int numMax = 0;
      int numGuess = 0;
      int numDifference = 0;
      int numRandom = 0;
      
      numMin = scnr.nextInt();
      numMax = scnr.nextInt();
      System.out.println("Range: " + numMin + "-" + numMax);
      
      numGuess = scnr.nextInt();
      numRandom = rand.nextInt((numMax - numMin) + 1) + numMin;
      numDifference = numRandom - numGuess;
      System.out.print("The difference between the generated number and your guess: ");
      System.out.print(numRandom + " - " + numGuess + " = ");
      System.out.print(+ numDifference);
      
      return;
   }
}