import java.net.*;
import java.io.*;

public class ServerMain {
	
	public static void main(String[] args){

		int portNumber = Integer.parseInt(args[0]);

		ArrayList<Integer>

		try {
    		ServerSocket serverSocket = new ServerSocket(portNumber);

    		// Create port to listen for incoming client connections
    		Socket clientSocket = serverSocket.accept();
    		PrintWriter outStream = new PrintWriter(clientSocket.getOutputStream(), true);
    		BufferedReader inStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


			// Accept client connection and make new thread for IO
			while(1 == 1){

				String inStr = inStream.readLine();
				String strParts[] = inStr.split(" ");

				// Read in single string
				switch (strParts[0]) { 
					case "REQUEST": System.out.println("Got REQUEST message");
									break;

					case "UPDATE": System.out.println("Got UPDATE message");
									break;

					case "SETUP": System.out.println("Got SETUP message");
									break;
				}
			}
   		}
    	catch (Exception e){
    		e.printStackTrace(System.out);
    	}
	}
}