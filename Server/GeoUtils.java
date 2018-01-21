public class GeoUtils{

	// Returns distance between two people in km
	public static double haversineDistance(double lat1, double lon1, double lat2, double lon2){

	    double R = 6371000;
	    double phi_1 = Math.toRadians(lat1);
	    double phi_2 = Math.toRadians(lat2);

	    double delta_phi = Math.toRadians(lat2 - lat1);
	    double delta_lambda = Math.toRadians(lon2 - lon1);

	    double a = Math.pow(Math.sin(delta_phi / 2.0), 2) + Math.cos(phi_1) * Math.cos(phi_2) * Math.pow(Math.sin(delta_lambda / 2.0), 2);
	    
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

	    double meters = R * c;  // output distance in meters
	    double km = meters / 1000.0;  // output distance in kilometers

		System.out.println("In kilometers: " + km);
		return km;
	}
}