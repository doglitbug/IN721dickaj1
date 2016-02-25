package bit.dickaj1.usingedittextapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final int USERNAME_LENGTH = 8;

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
            //Has this key event been full processed
            boolean processed = false;
            //Check for a key press
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                //Check if user has pressed enter, signifying they have finished
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    //Get username from the control to check
                    //Grab handle of the control
                    EditText editTextControl = (EditText) findViewById(v.getId());
                    //Get the text of the username
                    String userName = editTextControl.getText().toString();
                    //Pass to checking method
                    checkUserName(userName);
                    //Tell system that this keypress is processed
                    processed = true;
                }
            }
            return processed;
        }
    }

    /**
     * Checks length of username and prints a message if it is valid or not
     *
     * @param userName String to check
     */
    private void checkUserName(String userName) {
        if (userName.length() == USERNAME_LENGTH) {
            Toast.makeText(MainActivity.this, "Thank you " + userName, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "Usernames must be " + USERNAME_LENGTH + " characters, " + userName, Toast.LENGTH_LONG).show();
        }
    }
}