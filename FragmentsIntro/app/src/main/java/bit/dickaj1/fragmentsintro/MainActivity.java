package bit.dickaj1.fragmentsintro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up button handlers
        setUpButtonHandlers();
    }

    private void setUpButtonHandlers(){
        //Grab handle of buttons
        Button btnShowImageView=(Button)findViewById(R.id.btnShowImageView);
        Button btnShowListView=(Button)findViewById(R.id.btnShowListView);
        //Set event handler
        btnShowImageView.setOnClickListener(new btnShowImageViewHandler());
        btnShowListView.setOnClickListener(new btnShowListViewHandler());
    }

    private class btnShowImageViewHandler implements View.OnClickListener{
        @Override
        public void onClick(View v){
            //TODO Show Image view fragment
        }
    }

    private class btnShowListViewHandler implements View.OnClickListener{
        @Override
        public void onClick(View v){
            //TODO Show list view fragment
        }
    }
}
