package labs4;

import java.util.Scanner;
public class LetterCount {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      String userInput = "";
      char charInput = '0';
      int countLetter = 0; //assign a variable that represents each letter
      
      userInput = scan.nextLine(); //scan user input
      charInput = scan.next().charAt(0); //scan the letter to be found
      
      for(int i = 0; i < userInput.length(); ++i) {
         if (userInput.charAt(i) == charInput) { //find the number of times a letter appears in input
            countLetter++;
         }
      }
      
      System.out.print("The letter '" + charInput + "' appears " + countLetter);
      
      if (countLetter != 1) {
         System.out.print(" times in the string \"" + userInput + ".\""); //output if letter appears more than once or zero times
      }
      else {
         System.out.print(" time in the string \"" + userInput + ".\""); //output if letter appears only once
      }
      
      System.out.println("");
      
      return;
   }
}