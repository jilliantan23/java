/**
	 * Program 1c
	 * Printing 1D and 2D arrays
	 * CS108-3
	 * 30-Jan-2018
	 * @author Jillian Tan
	 */
public class MedalTally {
	public static void main(String[] args) {
		String[] countriesArray = { 
				"Canada", 
				"Italy", 
				"Germany", 
				"Japan", 
				"Kazakhstan", 
				"Russia", 
				"South Korea", 
				"United States" 
				};
		//arrays within the array are used to match gold, silver, and bronze
		//medal tallies to the corresponding country
		int[][] medalCount = {
				{0, 3, 0},
				{0, 0, 1},
				{0, 0, 1},
				{1, 0, 0},
				{0, 0, 1},
				{3, 1, 1},
				{0, 1, 0},
				{1, 0, 1}
				};
		printHeader();
		printMedalCount(countriesArray, medalCount);
		System.out.println();
		System.out.println("Total medal count is " + getTotalCount(medalCount));
		}
	
	public static void printHeader() {
		//prints header with each line preceded by the appropriate number of spaces
		System.out.printf("%15s", "Country");
		System.out.printf("%8s", "Gold");
		System.out.printf("%8s", "Silver");
		System.out.printf("%8s", "Bronze");
		System.out.printf("%8s", "Total");
	}
	
	public static void printMedalCount(String[] countriesArray, int[][] medalCount) {
		for (int i = 0; i < medalCount.length; i++ ) {
			System.out.println();
			System.out.printf("%15s", countriesArray[i]); //prints country name
			
			int totalMedals = 0;
			for (int j = 0; j < medalCount[i].length; j++) {
				System.out.printf("%8s", medalCount[i][j]); //prints medal tally
				
				//create a variable in which the total medal tally for each country is stored
				totalMedals = totalMedals + medalCount[i][j];
			}
				System.out.printf("%8s", totalMedals); //prints total medal tally for each country 
		}
	}
	public static int getTotalCount(int[][] medalCount) {
		//create a variable in which the total medal tally for all countries is stored
		int overallTotal = 0;
		for (int i = 0; i < medalCount.length; i++ ) {
			for (int j = 0; j < medalCount[i].length; j++) {
				overallTotal += medalCount[i][j];
			}
		}
		return overallTotal;
	}
}
