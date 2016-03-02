package bit.dickaj1.multipleactivities;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    }
}
