package lango.link.com.langolink;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Create extends AppCompatActivity {

    private EditText user_Name;
    private EditText password;
    private EditText first_Name;
    private EditText last_Name;
    private EditText email;
    private Button create_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);


        // Initialize all the buttons and boxes

        user_Name = (EditText)findViewById(R.id.username_edit_text);
        password = (EditText)findViewById(R.id.password_edit_text);

        first_Name = (EditText)findViewById(R.id.first_name_edit_text);
        last_Name = (EditText)findViewById(R.id.last_name_edit_text);
        email = (EditText)findViewById(R.id.email_edit_text);
        create_account = (Button)findViewById(R.id.create_account_button);

        // Executes if user clicks create account
        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go to create
                launchMain();
            }
        });

    }

    private void launchMain() {
        Intent intent = new Intent(Create.this, Main.class);
        startActivity(intent);
    }
}
