package bit.dickaj1.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    databaseManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up database
        db=new databaseManager(this);

        //Populate the drop down
        setUpCountries();

        //Set up button handlers
        setUpButtons();
    }

    /**
     * Sets up handlers for the buttons
     */
    private void setUpButtons(){
        //Get reference to the button
        Button btnSearch=(Button)findViewById(R.id.btnSearch);
        //Set onclick handler
        btnSearch.setOnClickListener(new btnSearchHandler());
    }

    public class btnSearchHandler implements Button.OnClickListener{
        @Override
        public void onClick(View v) {
            //Get country
            Spinner spinnerCountries=(Spinner)findViewById(R.id.spinnerCountries);
            String country=spinnerCountries.getSelectedItem().toString();
            //Display data
            displayCities(country);
        }
    }

    /**
     * Populate the spinner with all the countries
     */
    private void setUpCountries(){
        //Get data
        ArrayList<String> data = db.getAllCountries();
        //Grab reference to the spinner
        Spinner spinnerCountries=(Spinner)findViewById(R.id.spinnerCountries);
        //Get a layout
        int layoutId=android.R.layout.simple_spinner_dropdown_item;
        //Create the adapter
        ArrayAdapter<String>spinnerCountriesAdapter=new ArrayAdapter<>(this,layoutId,data);
        //Bind the adapter
        spinnerCountries.setAdapter(spinnerCountriesAdapter);
    }

    /**
     * Search for country and display in listView
     * @param country to search for
     */
    private void displayCities(String country){
        //Get reference to listView
        ListView lvCities = (ListView)findViewById(R.id.lvCities);
        //Get the data for listview
        ArrayList<String> data = db.searchCountry(country);
        //Create the adapter
        ArrayAdapter<String> citiesAdapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,data);

        //Set adapter
        lvCities.setAdapter(citiesAdapter);
    }
}
