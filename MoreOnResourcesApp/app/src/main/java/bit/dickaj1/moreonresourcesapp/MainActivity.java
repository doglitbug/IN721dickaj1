package bit.dickaj1.moreonresourcesapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Grab handle of textView
        TextView txtDisplay=(TextView)findViewById(R.id.textViewDays);

        //Grab text to set in the textView
        String textToDisplay=getTextToDisplay();

        //Set the text
        txtDisplay.setText(textToDisplay);
    }

    private String getTextToDisplay(){
        String theString="February Fridays are on: ";
        int[] theDays;

        //Create a Resources object
        Resources resourceResolver = getResources();

        //Grab the array from resources
        theDays=resourceResolver.getIntArray(R.array.FebFridays);

        //Loop over array adding all the days to the string
        for (int i=0;i<theDays.length;i++){
            theString+=theDays[i];
            theString+=" ";
        }

        return theString;
    }
}
