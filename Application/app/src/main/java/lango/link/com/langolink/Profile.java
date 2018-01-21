package lango.link.com.langolink;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.ActivityCompat;
import android.Manifest;
import android.app.Activity;



public class Profile extends AppCompatActivity {
    private Button call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, 1);
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.RECORD_AUDIO}, 1);
        call = (Button)findViewById(R.id.call_button);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchCall();
            }
        });
    }
    private void launchCall() {
        Intent intent = new Intent(Profile.this, Chat.class);
        startActivity(intent);
    }
}
