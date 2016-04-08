package bit.dickaj1.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    databaseManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up database
        db=new databaseManager(this);

        //Set up button handlers
        setUpButtons();
    }

    /**
     * Sets up handlers for the buttons
     */
    public void setUpButtons(){
        //TODO Finish
    }

}
