package lango.link.com.langolink;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Profile extends AppCompatActivity {
    private Button call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

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
