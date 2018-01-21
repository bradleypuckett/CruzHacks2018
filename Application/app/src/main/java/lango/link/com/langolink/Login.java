package lango.link.com.langolink;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Login extends AppCompatActivity {

    private EditText user_Name;
    private EditText password;
    private Button login;
    private Button create_account;


    private String username;
    private String pass;


    Socket kkSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        try {
            kkSocket = new Socket(hostName, portNumber);
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        }catch(Exception e){

        }

        // Executes if user clicks login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                username = user_Name.getText().toString();
                pass = password.getText().toString();

                if(( username.length() != 0) && ( pass.length() != 0) ){
                    // Validate accounts
                    //if( sendLogin( GlobalVars.out, GlobalVars.in, , )

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

    // Initialize all the buttons and boxes
    private void init() {
        user_Name = (EditText)findViewById(R.id.username_edit_text);
        password = (EditText)findViewById(R.id.password_edit_text);
        login = (Button)findViewById(R.id.login_button);
        create_account = (Button)findViewById(R.id.create_account_button);

        GlobalVars.ip = "127.0.0.1";
        GlobalVars.port = 55455;
        GlobalVars.out = null;
        GlobalVars.in = null;


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
