package bit.dickaj1.musicschoolapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Grab handle of the radio button group
        RadioGroup radioGroupInstruments = (RadioGroup)findViewById(R.id.radioGroupInstruments);

        //Set event handler
        radioGroupInstruments.setOnCheckedChangeListener(new radioGroupInstrumentsHandler());
    }

    public class radioGroupInstrumentsHandler implements RadioGroup.OnCheckedChangeListener{
        /**
         * Deal with item being changed in radiogroup
         * @param group Radio Group that was checked
         * @param checkedId Position in the grouop that was checked
         */
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            //Get selected radio button
            RadioButton chosenButton = (RadioButton)findViewById(checkedId);
            //Get string of instrument
            String selectedInstrument=chosenButton.getText().toString();
            //Pass off to method to change confirmation message
            setMessage(selectedInstrument);
        }
    }

    //Message formatted according to http://developer.android.com/guide/topics/resources/string-resource.html#FormattingAndStyling

    /**
     * Sets a prebuilt message in textViewConfirm using the given instrument
     * @param instrumentName name of instrument
     */
    private void setMessage(String instrumentName){
        //Get textview
        TextView textViewConfirm=(TextView)findViewById(R.id.textViewConfirm);
        //Get message from R and build
        Resources res = getResources();
        String message = String.format(res.getString(R.string.confirmation_message),instrumentName);
        //Set message
        textViewConfirm.setText(message);
    }
}
