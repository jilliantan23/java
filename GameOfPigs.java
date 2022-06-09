package labs4;

import java.util.Scanner;
import java.util.Random;
public class GameOfPigs {
	private static Scanner scnr;
	public static void main(String[] args) {
		scnr = new Scanner(System.in);
		int firstDie = 0;
		int secondDie = 0;
		int totalScore = 0;
		int tempScore = 0;
		int cont = 0;
		Random randOne = new Random(140L);
		Random randTwo = new Random(340L);
		Random randThree = new Random(140L);
	
		firstDie = randOne.nextInt(6) + 1;
		secondDie = randTwo.nextInt(6) + 1;
		
		//USER'S TURN
		if (firstDie > 1 && secondDie > 1) {
			tempScore = firstDie + secondDie;
			System.out.println("Your turn (current points: " + tempScore + ")");
			System.out.println("You rolled " + firstDie + " and " + secondDie + ", points earned this turn:" + tempScore);
			System.out.println("Press 0 to roll again or 1 to start computer's turn");
			totalScore =+ tempScore;
			cont = scnr.nextInt();
		
		}
		//points earned, display total points earned for that turn
		
		if ((firstDie == 1 && secondDie != 1) || (firstDie != 1 && secondDie == 1)) {
			tempScore = 0;
			System.out.println("No points earned. Next player's turn.");
			cont = 1; //swtiches to computer's turn
		
		}
		
		if (firstDie == 1 && secondDie == 1) { //player's turn is over and their total is reset to 0
			totalScore = 0;
			cont = 1;
			
		
		}
	
		//COMPUTER'S TURN
		firstDie = randOne.nextInt(6) + 1;
		secondDie = randTwo.nextInt(6) + 1;
		
		do {
		   if (firstDie > 1 && secondDie > 1) {
			   tempScore = firstDie + secondDie;
			   System.out.println("Computer's turn (current points: " + tempScore + ")");
			   System.out.println("Computer rolled " + firstDie + " and " + secondDie + ", points earned this turn:" + tempScore);
			   totalScore += tempScore;
			   if ((firstDie == 1 && secondDie != 1) || (firstDie != 1 && secondDie == 1)) {
				   tempScore = 0;
				   System.out.println("No points earned. Next player's turn.");
				   cont = 0; //switches to user's turn
			
			   if (firstDie == 1 && secondDie == 1) { //player's turn is over and their total is reset to 0
				   totalScore = 0;
				   cont = 0;
			   }
			   
			   }
		   } break;
		} while ((firstDie > 1) && (secondDie > 1));
		
		compTurn = randThree.nextInt(2); //computer decides if it wants to switch turns or keep going
		  
		return;
		}
	}