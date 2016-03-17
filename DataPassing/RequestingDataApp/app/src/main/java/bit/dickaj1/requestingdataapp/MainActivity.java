package bit.dickaj1.requestingdataapp;

import android.app.Activity;
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

        //Set up button and handler
        setupButton();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        //Check correct request and result
        if ((requestCode==42) && (resultCode== Activity.RESULT_OK)){
            //Fetch the data required
            int result=data.getIntExtra("TextColor",0);
            //Set the textColor with it
            //Get reference to textView to change
            TextView textViewToChange=(TextView)findViewById(R.id.textViewBodyMain);
            //Change it
            textViewToChange.setTextColor(result);
        }
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
            startActivityForResult(changeActivityIntent, 42);
        }
    }
}
