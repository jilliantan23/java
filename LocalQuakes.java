import java.util.List;
import java.util.ArrayList;
//ADD JAR FILE TO CLASSPATH
public class LocalQuakes {
	public static void main(String[] args) throws InterruptedException {
		//peaceful|violent
		SimpleEarthquake usgs =     SimpleEarthquake();
		HashSet<String> seen_quakes = new Hashset<String>();
		//significant|all, hour|
		System.out.println(usgs.getEarthquakes("significant", "week"));
		
		List<Earthquake> quakes = usgs.getEarthquakes("all", "day" );
		ArrayList<Earthquake> borrego = new ArrayList<>();
		ArrayList<Earthquake> significant = new ArrayList<>();
		
		for (Earthquake q: quakes) {
			if (q.getMagnitude() > 3.0) {
				significant.add(q);
			if (q.getLocationDescription().contains("Borrego")) {
				double lat = q.getLocation().getLatitude();
				double lon = q.getLocation().getLatitude();
				if ((lat > 32 && lat < 34) && (lon < -115 && lon > -117))
					borrego.add(q);
			}
		}
		String[] mags = new String[significant.size()];
		int i = 0;
		for (Earthquake s : significant)
			mags[i++] = (s.getMagnitude() + " " + s.getLpcationDescription());
		Arrays.sort(mags);
		for (String e : mags) 
			System.out.println(e);
				
	}
}
