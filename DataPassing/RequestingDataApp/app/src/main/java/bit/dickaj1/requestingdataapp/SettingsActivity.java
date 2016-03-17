package bit.dickaj1.requestingdataapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        returnControl();
    }

    /**
     * Gran data required and return to activity that launched us
     */
    public void returnControl(){
        //Create an intent
        Intent returnIntent=new Intent();
        //Get the data to return
        int dataToReturn=getTextViewColor();
        //Stuff it into return data
        returnIntent.putExtra("TextColor",dataToReturn);

        //Set the return code
        setResult(Activity.RESULT_OK,returnIntent);

        //Pop ourselves off the Activity Stack, control and intent go to the Activity who launched us
        finish();
    }

    /**
     * Find the color of the text in the textview
     * @return int representing the color
     */
    public int getTextViewColor(){
        Color theColor;
        //Get reference
        TextView theTextView=(TextView)findViewById(R.id.textViewBodySettings);
        //Get color and return
        return theTextView.getCurrentTextColor();
    }
}
