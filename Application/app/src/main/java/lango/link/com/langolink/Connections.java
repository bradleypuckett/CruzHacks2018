package lango.link.com.langolink;
import android.content.Intent;
import android.widget.ListView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.*;
import android.widget.Toast;
import android.view.*;

public class Connections extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connections);
        ListView connections = (ListView) findViewById(R.id.connectpeople);
        // Defined Array values to show in ListView
        
        String[] values = new String[GlobalVars.connections.size()];
        for(int i = 0; i < values.length(); i++){
            values[i] = (GlobalVars.connections.get(i)).userName;
        }
        
        
//         String[] values = new String[] { "Android List View",
//                 "Adapter implementation",
//                 "Simple List View In Android",
//                 "Create List View Android",
//                 "Android Example",
//                 "List View Source Code",
//                 "List View Array Adapter",
//                 "Android Example List View"
//         };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        connections.setAdapter(adapter);

        // ListView Item Click Listener
        connections.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                ListView connections = (ListView) findViewById(R.id.connectpeople);
                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) connections.getItemAtPosition(position);

                // Visit connection's profile
                Intent intent = new Intent(Connections.this, Profile.class);
                startActivity(intent);

            }

        });
    }

}

