/**
 * Program Extra Credit B
 * Using Parallel Arrays
 * CS 107-3
 * 4 Dec 2017
 * @author Jillian Tan
 **/

import java.util.Scanner;
public class PlayerRoster {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int rate = 0;
		int jersey = 0;
			
		int[] jerseyNum = new int[5];
		int[] rating = new int[5];
		//parallel arrays
			
		for (int i = 0; i < 5; i++) {
			System.out.println("Enter player " + (i + 1) + "'s jersey number:");
			jerseyNum[i] = scnr.nextInt();
			//ask user for jersey number input
			   System.out.println("Enter player " + (i + 1) + "'s rating:");
			   rating[i] = scnr.nextInt();
			   //ask user for rating input
			   System.out.println();
	      }
	      
	      System.out.println("ROSTER");
	      for (int i = 0; i < 5; i++)
	      {
	         System.out.println("Player " + (i + 1) + " -- Jersey number: " + jerseyNum[i] + ", Rating: " + rating[i]);
	      }
	      //outputs the roster
	      
	      char letter = ' ';
	      while (letter != 'q') {
	    	  System.out.println();
	    	  System.out.println("MENU");
	    	  System.out.println("u - Update player rating");
	    	  System.out.println("a - Output players above a rating");
	    	  System.out.println("r - Replace player");
	    	  System.out.println("o - Output roster");
	    	  System.out.println("q - Quit");
	    	  System.out.println();
	    	  System.out.println("Choose an option:");
	    	  //input letter that corresponds with the option
	    	  
	      
	      letter = scnr.next().charAt(0);
	      //get input from user
	      
	      if (letter == 'o') {
	         //outputs roster
	    	  	System.out.println("ROSTER");
	    	  		for (int i = 0; i < 5; i++) {
	    	  			System.out.println("Player " + (i + 1) + " -- Jersey number: " + jerseyNum[i] + ", Rating: " + rating[i]);
	    	  		}
	      }
	      
	      if (letter == 'u') {
	         //updates player rating
	    	  	System.out.println("Enter a jersey number:");
	    	  	jersey = scnr.nextInt();
	    	  	System.out.println("Enter a new rating for player:");
	    	  	rate = scnr.nextInt();
	    	  		for (int i = 0; i < jerseyNum.length; i++) {
	    	  			if (jerseyNum[i] == jersey) {
	    	  			   //if jersey number input is equal to jerseyNum[i] value
	    	  				rating[i] = rate;
	    	  				//then new rating input is equal to the rating[i] value
	    	  			}
	    	  		}
	      }
	      
	      if (letter == 'a') {
	         //outputs players above the rating
	    	  	System.out.println("Enter a rating:");
	    	  	rate = scnr.nextInt();
	    	  	System.out.println("ABOVE " + rate);
	    	  	for (int i = 0; i < jerseyNum.length; i++) {
	    	  		if (rating[i] > rate) {
	    	  		//if input is less than rating[i] value
	    	  			System.out.println("Player " + (i + 1) + " -- Jersey number: " + jerseyNum[i] + ", Rating: " + rating[i]);
	    	  		}
	    	  	}
	      }
	      
	      if (letter== 'r') {
	         //replaces player
	         System.out.println("Enter a jersey number:");
	         jersey = scnr.nextInt();
	         for (int i = 0; i < jerseyNum.length; i++) {
	        	 	if (jerseyNum[i] == jersey) {
	        	 	//if jersey number is equal to jerseyNum[i], scan again
	        	 		System.out.println("Enter a new jersey number:");
	        	 		jersey = scnr.nextInt();
	        	 		jerseyNum[i] = jersey;
	        	 		//new jersey number input replaces jerseyNum[i]
	        	 		System.out.println("Enter a rating for the new player:");
	        	 		rate = scnr.nextInt();
	        	 		rating[i] = rate;
	        	 		//rating for the new player replaces rating[i]
	        	 	}
	         }
	      }
	      
	      }
	      return;
	   }
	}
