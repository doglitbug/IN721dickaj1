package bit.dickaj1.passonlaunchapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Go do set up
        setupButton();

        //Check if data has been passed back
        String username=checkForData();
        if (username!=null){
            //Set on form
            //Get reference to the textcontrol
            TextView textViewUserName=(TextView)findViewById(R.id.textViewUsername);
            //Set text
            textViewUserName.setText(username);
        }
    }

    /**
     * Set up the on click handler for the settings button
     */
    public void setupButton(){
        //Grab reference to button
        Button btnSettings = (Button)findViewById(R.id.buttonSettings);
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
            startActivity(changeActivityIntent);
        }
    }

    /**
     * Checks to see if an intent was set up and there is a username
     * @return username or "" if not launched from settings
     */
    public String checkForData(){
        String username="";
        //Check there was an intent
        Intent launchIntent=getIntent();
        //If launched from an intent
        if (launchIntent!=null){
            //Grab username
            username=launchIntent.getStringExtra("username");
        }
        //Return the username

        return username;
    }
}
