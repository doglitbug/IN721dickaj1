package bit.dickaj1.topartistandimage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up button
        Button btnFetch = (Button) findViewById(R.id.btnFetch);
        btnFetch.setOnClickListener(new btnFetchHandler());
    }

    public class btnFetchHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //Call method to grab JSON, decode, and get image/display
            getArtistImageURL thread = new getArtistImageURL();
            thread.execute();
        }
    }

    public class getArtistImageURL extends AsyncTask<Void, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(Void... params) {
            //Hold result
            Bitmap output = null;
            //Grab api key
            Resources res = getResources();
            String api_key = res.getString(R.string.api_key);
            //Create string
            String urlString = "http://ws.audioscrobbler.com/2.0/?" +
                    "method=chart.gettopartists&" +
                    "limit=1&format=json&" +
                    "api_key=" + api_key;
            //Hold data from first connectiong
            String fetchedString="";
            /////////////// Get the info on the artist ////////////////
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
                //TODO Deal with error codes from api???
                fetchedString = sb.toString();
            } catch (MalformedURLException e) {
                //TODO Deal with malformed URL
                e.printStackTrace();
            } catch (IOException e) {
                //TODO Deal with IO exception
                e.printStackTrace();
            }


            URL imageURL = decodeJSONandGetImageURL(fetchedString);

            Log.d("ABC123", "onPostExecute: "+imageURL.toString());

            //Get image
            output=downloadBitmap(imageURL);


            return output;
        }

        @Override
        protected void onPostExecute(Bitmap fetchedImage) {
            //Get reference to imageView
            ImageView ivArtist = (ImageView) findViewById(R.id.ivArtist);
            //Set image
            ivArtist.setImageBitmap(fetchedImage);
        }
    }

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

            output= BitmapFactory.decodeStream(con.getInputStream());

        } catch (MalformedURLException e){
            //TODO Deal with malformed URL
            e.printStackTrace();
        } catch (IOException e){
            //TODO Deal with IO exception
            e.printStackTrace();
        }
        return output;
    }

    /**
     * Decodes a JSON string in required artist information
     *
     * @param input JSON String
     * @return URL of the image
     */
    public URL decodeJSONandGetImageURL(String input) {
        //Hold data to return
        URL output = null;
        try {
            //Get the JSON Object
            JSONObject allData = new JSONObject(input);
            //Get the artists object
            JSONObject artistsObject = allData.getJSONObject("artists");
            //Get the array of artists
            JSONArray artistsArray = artistsObject.getJSONArray("artist");
            //Get the first artist(the top artist)
            JSONObject topArtist = artistsArray.getJSONObject(0);
            //Get the image array
            JSONArray artistImages = topArtist.getJSONArray("image");
            //Get the first image object
            //TODO Check this is the correct size, eg "small"
            JSONObject artistImage = artistImages.getJSONObject(0);

            String imageURL = artistImage.getString("#text");

            //Add a new artist to the arrayList
            output = new URL(imageURL);

        } catch (JSONException e) {
            //TODO Deal with mal formed JSON gracefully
            e.printStackTrace();
        } catch (MalformedURLException e) {
            //TODO Deal with this error gracefully
            e.printStackTrace();
        }
        return output;
    }
}
