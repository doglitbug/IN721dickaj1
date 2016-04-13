package bit.dickaj1.lastfmapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Load preferences

        //Set up buttons
        setUpButtons();
    }

    public void setUpButtons(){
        //Get references to buttons
        Button btnTask1=(Button)findViewById(R.id.btnTask1);
        Button btnTask2=(Button)findViewById(R.id.btnTask2);
        Button btnTask3=(Button)findViewById(R.id.btnTask3);
        //Set onclick handlers
        btnTask1.setOnClickListener(new btnTask1_OnClickHandler());
        btnTask2.setOnClickListener(new btnTask2_OnClickHandler());
        btnTask3.setOnClickListener(new btnTask3_OnClickHandler());
    }

    ////////////// Handlers /////////////////
    public class btnTask1_OnClickHandler implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent changeToTask = new Intent(MainActivity.this,TopArtistsActivity.class);
            startActivity(changeToTask);
        }
    }

    public class btnTask2_OnClickHandler implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent changeToTask = new Intent(MainActivity.this,UserSearchActivity.class);
            startActivity(changeToTask);
        }
    }

    public class btnTask3_OnClickHandler implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent changeToTask = new Intent(MainActivity.this,DisplayImageActivity.class);
            startActivity(changeToTask);
        }
    }
}
