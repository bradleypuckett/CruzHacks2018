import java.net.*;
import java.io.*;
import java.util.*;

public class ClientMain { 

	public static void main(String[] args){

			String hostName = args[0];
	        int portNumber = Integer.parseInt(args[1]);
	 
	        try {
	            Socket kkSocket = new Socket(hostName, portNumber);
	            PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
	            BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));

	            if(/* NetworkIO.createProfile(out, in, "Test1", "pass", "test@email.com", "John", "Doe") */ 
	            	  NetworkIO.sendLogin(out, in, "Test1", "pass")){
	            	System.out.println("Logged in successfully");
	            }
	            else{
	            	System.out.println("Login failed");
	            }

	            ArrayList<String> newConns = NetworkIO.updateLocation(out, in, 21.33221, 54.22222);

	            for(String c : newConns){
	            	System.out.println("New connection: " + c);
	            	System.out.println(NetworkIO.getUserProfile(out, in, c));
	            }

	            NetworkIO.getFile(out, in, "testFile.out", "testFile");
	        }
	        catch(Exception e){

	        }
	}
}