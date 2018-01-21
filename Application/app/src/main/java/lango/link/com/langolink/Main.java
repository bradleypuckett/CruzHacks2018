package lango.link.com.langolink;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Main extends AppCompatActivity {

    private Button connections;
    private Button my_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        connections = (Button)findViewById(R.id.connections_button);
        my_profile = (Button)findViewById(R.id.my_profile_button);

        // Executes if user clicks connections
        connections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go to create
            //    launchConnections();
            }
        });


        // Executes if user clicks my profile
        my_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go to create
                launchMyProfile();
            }
        });

    }
/*
    private void launchConnections() {
        Intent intent = new Intent(Main.this, MyProfile.class);
        startActivity(intent);
    }
    */
    private void launchMyProfile() {
        Intent intent = new Intent(Main.this, MyProfile.class);
        startActivity(intent);
    }
}
