package bit.dickaj1.usingedittextapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Grab handle of the EditText box
        EditText editTextControl = (EditText) findViewById(R.id.editTextControl);

        //Set event handler for key presses
        editTextControl.setOnKeyListener(new editTextControlHandler());

    }

    public class editTextControlHandler implements View.OnKeyListener {
        /**
         * Deal with a key press, apparently this only deals with keypresses from a physical keyboard
         * not the soft keyboard, although API version and manufacturer can implement things differently
         *
         * @param v       The View that was called
         * @param keyCode The code for the physical key that was pressed
         * @param event   KeyEvent object containing full information about the event
         * @return Always returns true as we consume the event
         */
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            //Check for a key press
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                //Check it is the keycode we want to take action on
                if (keyCode == KeyEvent.KEYCODE_AT) {
                    Toast.makeText(MainActivity.this, "Don't type @", Toast.LENGTH_SHORT).show();
                }
            }
            return false;
        }
    }
}