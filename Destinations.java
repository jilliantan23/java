/**
 * Program 5a
 * Creating a Driver Class and ArrayList Class
 * CS108-3
 * 20-Mar-2018
 * @author Jillian Tan
*/
import java.util.ArrayList;
public class Destinations {
	public static void main(String[] args) {
		ArrayList<Place> places = initList();
		//Print each Place using enhanced for-loop showing polymorphism
		for (Place myPlace : places) {
			System.out.println(myPlace);
		}
		//For each Eatery, print numeric rating followed by a space followed by appropriate 'stars'
		for (int i = 0; i < 3; i++) {
			Eatery myEatery = (Eatery)places.get(i);
			System.out.println(myEatery.getRating() + " " + myEatery.ratingToStars());
		}
        //For each Attraction, print its name followed by a space followed by its description
		for (int i = 3; i < 6; i++) {
			System.out.println(places.get(i).getName() + " " + places.get(i).getDescription());
		}

        //Test Tea Station's latitude and longitude against Tender Greens', print true or false
		if (places.get(1).getLocation() == places.get(2).getLocation()) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		
        //Compare Original Pancake House and Tender Greens cuisine, print true or false
		Eatery pancake = (Eatery)places.get(0);
		Eatery greens = (Eatery)places.get(2);
		
		if (pancake.getCuisine() == greens.getCuisine()) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		
        //Test Birch Aquarium and SD Zoo types, print true or false
		Attraction aquarium = (Attraction)places.get(4);
		Attraction zoo = (Attraction)places.get(5);
		
		if (aquarium.getType() == zoo.getType()) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}

    }

    private static ArrayList<Place> initList() {
        ArrayList<Place> list = new ArrayList<>();
        Eatery[] restaurants = {
                new Eatery("Original Pancake House","Breakfast",32.815274,-117.1546500,"casual dining",14.0,4),
                new Eatery("Tea Station","Asian cafe with tea drinks",32.76049,-117.06739,"casual dining",8.0,3),
                new Eatery("Tender Greens","2400 Historic Decatur Rd",32.73547,-177.21601,"casual dining",26.0,4)
        };
        Attraction[] fun = {
                new Attraction("PetCo Park","Padres Baseball",32.708129,-117.157036,37.0,0),
                new Attraction("Birch Aquarium at Scripps Institution of Oceanography",
                        "Fish Aquarium",32.865776,-117.250518, 18.50, 1),
                new Attraction("San Diego Zoo","Animal Park",32.735316,-117.149046,52.0,2)
        };
        for (Eatery e : restaurants)
            list.add(e);
        for (Attraction a : fun)
            list.add(a);

        return list;
    }
    
	public String getIdentificationString() {
		String studentID = "Program 5a, Jillian Tan, csscxxxx";
		return studentID;
	}
}
