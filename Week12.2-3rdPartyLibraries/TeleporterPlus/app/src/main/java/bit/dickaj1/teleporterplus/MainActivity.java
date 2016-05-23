package bit.dickaj1.teleporterplus;

import android.location.Location;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.maps.model.LatLng;


import java.util.Random;

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
        btnTeleport.setOnClickListener(new btnTeleportHandler());
    }

    private class btnTeleportHandler implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            //TODO Get current GPS co-ords
            LatLng testLocation = getCoords();
            //TODO Create map object using Google Maps API

            //TODO Show on screen
        }
    }


    private void explodeMapFragment(LatLng location){
ShowMapFragment smf = new ShowMapFragment()
    }
    /**
     * Gets/generates a LatLng
     *
     * @return Location requested
     */
    private LatLng getCoords() {
        Random rng = new Random();
        //Generate a random latitude between -90 and +90
        double latitude =rng.nextDouble() * 180 - 90;
        //Generate a random longitude between -180 and +180
        double longitude =rng.nextDouble() * 360 - 180;

        //Construct new LatLng object to return
        LatLng output = new LatLng(latitude, longitude);
        return output;
    }
}