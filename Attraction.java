/**
 * Program 4c
 * Developing Subclasses to Illustrate Inheritance
 * CS108-3
 * 13-Mar-2018
 * @author Jillian Tan
*/
public class Attraction extends Place {
	private int type;
	private double price;
	
	public Attraction(String name, String desc, double latitude, double longitude, double myPrice, int myType) {
		super(name, desc, latitude, longitude);
		//New attributes
		price = myPrice;
		type = myType;
	}
	public double getPrice() {
		return price; //Returns current price
	}
	public int getType() {
		return type; //Returns type of attraction
	}
	public boolean hasAnimals() {
		if (type == 1 || type == 2) {
			return true; //Returns true if type contains "zoo" or "aquarium"
		}
		else {
			return false; //Returns false if type of attraction does not have animals
		}
	}
	@Override
	public String toString() {
		String output = getName() + " (" + getLocation() + ")\n\tTickets average $" + price + "0";
		
		if (hasAnimals() == true) {
			return output + " and feature exciting animals"; 
			//Prints out attraction with animals, its location, and its average price
		}
		else {
			return output; 
			//Prints out attraction without animals, its location and its average price
		}
	}
}
