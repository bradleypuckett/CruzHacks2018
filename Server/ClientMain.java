import java.net.*;
import java.io.*;

public class ClientMain { 

	public static void main(String[] args){

			String hostName = args[0];
	        int portNumber = Integer.parseInt(args[1]);
	 
	        try {
	            Socket kkSocket = new Socket(hostName, portNumber);
	            PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
	            BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));

	            updateLocation(out, in, 21.33221, 54.22222);
	            getUserProfile(out, in, 41);
	            sendUserProfile(out, in, "SAMPLEDATA");

	            //BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	            //String fromServer;
	            //String fromUser;
	        }
	        catch(Exception e){

	        }
	}
}