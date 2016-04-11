package bit.dickaj1.jsonexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    dataManager dataSystem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up button handlers
        setUpButton();

        //TODO set up onclick for listview!
        //Create data manager
        dataSystem=new dataManager(this);
    }

    /**
     * Sets up handlers for buttons
     */
    private void setUpButton() {
        //Grab reference to button
        Button btnFill = (Button) findViewById(R.id.btnFill);
        //Set onclick handler
        btnFill.setOnClickListener(new btnFillHandler());
    }

    /**
     * On click handler for btnFill
     */
    public class btnFillHandler implements Button.OnClickListener {

        @Override
        public void onClick(View v) {
            //Holds data
            ArrayList<myEvent> data;
            //Fetch data
            data = dataSystem.getEvents();
            //Display on screen
            displayList(data);
        }
    }

    /**
     * Put the provided data into a list
     *
     * @param data ArrayList of data to display
     */
    private void displayList(ArrayList<myEvent> data) {
        //Grab reference to the listView
        ListView lvEvents=(ListView)findViewById(R.id.lvEvents);

        //Create the adapter
        ArrayAdapter<myEvent> citiesAdapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,data);

        //Set adapter
        lvEvents.setAdapter(citiesAdapter);

        //Set up a handler
        //TODO Move this to a setup method rather than add it after the list is populated?
        lvEvents.setOnItemClickListener(new lvEventsHandler());
    }

    private class lvEventsHandler implements ListView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //TODO Check item isn;t null???
            Toast.makeText(MainActivity.this,""+position,Toast.LENGTH_LONG).show();
        }
    }
}
