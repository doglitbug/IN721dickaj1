package bit.dickaj1.languagetrainerapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        //Get arguments
        int correct= getIntent().getExtras().getInt("correct");
        int total=getIntent().getExtras().getInt("total");
        //Set user output on screen
        setFinishText(correct,total);
        //Create button handler etc
        //Grab reference
        Button btnStartAgain=(Button)findViewById(R.id.btnStartAgain);
        //Set event handler
        btnStartAgain.setOnClickListener(new btnStartAgainClickHandler());
    }

    public class btnStartAgainClickHandler implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //Create Intent
            Intent startIntent = new Intent(FinishActivity.this,QuestionsActivity.class);
            //Start questions from the start
            startActivity(startIntent);
        }
    }

    private void setFinishText(int correct, int total){
        //Get resources for string
        Resources res = getResources();
        //Get reference to the textView
        TextView textViewFinish = (TextView)findViewById(R.id.textViewFinish);
        //Create the text string
        String output=String.format(res.getString(R.string.finish_text),correct,total);
        //Set result
        textViewFinish.setText(output);

    }
}
