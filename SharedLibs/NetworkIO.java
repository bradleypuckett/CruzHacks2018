
public class NetworkIO {

	static void updateLocation(PrintWriter out, BufferedReader in, double lat, double lon){
		out.println("UPDATE " + lat + " " + lon + "\n");
	}

	static String getUserProfile(PrintWriter out, BufferedReader in, int userID){
		out.println("REQUEST " + userID + "\n");
		String response = in.readLine();
		String responseArr[] = response.split(" ");
		assert(responseArr[0] == "RESPONSE");
		return "TESTDATA";
	}

	// 
	static void sendUserProfile(PrintWriter out, BufferedReader in, String data){
		out.println("SETUP " + data + "\n");
	}

	// Will return an array of user IDs
	// For each user ID, use the getUserProfile to obtain their profile information
	static ArrayList<Integer> checkNewConnections(PrintWriter out, BufferedReader in){
		ArrayList<Integer> outData = new ArrayList<Integer>();

		outData.append(23213);
		outData.append(333);

		return outData;
	}
}