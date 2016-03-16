package bit.dickaj1.passonlaunchapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setupButton();
    }

    /**
     * Set up the on click handler for the settings button
     */
    public void setupButton() {
        //Grab reference to button
        Button btnSettings = (Button) findViewById(R.id.buttonReturn);
        //Set up button handler
        btnSettings.setOnClickListener(new btnSettingsHandler());
    }

    /**
     * Handler for settings button
     */
    public class btnSettingsHandler implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            //Grab username from the form
            //Grab reference to the textView
            EditText editTextUsername=(EditText)findViewById(R.id.editText);
            //Get the string
            String username=editTextUsername.getText().toString();
            //Check username is valid
            if (checkUsername(username)) {
                //Username is valid so bundle up data and transfer to main screen

                //Create intent
                Intent changeActivityIntent = new Intent(SettingsActivity.this, MainActivity.class);
                //Bundle up data
                changeActivityIntent.putExtra("username", username);
                //Transfer control to the new activity
                startActivity(changeActivityIntent);
            }
        }
    }

    /**
     * Checks if the username is valid
     * @param username String to check
     * @return True if username is valid
     */
    public boolean checkUsername(String username){
        //Check for username being okay
        Boolean usernamePassed=true;
        //Check username
        if (username.length()<5) {
            Toast.makeText(SettingsActivity.this, "Username is too short. 5+ required", Toast.LENGTH_SHORT).show();
            usernamePassed=false;
        }
        //TODO additional checks ie no spaces or puncuation

        return usernamePassed;
    }
}
