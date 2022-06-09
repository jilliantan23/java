package labs4;

import java.util.Scanner;

public class DebtPayment {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      double amountOwed = 0;
      double payment = 0;
      double interestRate = 0;
      double totalInterest = 0;
      int numMonth = 0;
      
      //get input from user
      amountOwed = scnr.nextDouble();
      payment = scnr.nextDouble();
      interestRate = scnr.nextDouble();
      
      //using while loop to determine the number of months until balance is paid
      while (amountOwed >= 0) {
         totalInterest = totalInterest + (amountOwed * interestRate);  //interest after adding to paid interest
         amountOwed = amountOwed - payment + (amountOwed * interestRate); //amount remaining after payment
         numMonth = numMonth + 1; //increment number of months
      }
      System.out.println(numMonth + " months are required to repay debt");
      System.out.println("Total interest paid (rounded to nearest dollar): $" + Math.round(totalInterest));

   }
}