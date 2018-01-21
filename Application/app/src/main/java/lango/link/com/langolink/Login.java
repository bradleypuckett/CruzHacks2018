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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Login extends AppCompatActivity {

    private EditText user_Name;
    private EditText password;
    private EditText inputip;
    private EditText inputPort;
    private Button login;
    private Button create_account;
    private String username;
    private String pass;
    private String portstring;


    Socket kkSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        // Executes if user clicks login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                username = user_Name.getText().toString();
                pass = password.getText().toString();

                GlobalVars.ip = inputip.getText().toString();
                portstring = inputPort.getText().toString();
                GlobalVars.port = Integer.parseInt(portstring);

                try {
                    kkSocket = new Socket(GlobalVars.ip, GlobalVars.port);
                    GlobalVars.out = new PrintWriter(kkSocket.getOutputStream(), true);
                    GlobalVars.in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
                }catch(Exception e){

                }
                if(( username.length() != 0) && ( pass.length() != 0) )
                {
                    // Validate account
                    try {
                        if(NetworkIO.sendLogin( GlobalVars.out, GlobalVars.in, username, pass))
                        {
                            // Valid User
                            launchMain();
                        }
                        else
                        {
                            Toast.makeText(getBaseContext(), "Username or password invalid.", Toast.LENGTH_LONG).show();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else
                {
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
        inputip = (EditText)findViewById(R.id.ip_edit_text);
        inputPort = (EditText)findViewById(R.id.port_edit_text);
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
