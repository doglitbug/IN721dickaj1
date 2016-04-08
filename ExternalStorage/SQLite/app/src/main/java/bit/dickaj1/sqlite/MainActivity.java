package bit.dickaj1.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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
        //TODO Finish
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
}
