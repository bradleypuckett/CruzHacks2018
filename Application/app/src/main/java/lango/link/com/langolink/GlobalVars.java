package lango.link.com.langolink;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;

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

    public static int set = 0;

    public static String temp_name;
    public static String temp_email;
    public static String temp_prim_lang;
    public static ArrayList<String> temp_targetL = new ArrayList();

}
