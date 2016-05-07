package bit.dickaj1.teleporter;

import android.location.Location;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
    private void setUpButtons() {
        //Get reference to button
        Button btnTeleport = (Button) findViewById(R.id.btnTeleport);

        //Set onclick handler
        btnTeleport.setOnClickListener(new btnTeleportHandler());
    }

    private class btnTeleportHandler implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            //Get a new location
            Location test = getLocation();

            //Set on form
            updateLocation(test);

            //Get geoplugin data
            AsyncGetLocationData thread=new AsyncGetLocationData();
            thread.execute(test);
        }
    }

    /**
     * Updates the screen to show the current location
     *
     * @param newLocation Location to show
     */
    private void updateLocation(Location newLocation) {
        //Get references
        TextView latitude = (TextView) findViewById(R.id.tvLatitude);
        TextView longitude = (TextView) findViewById(R.id.tvLongitude);
        //Set text
        latitude.setText(String.format("%.3f", newLocation.getLatitude()));
        longitude.setText(String.format("%.3f", newLocation.getLongitude()));
    }

    /**
     * Gets/generates a location
     *
     * @return Location requested
     */
    private Location getLocation() {
        Location output = new Location("Randomization");
        Random rng = new Random();
        //Generate a random latitude between -90 and +90
        output.setLatitude(rng.nextDouble() * 180 - 90);
        //Generate a random longitude between -180 and +180
        output.setLongitude(rng.nextDouble() * 360 - 180);

        return output;
    }

    /**
     * Downloads data from geoplugin.net
     */
    public class AsyncGetLocationData extends AsyncTask<Location, Void, String> {

        @Override
        protected String doInBackground(Location... params) {
            //TODO Check Location is valid?

            //Hold result
            String JSONString=null;

            //Create url string
            String urlString = "http://www.geoplugin.net/extras/location.gp?lat="+params[0].getLatitude()+
                    "&long="+params[0].getLongitude()+
                    "&format=json";
            try {
                //Convert string to URL object
                URL URLObject = new URL(urlString);
                //Create HttpUrlConnection
                HttpURLConnection con = (HttpURLConnection) URLObject.openConnection();
                //Send the URL
                con.connect();
                //If it doesn't return 200, you don't have data
                int response=con.getResponseCode();
                //TODO Do something if response isn't 200
                //Get an inputstream and set up a reader etc
                InputStream is=con.getInputStream();
                InputStreamReader ir=new InputStreamReader(is);
                BufferedReader br=new BufferedReader(ir);
                //Read input
                String responseString;
                StringBuilder sb=new StringBuilder();
                while((responseString=br.readLine())!=null){
                    sb=sb.append(responseString);
                }
                JSONString=sb.toString();
            } catch (MalformedURLException e){
                //TODO Deal with malformed URL
                e.printStackTrace();
            } catch (IOException e){
                //TODO Deal with IO exception
                e.printStackTrace();

            }
            Log.i("ABC123", "doInBackground: JSONString:"+JSONString);
            return JSONString;
        }
    }
}