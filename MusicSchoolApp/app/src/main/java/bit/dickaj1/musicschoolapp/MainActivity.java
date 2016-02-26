package bit.dickaj1.musicschoolapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        //Grab handle of the confirm button
        Button buttonConfirm = (Button)findViewById(R.id.buttonConfirm);
        //Set event handler
        buttonConfirm.setOnClickListener(new buttonConfirmHandler());
    }

    public class radioGroupInstrumentsHandler implements RadioGroup.OnCheckedChangeListener{
        /**
         * Deal with item being changed in radiogroup
         * Simply enable the confirm button
         * @param group Radio Group that was checked
         * @param checkedId Position in the group that was checked
         */
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            //get confirmbutton id and set clickable
            Button buttonConfim = (Button)findViewById(R.id.buttonConfirm);
            buttonConfim.setEnabled(true);
        }
    }

    public class buttonConfirmHandler implements Button.OnClickListener{
        /**
         * Deal with a click on the button
         * @param v Object that generated the event
         */
        @Override
        public void onClick(View v) {
            //We dont need to check if an instrument has been selected as this control will be disabled
            //until that happens

            //Find the text of the selected item

            //Get radio group
            RadioGroup radioGroupInstruments = (RadioGroup)findViewById(R.id.radioGroupInstruments);
            //Get selected index of said group
            int radioButtonIndex = radioGroupInstruments.getCheckedRadioButtonId();
            //Get selected radio button
            RadioButton radioButtonSelected =(RadioButton)findViewById(radioButtonIndex);
            //Get string of instrument
            String selectedInstrument=radioButtonSelected.getText().toString();
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
