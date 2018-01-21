package lango.link.com.langolink;
import java.net.*;
import java.io.*;
import java.util.*;

public class UserInfo {

   String userName;
   String password;
   String firstName;
   String primaryLang;
   String email;
   double lastLat;
   double lastLon;
   long lastTimeUpdate;
   String userPhotoName;
   ArrayList<String> languages;

   public UserInfo(String name) {
      this.userName = name;
      this.password = "";
      this.firstName = "";
      this.primaryLang = "";
      this.email = "";
      this.lastLat = -1;
      this.lastLon = -1;
      this.lastTimeUpdate = -1;
      this.userPhotoName = "";
      languages = new ArrayList<String>();
   }

   public void updateLocation(double lat, double lon) {
      lastLat = lat;
      lastLon = lon;
      Date d = new Date();
      lastTimeUpdate = d.getTime();
   }

   public void changeLanguage(String lang, boolean add) {
      if(add){
         languages.add(lang);
      }
      else{
         languages.remove(lang);
      }
   }

   public void addPhoto(String path){
      userPhotoName = path;
   }

   public String toString(){
      String result = "";

      result = result + "Username: " + userName + "\n";
      result = result + "Password: " + password + "\n";
      result = result + "FirstName: " + firstName + "\n";
      result = result + "PrimaryLang: " + primaryLang + "\n";
      result = result + "Email: " + email + "\n";
      result = result + "Latitude: " + lastLat + "\n";
      result = result + "Longitude: " + lastLon + "\n";
      result = result + "Timestamp: " + lastTimeUpdate + "\n";
      result = result + "Photo Name: " + userPhotoName + "\n";

      return result;
   }
}