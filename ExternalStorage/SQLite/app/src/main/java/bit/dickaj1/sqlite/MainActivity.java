package bit.dickaj1.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

    private void setUpCountries(){
        //TODO Finish
        ArrayList<String> test = new ArrayList<>();
        test=db.getAllCountries();
    }
}
