package lango.link.com.langolink;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText user_Name;
    private EditText password;
    private Button login;
    private Button create_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize all the buttons and boxes
        user_Name = (EditText)findViewById(R.id.username_edit_text);
        password = (EditText)findViewById(R.id.password_edit_text);
        login = (Button)findViewById(R.id.login_button);
        create_account = (Button)findViewById(R.id.create_account_button);

        // Executes if user clicks login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(( user_Name.getText().toString().length() != 0) && ( password.getText().toString().length() != 0) ){
                    // Validate account
                    launchMain();
                }
                else{
                    Toast.makeText(getBaseContext(), "Please enter a valid username and password." , Toast.LENGTH_LONG).show();
                }
            }
        });

        // Executes if user clicks create account
        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go to create
                launchCreate();
            }
        });
    }

    private void launchMain() {
        Intent intent = new Intent(Login.this, Main.class);
        startActivity(intent);
    }

    private void launchCreate() {
        Intent intent = new Intent(Login.this, Create.class);
        startActivity(intent);
    }

}
