package bit.dickaj1.topartistandimage;

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

        //Set up button
        Button btnFetch = (Button)findViewById(R.id.btnFetch);
        btnFetch.setOnClickListener(new btnFetchHandler());
    }

    public class btnFetchHandler implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "You Clicked me!", Toast.LENGTH_SHORT).show();
        }
    }
}
