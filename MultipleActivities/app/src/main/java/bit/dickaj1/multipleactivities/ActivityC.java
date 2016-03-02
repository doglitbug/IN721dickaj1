package bit.dickaj1.multipleactivities;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        //Set up the instructions
        //Get textView
        TextView textViewInstructions = (TextView)findViewById(R.id.textViewInstructions);
        //Get instructional text
        Resources res=getResources();
        String instructions=res.getString(R.string.instructionsC);
        //Set on textView
        textViewInstructions.setText(instructions);


        //Set up the button
        //Grab the handle of the button
        Button btnChange = (Button)findViewById(R.id.btnChange);

        //Set event handler
        btnChange.setOnClickListener(new btnChangeClickHandler());
    }

    public class btnChangeClickHandler implements View.OnClickListener{
        /**
         * Deal with a single click
         * @param v The view that was clicked
         */
        @Override
        public void onClick(View v) {
            //Create URI
            Uri goSeeAWebsite = Uri.parse("https://habitica.com/");
            //Create Intent
            Intent websiteIntent = new Intent(Intent.ACTION_VIEW, goSeeAWebsite);
            //Transfer control to the next activity
            startActivity(websiteIntent);
        }
    }

}
