package bit.dickaj1.languagetrainerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //Create button handler etc
        //Grab reference
        Button btnStart=(Button)findViewById(R.id.btnStart);
        //Set event handler
        btnStart.setOnClickListener(new btnStartClickHandler());
    }

    public class btnStartClickHandler implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //Create Intent
            Intent startIntent = new Intent(WelcomeActivity.this,QuestionsActivity.class);
            //TODO Bundle in the question manager or default data(so that activity knows to
            //Start questions from the start
            startActivity(startIntent);
        }
    }
}
