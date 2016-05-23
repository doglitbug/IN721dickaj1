package bit.dickaj1.teleporterplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{
    private GoogleMap mMap;
    private LatLng location;

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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
        Log.i("ABC123", "onMapReady: ");
    }

    private class btnTeleportHandler implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            //Get current GPS co-ords
            location = getCoords();
            //Create map object using Google Maps API
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(MainActivity.this);
        }
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