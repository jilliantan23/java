import java.util.Random;
public class FiveCards {
	public static void main(String[] args) {
		int[] array = new int[5];
		initHand(52, 5, 1111);
		showHand();
		sameSuit();
		
	public static int[] initHand(int deckSize, int handSize, long randomGeneratorSeed) {
		Random rand = new Random(randomGeneratorSeed);
		int[] handArray = new int[handSize];
		
		for (int i = 0; i < handArray.length(); ++i) {
			hand[i] = rand.nextInt(deckSize);
			if ((i > 0) && (hand[i] != hand[i - 1])) {
				hand[i] = rand.nextInt(deckSize);
			}
		}
		return handArray;
	}
		
		public static void showHand(int[] hand) {
		
		}
		
		public static void sameSuit(int[] hand) {
			
		}
		
		public static String getIdentificationString() {
			String identification = "Program 1, Jillian Tan, csscxxxx";
			return identification;
		}
		
		public static String getCardValue(int cardNumber) {
			String cardVal = rankName(cardNumber) + " of " + suitName(cardNumber);
		}
		
		public static String getSuit(int cardNumber) {
			String suitName = "";
			if (cardNumber >= 0 && cardNumber <= 12) {
				suitName = "Clubs";
			}
			if (cardNumber >= 13 && cardNumber <= 25) {
				suitName = "Diamonds";
			}
			if (cardNumber >= 26 && cardNumber <= 38) {
				suitName = "Hearts";
			}
			if (cardNumber >= 39 && cardNumber <= 51) {
				suitName = "Spades";
			}
		}
		public static String getRank(int cardNumber) {
			String rankName = "";
		
			if (cardNumber == 0 || cardNumber == 13 || cardNumber == 26 || cardNumber == 39) {
				rankName = "Ace";
			}
			if (cardNumber == 1 || cardNumber == 14 || cardNumber == 27 || cardNumber == 40) {
				rankName = "Two";
			}
			if (cardNumber == 2 || cardNumber == 15 || cardNumber == 28 || cardNumber == 41) {
				rankName = "Three";
			}
			if (cardNumber == 3 || cardNumber == 16 || cardNumber == 29 || cardNumber == 42) {
				rankName = "Four";
			}
			if (cardNumber == 4 || cardNumber == 17 || cardNumber == 30 || cardNumber == 43) {
				rankName = "Five";
			}
			if (cardNumber == 5 || cardNumber == 18 || cardNumber == 31 || cardNumber == 44) {
				rankName = "Six";
			}
			if (cardNumber == 6 || cardNumber == 19 || cardNumber == 32 || cardNumber == 45) {
				rankName = "Seven";
			}
			if (cardNumber == 7 || cardNumber == 20 || cardNumber == 33 || cardNumber == 46) {
				rankName = "Eight";
			}
			if (cardNumber == 8 || cardNumber == 21 || cardNumber == 34 || cardNumber == 47) {
				rankName = "Nine";
			}
			if (cardNumber == 9 || cardNumber == 22 || cardNumber == 35 || cardNumber == 48) {
				rankName = "Ten";
			}
			if (cardNumber == 10 || cardNumber == 23 || cardNumber == 36 || cardNumber == 49) {
				rankName = "Jack";
			}
			if (cardNumber == 11 || cardNumber == 24 || cardNumber == 37 || cardNumber == 50) {
				rankName = "Queen";
			}
			if (cardNumber == 12|| cardNumber == 25 || cardNumber == 38 || cardNumber == 51) {
				rankName = "King";
			}
			
			return rankName;
		}
		
	}

}
