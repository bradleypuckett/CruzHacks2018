package lango.link.com.langolink;

import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 * Declares variables for connecting to host server
 */

public class GlobalVars {

    public static String ip;
    public static int port;
    public static PrintWriter out;
    public static BufferedReader in;
    public static double lastLongitude;
    public static double lastLatitude;
    
    HashSet<String> hSet = new HashSet<String>();
    ArrayList<UserInfo> connections = new ArrayList<UserInfo>();

}
