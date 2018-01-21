import java.util.*;
import java.net.*;
import java.util.*;
import java.io.*;

public class Test {
  class Control {
    public volatile ArrayList<UserInfo> regUsers = new ArrayList<UserInfo>();
    public volatile Socket lastSock;
  }
  final Control ctr = new Control();

  class ClientThread implements Runnable {
    @Override
    public void run() {

      try{
      PrintWriter outStream = new PrintWriter((ctr.lastSock).getOutputStream(), true);
      BufferedReader inStream = new BufferedReader(new InputStreamReader((ctr.lastSock).getInputStream()));

    // Authenticate user with username + password
      String loginStr = inStream.readLine();
      System.out.println("Got: " + loginStr);
      String loginParts[] = loginStr.split(" ");

      System.out.println(loginParts[0]);


      if(loginParts[0].compareTo("LOGIN") == 0){

        UserInfo userVerify = null;

        for(UserInfo ui : ctr.regUsers){
          if((ui.userName).compareTo(loginParts[1]) == 0){
            userVerify = ui;
          }
        }

        if((userVerify.password).compareTo(loginParts[2]) == 0){
          System.out.println("Login success");
          outStream.println("SUCCESS");
        }
        else{
          System.out.println("Login failure");
          outStream.println("FAIL");
        }
      }
      else if(loginParts[0].compareTo("PROFILE") == 0){
        System.out.println("Got SETUP message");
        UserInfo newUser = new UserInfo(loginParts[1]);
        newUser.password = loginParts[1];
        newUser.email = loginParts[2];
        newUser.firstName = loginParts[3];
        newUser.lastName = loginParts[4];

        ctr.regUsers.add(newUser);
      }

    // Get pointer to UserInfo object using username
      UserInfo currentUser = null;

      for(UserInfo u : ctr.regUsers){
        if(loginParts[1].compareTo(u.userName) == 0){
          currentUser = u;
        }
      }



    while(1 == 1){

      String inStr = inStream.readLine();
      System.out.println("Got: " + inStr);
      String strParts[] = inStr.split(" ");

      // Read in single string
      switch (strParts[0]) { 
        case "REQUEST": System.out.println("Got REQUEST message");

                // Get pointer to UserInfo object using username
                  UserInfo findUser = null;

                  for(UserInfo uu : ctr.regUsers){
                    if(strParts[1].compareTo(uu.userName) == 0){
                      findUser = uu;
                    }
                  }

                  int numLngs = findUser.languages.size();

                outStream.println("RESPONSE " + findUser.userName + " " 
                                + findUser.firstName + " " + findUser.lastName + " " + findUser.userPhotoName + " " + numLngs);

                for(int i = 0; i < numLngs; i++){
                  outStream.println(findUser.languages.get(i)); 
                }
                break;

        case "UPDATE": System.out.println("Got UPDATE message");
                double newLat = Double.parseDouble(strParts[1]);
                double newLon = Double.parseDouble(strParts[2]);

                currentUser.lastLat = newLat;
                currentUser.lastLon = newLon;

                ArrayList<String> nearbyList = scanNearbyUsers(currentUser);
                int listLen = nearbyList.size();
                System.out.println("List has size " + listLen);

                outStream.println("CONNECT " + listLen);
                System.out.println("Sending: " + "CONNECT " + listLen);

                for(String a : nearbyList){
                  outStream.println(a);
                  System.out.println("Sending: " + " " + a);
                }
                break;

        case "GETFILE": NetworkIO.sendFile(outStream, inStream, strParts[1]);
                break;
      }
    }
    }
    catch(SocketException e){
    System.out.println("Connection reset by client");
    }
    catch(Exception e){
      e.printStackTrace(System.out);	
    }
    }
  }

  private void test() {

    int portNumber = 55455;

    UserInfo u1 = new UserInfo("Test1");
    u1.password = "pass";
    u1.lastLat = 33.0;
    u1.lastLon = 33.0;
    ctr.regUsers.add(u1);

    UserInfo u2 = new UserInfo("Test2");
    u2.password = "pass2";
    u2.lastLat = 21.33221;
    u2.lastLon = 54.22222;
    ctr.regUsers.add(u2);
      
    UserInfo u3 = new UserInfo("Test3");
    u3.password = "pass3";
    u3.lastLat = 21.33221;
    u3.lastLon = 54.22222;
    ctr.regUsers.add(u3);
      
    UserInfo u4 = new UserInfo("Test4");
    u4.password = "pass4";
    u4.lastLat = 21.33221;
    u4.lastLon = 54.22222;
    ctr.regUsers.add(u4);

    ServerSocket serverSocket = null;
    try{
      //Create port to listen for incoming client connections
      serverSocket = new ServerSocket(portNumber);
    }
    catch(Exception e){
      e.printStackTrace(System.out);
    }

    while(true){

    try{
      //Accept client connection and make new thread
      ctr.lastSock = serverSocket.accept();
    }
    catch(Exception e){
      e.printStackTrace(System.out);
    }

    ClientThread c = new ClientThread();
    new Thread(c).start();
    }

  }

  public ArrayList<String> scanNearbyUsers(UserInfo u){

    ArrayList<String> outlist = new ArrayList<String>();

    for(UserInfo x : ctr.regUsers){
      if((GeoUtils.haversineDistance(u.lastLat, u.lastLon, x.lastLat, x.lastLon) < 1) && (u.userName != x.userName)){
        System.out.println("Adding to outlist: " + x.userName);
        outlist.add(x.userName);
      }
    }

    return outlist;
  }

  public static void main(String[] args) throws InterruptedException {
    try {
      Test test = new Test();
      test.test();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}