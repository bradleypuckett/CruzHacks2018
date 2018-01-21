package lango.link.com.langolink;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyProfile extends AppCompatActivity {

    String[] mainLanguages = {"Amharic", "English", "French","German", "Japanese", "Spanish"};
    public String[] mainLanguages1 = {"Amharic", "English"};
    public String[] mainLanguages3 = {"French", "German"};
    public String[] mainLanguages2 = {"Japanese","Spanish"};
    ArrayList<CheckBox> targetLanguageBoxes = new ArrayList();
    ArrayList<CheckBox> primeLanguageBoxes = new ArrayList();
    public ViewGroup lineLay1 = null;
    public ViewGroup lineLay2 = null;
    public ViewGroup lineLay3 = null;
    public ViewGroup lineLay4 = null;
    public ViewGroup lineLay5 = null;
    public ViewGroup lineLay6 = null;

    public EditText name_editText;
    public EditText email_editText;
    private Button editProfile_button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        name_editText = (EditText)findViewById(R.id.name_editText);
        email_editText = (EditText)findViewById(R.id.email_editText);
        editProfile_button = (Button)findViewById(R.id.edit_button);

        init();

        // Set name
        name_editText.setText(GlobalVars.temp_name);

        // Set email
        email_editText. setText(GlobalVars.temp_email);

        // Set Prime Lang
        int langoIndex = 0;
        for(int i = 0; i < mainLanguages.length; i++){
            if(mainLanguages[i].equals(GlobalVars.temp_prim_lang) ){
                langoIndex = i;
            }
        }

        int targIndex = 0;
        for(CheckBox cb : primeLanguageBoxes){
            if(langoIndex == targIndex++){
                cb.setChecked(true);
            }
        }

        //set Target Lang
        int [] targLangoIndex = { 0,0,0,0,0,0};

        for(int j = 0; j< mainLanguages.length; j++){
            if(GlobalVars.temp_targetL.contains( mainLanguages[j]) ){
                targLangoIndex[j] = 1;
            }
        }

        int tIndex = 0;
        for(CheckBox cb : targetLanguageBoxes){
            if( targLangoIndex[tIndex++] == 1 ){
                cb.setChecked(true);
            }
        }

        editProfile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalVars.temp_name = name_editText.getText().toString();
                GlobalVars.temp_email = email_editText.getText().toString();

                int targIndex = 0;
                int check = 0;
                for(CheckBox cb : primeLanguageBoxes){
                    if(cb.isChecked()){
                        check = targIndex;
                    }
                    targIndex++;
                }
                GlobalVars.temp_prim_lang = mainLanguages[check];

                int tIndex = 0;
                int [] targLangoIndex = { 0,0,0,0,0,0};

                for(CheckBox cb : targetLanguageBoxes){
                    if( cb.isChecked() ){
                        targLangoIndex[tIndex++] = 1;
                    }
                }
                GlobalVars.temp_targetL.clear();
                for(int i = 0; i <targLangoIndex.length; i++){
                    if(targLangoIndex[i] == 1){
                        GlobalVars.temp_targetL.add(mainLanguages[i]);
                    }
                }

                launchMain();

            }
        });


    }

    private void launchMain() {
        Intent intent = new Intent(MyProfile.this, Main.class);
        startActivity(intent);
    }

    private void init() {


        lineLay1 = findViewById(R.id.PrimLinLayX);
        lineLay2 = findViewById(R.id.PrimLinLayY);
        lineLay3 = findViewById(R.id.PrimLinLayZ);

        lineLay4 = findViewById(R.id.TarLinLayX);
        lineLay5 = findViewById(R.id.TarLinLayY);
        lineLay6 = findViewById(R.id.TarLinLayZ);

        for(int i = 0; i < 4; i=i+3)
        {
            try
            {
                CheckBox x = new CheckBox(getApplicationContext());
                CheckBox y = new CheckBox(getApplicationContext());
                CheckBox z = new CheckBox(getApplicationContext());

                CheckBox a = new CheckBox(getApplicationContext());
                CheckBox b = new CheckBox(getApplicationContext());
                CheckBox c = new CheckBox(getApplicationContext());

                x.setText(mainLanguages[i]);
                y.setText(mainLanguages[i+1]);
                z.setText(mainLanguages[i+2]);

                a.setText(mainLanguages[i]);
                b.setText(mainLanguages[i+1]);
                c.setText(mainLanguages[i+2]);

                x.setTextColor(Color.WHITE);
                y.setTextColor(Color.WHITE);
                z.setTextColor(Color.WHITE);

                a.setTextColor(Color.WHITE);
                b.setTextColor(Color.WHITE);
                c.setTextColor(Color.WHITE);

                x.setButtonTintMode(PorterDuff.Mode.DARKEN);
                y.setButtonTintMode(PorterDuff.Mode.DARKEN);
                z.setButtonTintMode(PorterDuff.Mode.DARKEN);

                a.setButtonTintMode(PorterDuff.Mode.DARKEN);
                b.setButtonTintMode(PorterDuff.Mode.DARKEN);
                c.setButtonTintMode(PorterDuff.Mode.DARKEN);

                primeLanguageBoxes.add(x);
                primeLanguageBoxes.add(y);
                primeLanguageBoxes.add(z);

                targetLanguageBoxes.add(a);
                targetLanguageBoxes.add(b);
                targetLanguageBoxes.add(c);

                x.setTextSize(16);
                y.setTextSize(16);
                z.setTextSize(16);

                a.setTextSize(16);
                b.setTextSize(16);
                c.setTextSize(16);

                lineLay1.addView(x);
                lineLay2.addView(y);
                lineLay3.addView(z);

                lineLay4.addView(a);
                lineLay5.addView(b);
                lineLay6.addView(c);


            }
            catch(Exception e)
            {
            }
        }
    }
}

