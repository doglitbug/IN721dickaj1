package bit.dickaj1.teleporter;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
            Location testLocation = getCoords();

            //Get geoplugin data
            AsyncGetLocationData thread=new AsyncGetLocationData();
            thread.execute(testLocation);

            //Get an image
            AsyncSearchFlickrWithCityName thread2 = new AsyncSearchFlickrWithCityName();
            //Get city name
            //TODO recode this, as it is pretty hacky...
            TextView tvClosestCity=(TextView)findViewById(R.id.tvClosestCity);
            String cityName=tvClosestCity.getText().toString();

            thread2.execute(cityName);
        }
    }

    /**
     * Updates the screen to show the current location and city name
     *
     * @param newLocation Location to show
     * @param cityName Name of the city to show
     */
    private void updateLocationCoords(Location newLocation,String cityName) {
        //Get references
        TextView latitude = (TextView) findViewById(R.id.tvLatitude);
        TextView longitude = (TextView) findViewById(R.id.tvLongitude);
        TextView tvClosestCity=(TextView)findViewById(R.id.tvClosestCity);

        //Set text
        latitude.setText(String.format("%.3f", newLocation.getLatitude()));
        longitude.setText(String.format("%.3f", newLocation.getLongitude()));
        tvClosestCity.setText(cityName);
    }

    /**
     * Gets/generates a location
     *
     * @return Location requested
     */
    private Location getCoords() {
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
    public class AsyncGetLocationData extends AsyncTask<Location, Integer, String> {
        //Create progressDialog
        ProgressDialog pDialog = new ProgressDialog(MainActivity.this);

        @Override
        protected void onPreExecute(){
            //Set up dialog
            pDialog.setMessage(getString(R.string.dialog_title));
            pDialog.show();
        }
        @Override
        protected String doInBackground(Location... params) {
            //Hold location to check
            Location toCheck=params[0];
            //Hold result
            String JSONString="[[]]";
            //Hold number of locations checked
            int locationsChecked=0;

            do{
                //Create url string
                String urlString = "http://www.geoplugin.net/extras/location.gp?lat=" + toCheck.getLatitude() +
                        "&long=" + toCheck.getLongitude() +
                        "&format=json";
                //Increment number of locations checked
                locationsChecked++;

                //Let user know that app hasn't hung
                publishProgress(locationsChecked);

                try {
                    //Convert string to URL object
                    URL URLObject = new URL(urlString);
                    //Create HttpUrlConnection
                    HttpURLConnection con = (HttpURLConnection) URLObject.openConnection();
                    //Send the URL
                    con.connect();
                    //If it doesn't return 200, you don't have data
                    int response = con.getResponseCode();
                    //TODO Do something if response isn't 200
                    //Get an inputstream and set up a reader etc
                    InputStream is = con.getInputStream();
                    InputStreamReader ir = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(ir);
                    //Read input
                    String responseString;
                    StringBuilder sb = new StringBuilder();
                    while ((responseString = br.readLine()) != null) {
                        sb = sb.append(responseString);
                    }
                    JSONString = sb.toString();
                } catch (MalformedURLException e) {
                    //TODO Deal with malformed URL
                    e.printStackTrace();
                } catch (IOException e) {
                    //TODO Deal with IO exception
                    e.printStackTrace();

                }
                //Get a new location to check next loop
                toCheck=getCoords();
                //TODO Replace [[]] with a constant...
            }while(JSONString.equals("[[]]"));

            return JSONString;
        }

        protected void onProgressUpdate(Integer... locationsChecked){
            //Build message to show
            String message=String.format(getString(R.string.dialog_message),locationsChecked[0],locationsChecked[0]==1?"":"s");
            //Show message
            pDialog.setMessage(message);
        }

        @Override
        protected void onPostExecute(String fetchedString){
            //Dismiss progress dialog
            pDialog.dismiss();
            //Deal with results
            decodeJSON(fetchedString);
        }
    }

    /**
     * Decodes a JSON string from geoplugin and update form
     * @param input Downloaded JSON string
     */
    public void decodeJSON(String input){
        //Hold data to return
        String cityName;

        try {
            //Get the JSON object
            JSONObject allData=new JSONObject(input);
            //Get the name of the city
            cityName=allData.getString("geoplugin_place");
            //Get location data
            Double latitude=allData.getDouble("geoplugin_latitude");
            Double longitude=allData.getDouble("geoplugin_longitude");

            //Create new location
            Location newLocation=new Location("Randomization");
            newLocation.setLatitude(latitude);
            newLocation.setLongitude(longitude);

            //Update on form
            updateLocationCoords(newLocation,cityName);

        } catch (JSONException e) {
            //TODO Deal with gracefully
            e.printStackTrace();
        }
    }

    //////////// Methods to produce an image from a city name
    public class AsyncSearchFlickrWithCityName extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... params) {
            //Hold name of city to search for
            String cityName = params[0];
            //Hold results
            String JSONString = "";
            Bitmap theImage=null;

            //Create request string
            String urlString = "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=" + getString(R.string.flickr_apikey) +
                    "&tags=" + cityName +
                    "&format=json&nojsoncallback=1";

            try {
                //Convert string to URL object
                URL URLObject = new URL(urlString);
                //Create HttpUrlConnection
                HttpURLConnection con = (HttpURLConnection) URLObject.openConnection();
                //Send the URL
                con.connect();
                //If it doesn't return 200, you don't have data
                int response = con.getResponseCode();
                //TODO Do something if response isn't 200
                if (response!=200) {
                    Log.i("ABC123", "doInBackground(Search Flickr): responseCode: " + response);
                    return null;
                }
                //Get an inputstream and set up a reader etc
                InputStream is = con.getInputStream();
                InputStreamReader ir = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(ir);
                //Read input
                String responseString;
                StringBuilder sb = new StringBuilder();
                while ((responseString = br.readLine()) != null) {
                    sb = sb.append(responseString);
                }
                JSONString = sb.toString();
            } catch (MalformedURLException e) {
                //TODO Deal with malformed URL
                e.printStackTrace();
            } catch (IOException e) {
                //TODO Deal with IO exception
                e.printStackTrace();

            }

            //Decode JSON string and form image URL
            URL downloadedImage=decodeJSONForImage(JSONString);

            //Download image
            if (downloadedImage!=null) {
                theImage = downloadBitmap(downloadedImage);
            }
            return theImage;
        }

        @Override
        protected void onPostExecute(Bitmap theImage) {
            //Get reference to imageView
            ImageView ivClosestCity = (ImageView) findViewById(R.id.ivClosestCity);

            //Check we actually got something
            if (theImage != null) {
                ivClosestCity.setImageBitmap(theImage);
            }
        }
    }

    /**
     * Turns JSON string into an image URL
     * @param fetchedString JSON string
     * @return image URL
     */
    private URL decodeJSONForImage(String fetchedString) {
        URL imageURL = null;
        try {
            Log.i("ABC123", "decodeJSONForImage: " + fetchedString);
            //Get the JSON object
            JSONObject allData = new JSONObject(fetchedString);
            //Get the photo object
            JSONObject photos = allData.getJSONObject("photos");
            //Get the photo array
            JSONArray photoArray = photos.getJSONArray("photo");
            //TODO Look through a few photos and choose one that is actually of the city?

            //Get a photo object
            JSONObject currentPhoto = photoArray.getJSONObject(0);
            //Get required data
            String farmID = currentPhoto.getString("farm");
            String serverID = currentPhoto.getString("server");
            String photoID = currentPhoto.getString("id");
            String secret = currentPhoto.getString("secret");
            //TODO Place this in string.xml or choose filesize dependant on device size?
            String size = "m";

            // Build image URL
            String imageString = String.format(getString(R.string.flickr_imageString), farmID, serverID, photoID, secret, size);
            imageURL = new URL(imageString);

        } catch (JSONException e) {
            //TODO Deal with gracefully
            e.printStackTrace();
        } catch (MalformedURLException e) {
            //TODO Deal with this gracefully
            e.printStackTrace();
        }

        return imageURL;
    }
    /**
     * Download an image from a given URL
     * @param imageURL
     * @return Bitmap of requested image
     */
    public Bitmap downloadBitmap(URL imageURL) {
        //Hold downloaded image
        Bitmap output=null;

        try {
            //Get the URL we want
            URL URLObject = imageURL;

            //Create HttpUrlConnection
            HttpURLConnection con = (HttpURLConnection) URLObject.openConnection();
            //Send the URL
            con.connect();
            //If it doesn't return 200, you don't have data
            int response=con.getResponseCode();
            //TODO Do something if response isn't 200
            if (response==200) {
                output = BitmapFactory.decodeStream(con.getInputStream());
            } else {
                //TODO ???
                Log.i("ABC123", "downloadBitmap: response code: "+response);
                return null;
            }
        } catch (MalformedURLException e){
            //TODO Deal with malformed URL
            e.printStackTrace();
        } catch (IOException e){
            //TODO Deal with IO exception
            e.printStackTrace();
        }
        return output;
    }
}