
import java.util.*;
import java.io.*;
import java.net.*;
import java.nio.file.*;

public class NetworkIO {
	int waitingCall;

	public static void triggerNotification(){
		// Do something with the sessionID waitingCall
	}

	public static boolean sendLogin(PrintWriter out, BufferedReader in, String userName, String password) throws IOException{

		out.println("LOGIN " + userName + " " + password);
		String response = in.readLine();
		System.out.println("Got back: " + response);
		if(response.compareTo("SUCCESS") == 0){
			return true;
		}
		else{
			return false;
		}
	}

	public static boolean createProfile(PrintWriter out, BufferedReader in, String userName, String password, String email,
		                                                                    String firstName, String lastName) throws IOException{
		out.println("PROFILE " + userName + " " + password + " " + email + " " + firstName + " " + lastName);
		String response = in.readLine();
		System.out.println("Got back: " + response);
		if(response.compareTo("SUCCESS") == 0){
			return true;
		}
		else{
			return false;
		}
	}

	public static ArrayList<String> updateLocation(PrintWriter out, BufferedReader in, double lat, double lon) throws IOException, InterruptedException{
		if(checkCallsWaiting(out, in)){
			triggerNotification();
		}
		ArrayList<String> outList = new ArrayList<String>();
		out.println("UPDATE " + lat + " " + lon);
		String response = in.readLine();
		System.out.println("Got back: " + response);
		String responseArr[] = response.split(" ");

		assert(responseArr[0].compareTo("CONNECT") == 0);
		int numConnections = Integer.parseInt(responseArr[1]);
		for(int x = 0; x < numConnections; x++){
			outList.add(in.readLine());
		}
		return outList;
	}

	public static void getFile(PrintWriter out, BufferedReader in, String localFileName, String remoteFileName) throws IOException{
		if(checkCallsWaiting(out, in)){
			triggerNotification();
		}

		FileOutputStream fos = new FileOutputStream(localFileName);

		out.println("GETFILE " + remoteFileName);

		String response = in.readLine();

		System.out.println("Got: " + response);
		String responseArr[] = response.split(" ");
		assert(remoteFileName.compareTo(responseArr[0]) == 0);

		int fLen = Integer.parseInt(responseArr[1]);
		int bytesIn = 0;

		System.out.println("Got file size of: " + fLen);

		byte fileArr[] = new byte[fLen];

		for(int f = 0; f < fLen; f++){
			fileArr[f] = (byte) Integer.parseInt(in.readLine());
			System.out.println("Got byte: " + fileArr[f]);
		}

    	fos.write(fileArr);
	    fos.close();
	}

	public static void sendFile(PrintWriter out, BufferedReader in, String localFileName) throws IOException{
		if(checkCallsWaiting(out, in)){
			triggerNotification();
		}
		Path path = Paths.get(localFileName);
	    long fLength = Files.size(path);
		byte[] data = Files.readAllBytes(path);

		out.println(localFileName + " " + fLength);

		for(byte b : data){
			out.println( (int) b);
			System.out.println("Sent byte: "  + ((int) b));
		}

	}

	public static UserInfo getUserProfile(PrintWriter out, BufferedReader in, String userName){
		if(checkCallsWaiting(out, in)){
			
		}
		UserInfo result = new UserInfo(userName);

		out.println("REQUEST " + userName);
		try{
			String response = in.readLine();
			String responseArr[] = response.split(" ");
			assert(responseArr[0].compareTo("RESPONSE") == 0);

			result.firstName = responseArr[2];
			result.lastName = responseArr[3];
			result.userPhotoName = responseArr[4];

			int numLangs = Integer.parseInt(responseArr[5]);
			for(int i = 0; i < numLangs; i++){
				result.languages.add(in.readLine());
			}
		}
		catch(Exception e){
	        e.printStackTrace(System.out);
		}
		return result;
	}

	public static void updateLangs(PrintWriter out, BufferedReader in, ArrayList<String> data){
		out.println("UPDATE_TARGETS " + data.size());

		for(String x : data){
			out.println(" " + x);
		}
	}

	public static void updatePrimaryLang(PrintWriter out, BufferedReader in, String data){
		out.println("UPDATE_LANG " + userName);
	}

	public static void updateImage(PrintWriter out, BufferedReader in, String data){
		out.println("UPDATE_IMAGE " + userName);
	}

	public static void updateName(PrintWriter out, BufferedReader in, String data){
		out.println("UPDATE_NAME " + userName);
	}

	public static void updateEmail(PrintWriter out, BufferedReader in, String data){
		out.println("UPDATE_EMAIL " + userName);
	}

	public static boolean checkCallsWaiting(PrintWriter out, BufferedReader in){
		if(in.ready()){
			String inStr = in.readLine();
			System.out.println("Check for calls: " + inStr);
			String spl[] = inStr.split(" ");
			if(spl[0].compareTo("CALL_WAIT")){
				return true;
			}
		}
		return false;
	}
}