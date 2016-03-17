package bit.dickaj1.requestingdataapp;

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

    public void returnControl(){
        //Create an intent
        Intent returnIntent=new Intent();
        //Get data to return
        int dataToReturn=getTextViewColor();
        //Stuff it into 
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
