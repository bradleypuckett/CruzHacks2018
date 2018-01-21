package lango.link.com.langolink;

import android.content.Intent;
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

public class Create extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText first_Name;
    private EditText last_Name;
    private EditText email;
    private EditText inputip;
    private EditText inputPort;
    private Button create_account;
    private String portString;
    private String userString;
    private String passString;
    private String firstString;
    private String lastString;
    private String emailString;
    private String ipString;

    Socket kkSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);


        // Initialize all the buttons and boxes
        init();


        // Executes if user clicks create account
        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go to create
                userString = username.getText().toString();
                passString= password.getText().toString();
                firstString = first_Name.getText().toString();
                lastString = last_Name.getText().toString();
                emailString = email.getText().toString();
                ipString = inputip.getText().toString();
                portString = inputPort.getText().toString();

                GlobalVars.ip = ipString;
                GlobalVars.port = Integer.parseInt(portString);

                try {
                    kkSocket = new Socket(GlobalVars.ip, GlobalVars.port);
                    GlobalVars.out = new PrintWriter(kkSocket.getOutputStream(), true);
                    GlobalVars.in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
                }catch(Exception e){

                }
                // Validate account creation details
                if(( userString.length() != 0) && ( passString.length() != 0) && ( firstString.length() != 0) && ( lastString.length() != 0) &&( emailString.length() != 0) &&( ipString.length() != 0) &&( portString.length() != 0))
                {

                    try {
                        if(NetworkIO.createProfile( GlobalVars.out, GlobalVars.in, userString, passString, emailString, firstString, lastString))
                        {
                            // Valid User
                            launchMain();
                        }
                        else
                        {
                            Toast.makeText(getBaseContext(), "Account creation failed.", Toast.LENGTH_LONG).show();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else
                {
                    Toast.makeText(getBaseContext(), "Please fill all fields." , Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void init() {
        username = (EditText)findViewById(R.id.username_edit_text);
        password = (EditText)findViewById(R.id.password_edit_text);
        first_Name = (EditText)findViewById(R.id.first_name_edit_text);
        last_Name = (EditText)findViewById(R.id.last_name_edit_text);
        email = (EditText)findViewById(R.id.email_edit_text);
        create_account = (Button)findViewById(R.id.create_account_button);
        inputip = (EditText)findViewById(R.id.ip_edit_text);
        inputPort = (EditText)findViewById(R.id.port_edit_text);
    }

    private void launchMain() {
        Intent intent = new Intent(Create.this, Main.class);
        startActivity(intent);
    }
}
