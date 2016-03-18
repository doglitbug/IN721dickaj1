package bit.dickaj1.musicschoolapp;

import android.content.res.Resources;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Grab handle of the radio button group
        RadioGroup radioGroupInstruments = (RadioGroup) findViewById(R.id.radioGroupInstruments);
        //Set event handler
        radioGroupInstruments.setOnCheckedChangeListener(new radioGroupInstrumentsHandler());

        //Set up spinner
        //Get months
        Resources res = getResources();
        String[] months = res.getStringArray(R.array.months);
        //Get reference to control
        Spinner spinnerWhen = (Spinner) findViewById(R.id.spinnerWhen);
        //Get a layout
        int layoutID = android.R.layout.simple_spinner_item;
        //Create the adapter
        ArrayAdapter<String> spinnerWhenAdapter = new ArrayAdapter<String>(this, layoutID, months);
        //Bind the adapter
        spinnerWhen.setAdapter(spinnerWhenAdapter);

        //Grab handle of the confirm button
        Button buttonConfirm = (Button) findViewById(R.id.buttonConfirm);
        //Set event handler
        buttonConfirm.setOnClickListener(new buttonConfirmHandler());
    }

    public class radioGroupInstrumentsHandler implements RadioGroup.OnCheckedChangeListener {
        /**
         * Deal with item being changed in radiogroup
         * Simply enable the confirm button
         *
         * @param group     Radio Group that was checked
         * @param checkedId Position in the group that was checked
         */
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            //get confirmbutton id and set clickable
            Button buttonConfirm = (Button) findViewById(R.id.buttonConfirm);
            buttonConfirm.setEnabled(true);
        }
    }

    public class buttonConfirmHandler implements Button.OnClickListener {
        /**
         * Deal with a click on the button
         *
         * @param v Object that generated the event
         */
        @Override
        public void onClick(View v) {
            //TODO Pop off to dialog boc
        }
    }

    /**
     * Sets a prebuilt message in textViewConfirm using the given instrument
     */
    public void giveMeMyData(Boolean confirmed) {
        String outputMessage;
        Resources res = getResources();
        //Get textview
        TextView textViewConfirm = (TextView) findViewById(R.id.textViewConfirm);

        if (confirmed) {
            //Get radio group
            RadioGroup radioGroupInstruments = (RadioGroup) findViewById(R.id.radioGroupInstruments);
            //Get selected index of said group
            int radioButtonIndex = radioGroupInstruments.getCheckedRadioButtonId();
            //Get selected radio button
            RadioButton radioButtonSelected = (RadioButton) findViewById(radioButtonIndex);
            //Get string of instrument
            String selectedInstrument = radioButtonSelected.getText().toString();
            //Get the spinner
            Spinner spinnerWhen = (Spinner) findViewById(R.id.spinnerWhen);
            //Get text from selected item. In a concatentated line because im unsure of the object type returned
            String month = spinnerWhen.getSelectedItem().toString();

            //Get message from R and build
            outputMessage = String.format(res.getString(R.string.confirmation_message), selectedInstrument, month);
        } else {
            outputMessage = res.getString(R.string.denial_message);
        }
        //Set message
        textViewConfirm.setText(outputMessage);
    }
}