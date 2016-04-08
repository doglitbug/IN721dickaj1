package bit.dickaj1.externaltextfileapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up button handler
        setUpButton();
    }

    /**
     * Sets up handlers for buttons
     */
    private void setUpButton(){
        //Grab reference to button
        Button btnFill=(Button)findViewById(R.id.btnFill);
        //Set onclick handler
        btnFill.setOnClickListener(new btnFillHandler());
    }

    /**
     * On click handler for btnFill
     */
    public class btnFillHandler implements Button.OnClickListener{

        @Override
        public void onClick(View v) {
            fillList();
        }
    }

    /**
     * Load and populate the list
     */
    private void fillList(){
        //TODO populate list
    }
}
