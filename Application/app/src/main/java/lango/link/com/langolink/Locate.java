package lango.link.com.langolink;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.pm.*;
import android.support.v4.content.*;
import com.google.android.gms.maps.*;
import android.support.v4.app.ActivityCompat;
import java.util.*;

import java.io.IOException;


public class Locate extends Main implements LocationListener {

    private LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(Locate.this, Main.class);
        startActivity(intent);
        ActivityCompat.requestPermissions(this, new String[]{
                android.Manifest.permission.ACCESS_FINE_LOCATION }, 1);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                10000, 1, this);

    }

    @Override
    public void onLocationChanged(Location location) {
        GlobalVars.lastLongitude = location.getLongitude();
        GlobalVars.lastLatitude = location.getLatitude();
        try {
            ArrayList<String> userList = NetworkIO.updateLocation(GlobalVars.out, GlobalVars.in, GlobalVars.lastLatitude, GlobalVars.lastLongitude);
            for(String s : userList){
                if( !((GlobalVars.hSet).contains(s))){
                    GlobalVars.hSet.add(s);
                    UserInfo newUser = getUserProfile(GlobalVars.out, GlobalVars.in, s);
                    GlobalVars.connections.add(newUser);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onProviderDisabled(String provider) {

        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(intent);
        Toast.makeText(getBaseContext(), "Gps is turned off!! ",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderEnabled(String provider) {

        Toast.makeText(getBaseContext(), "Gps is turned on!! ",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub

    }

}
