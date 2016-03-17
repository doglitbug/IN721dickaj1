package bit.dickaj1.requestingdataapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up button and handler
        setupButton();
    }

    /**
     * Set up the on click handler for the settings button
     */
    public void setupButton(){
        //Grab reference to button
        Button btnSettings = (Button)findViewById(R.id.buttonChange);
        //Set up button handler
        btnSettings.setOnClickListener(new btnSettingsHandler());
    }

    /**
     * Handler for settings button
     */
    public class btnSettingsHandler implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //Create intent
            Intent changeActivityIntent = new Intent(MainActivity.this,SettingsActivity.class);
            //Transfer control to the new activity
            startActivityForResult(changeActivityIntent,42);
        }
    }
}
