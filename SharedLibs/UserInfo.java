public class UserInfo {

   String userName;
   double lastLat;
   double lastLon;
   long lastTimeUpdate;
   String userPhotoName;
   ArrayList<String> languages;

   public UserInfo(String name) {
      this.userName = name;
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
      if(add == 1){
         languages.append(lang);
      }
      else{
         languages.remove(lang);
      }
   }

   public void addPhoto(String path){
      userPhotoName = path;
   }
}