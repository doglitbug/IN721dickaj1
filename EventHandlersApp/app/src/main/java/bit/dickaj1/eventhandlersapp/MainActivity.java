package bit.dickaj1.eventhandlersapp;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Grab handle of the button
        Button btnClickTest =(Button)findViewById(R.id.btnClickTest);

        //Set event handlers
        //Normal click
        btnClickTest.setOnClickListener(new btnClickTestHandler());
        //Long click
        btnClickTest.setOnLongClickListener(new btnClickTestHandler());

    }

        public class btnClickTestHandler implements View.OnClickListener, View.OnLongClickListener {

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Normal Click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this,"Long Click", Toast.LENGTH_SHORT).show();
                return true;
            }
        }

}
