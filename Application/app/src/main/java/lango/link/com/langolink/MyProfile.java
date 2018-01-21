package lango.link.com.langolink;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.util.ArrayList;

public class MyProfile extends AppCompatActivity {

    public String[] mainLanguages1 = {"Amharic", "English"};
    public String[] mainLanguages3 = {"French", "German"};
    public String[] mainLanguages2 = {"Japanese","Spanish"};

    ArrayList<CheckBox> mainLanguageBoxes = new ArrayList();
    public ViewGroup lineLay1 = null;
    public ViewGroup lineLay2 = null;
    public ViewGroup lineLay3 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        lineLay1 = findViewById(R.id.PrimLinLayX);
        lineLay2 = findViewById(R.id.PrimLinLayY);
        lineLay3 = findViewById(R.id.PrimLinLayZ);

        for(int i = 0; i < mainLanguages1.length; i++)
        {
            try
            {
                CheckBox x = new CheckBox(getApplicationContext());
                CheckBox y = new CheckBox(getApplicationContext());
                CheckBox z = new CheckBox(getApplicationContext());

                x.setText(mainLanguages1[i]);
                y.setText(mainLanguages2[i]);
                z.setText(mainLanguages3[i]);

                x.setTextColor(Color.BLACK);
                y.setTextColor(Color.BLACK);
                z.setTextColor(Color.BLACK);

                x.setButtonTintMode(PorterDuff.Mode.DARKEN);
                y.setButtonTintMode(PorterDuff.Mode.DARKEN);
                z.setButtonTintMode(PorterDuff.Mode.DARKEN);

                mainLanguageBoxes.add(x);
                mainLanguageBoxes.add(y);
                mainLanguageBoxes.add(z);

                lineLay1.addView(x);
                lineLay2.addView(y);
                lineLay3.addView(z);


            }
            catch(Exception e)
            {
            }
        }

    }
}

