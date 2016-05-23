package bit.dickaj1.teleporterplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up button handler for teleport button
        setupButtons();
    }

    private void setupButtons(){
        Button btnTeleport = (Button)findViewById(R.id.btnTeleport);
        //Set onClick listener
    }

    private class btnTeleportHandler implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            //TODO Get current GPS co-ords

            //TODO Create map object using Google Maps API

            //TODO Show on screen
        }
    }
}
