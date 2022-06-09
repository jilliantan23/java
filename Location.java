/**
 * Program 4a
 * Using UML diagram to Construct Code
 * CS108-3
 * 5-Mar-2018
 * @author Jillian Tan
*/
public class Location {
	//Private fields
	private double EARTH_RADIUS_MILES; 
	private double latitude;
	private double longitude;
	
	public Location() {
		EARTH_RADIUS_MILES = 3963.1676;
		latitude = 0.0;
		longitude = 0.0;
	}
	public Location(double lat, double lon) {
		latitude = lat;
		longitude = lon;
	}
	public void setLatitude(double lat) {
		latitude = lat;
		
	}
	public double getLatitude() {
		return latitude;
		
	}
	public void setLongitude(double lon) {
		longitude = lon;
		
	}
	public double getLongitude() {
		return longitude;
	}
	/*Returns the distance in miles between this geo location and the given
	 * other geo location
	 */
	public double distanceFrom(Location other) {
		double lat1 = Math.toRadians(this.latitude);
		double lon1 = Math.toRadians(this.longitude);
		
		double lat2 = Math.toRadians(latitude);
		double lon2 = Math.toRadians(longitude);
		
		/* Apply the spherical law of cosines with a triangle composed of
		 * the two locations and the North Pole
		 */
		double cosC = Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2);
		double arcLenC = Math.acos(cosC);
		
		return arcLenC * EARTH_RADIUS_MILES; // Return the arcLenC times RADIUS
	}
	/* equals() method returns true if the latitude and longitude are the same
	 * (within 0.0001 degrees difference)
	 */
	public boolean equals(Location other) {
		if (Math.abs(latitude - other.latitude) <= 0.0001) {
			if (Math.abs(longitude - other.longitude) <= 0.0001) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	public String toString() {
		return ("latitude:" + latitude + ",longitude:" + longitude); //Prints output
	}

}
