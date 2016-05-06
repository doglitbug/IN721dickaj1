package bit.dickaj1.teleporter;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Debugging
        Location test=getLocation();
        Log.i("ABC123", "onCreate: "+test.toString());
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