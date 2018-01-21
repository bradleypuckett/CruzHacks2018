package lango.link.com.langolink;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.*;
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

    
    static HashSet<String> hSet = new HashSet<String>();
    static ArrayList<UserInfo> connections = new ArrayList<UserInfo>();

    public static int set = 0;

    public static String temp_name;
    public static String temp_email;
    public static String temp_prim_lang;
    public static ArrayList<String> temp_targetL = new ArrayList();

    public static String session = "1_MX40NjA0MzI5Mn5-MTUxNjU1NTg2MTU2MH5TckJJOENZTWV4ZDlrWUdCWjhVZm9Pa0l-fg";
    public static String token = "T1==cGFydG5lcl9pZD00NjA0MzI5MiZzaWc9MTdiYWNmNWEwZDVjYTRjNjc2MWRjMGY0M2FiMDM4ODJiM2VkMjg0NDpzZXNzaW9uX2lkPTFfTVg0ME5qQTBNekk1TW41LU1UVXhOalUxTlRnMk1UVTJNSDVUY2tKSk9FTlpUV1Y0WkRscldVZENXamhWWm05UGEwbC1mZyZjcmVhdGVfdGltZT0xNTE2NTU2MDc5Jm5vbmNlPTAuMjM0NjA5MjcyNzY5MTk5OTYmcm9sZT1zdWJzY3JpYmVyJmV4cGlyZV90aW1lPTE1MTkxNDgwNzkmaW5pdGlhbF9sYXlvdXRfY2xhc3NfbGlzdD0=";

}
