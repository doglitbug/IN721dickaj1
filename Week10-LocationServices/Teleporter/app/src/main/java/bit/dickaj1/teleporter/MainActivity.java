package bit.dickaj1.teleporter;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up button handlers
        setUpButtons();
    }

    /**
     * Sets up the on click handler for button(s)
     */
    private void setUpButtons(){
    //Get reference to button
    Button btnTeleport=(Button)findViewById(R.id.btnTeleport);

    //Set onclick handler
    btnTeleport.setOnClickListener(new btnTeleportHandler());
}

    private class btnTeleportHandler implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //Get a new location
            Location test=getLocation();

            //Set on form
            updateLocation(test);
        }
    }

    /**
     * Updates the screen to show the current location
     * @param newLocation Location to show
     */
    private void updateLocation(Location newLocation){
        //Get references
        TextView latitude=(TextView)findViewById(R.id.tvLatitude);
        TextView longitude=(TextView)findViewById(R.id.tvLongitude);
        //Set text
        latitude.setText(String.format("%.3f",newLocation.getLatitude()));
        longitude.setText(String.format("%.3f",newLocation.getLongitude()));
    }
    /**
     * Gets/generates a location
     * @return Location requested
     */
    private Location getLocation() {
        Location output = new Location("Randomization");
        Random rng = new Random();
        output.setLatitude(rng.nextDouble() * 180 - 90);
        output.setLongitude(rng.nextDouble() * 360 - 180);

        return output;
    }
}