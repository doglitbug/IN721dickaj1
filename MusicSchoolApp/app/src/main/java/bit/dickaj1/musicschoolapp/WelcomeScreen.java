package bit.dickaj1.musicschoolapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        //Grab handle of the button
        Button buttonContinue = (Button)findViewById(R.id.buttonWelcome);

        //Set event handler
        buttonContinue.setOnClickListener(new buttonContinueHandler());
    }
     public class buttonContinueHandler implements View.OnClickListener{

         @Override
         public void onClick(View v) {
             //Create Intent
             Intent changeActivityIntent = new Intent(WelcomeScreen.this,MainActivity.class);
             //Transfer control to the next activity
             startActivity(changeActivityIntent);
         }
     }

}
