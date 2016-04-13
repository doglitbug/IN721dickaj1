package bit.dickaj1.topartists;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up button
        Button btnFill = (Button)findViewById(R.id.btnFill);
        btnFill.setOnClickListener(new btnFillHandler());
    }

    public class btnFillHandler implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            AsyncGetArtists thread = new AsyncGetArtists();
            thread.execute();
        }
    }

    public class AsyncGetArtists extends AsyncTask<Void,Void,String> {
        @Override
        protected String doInBackground(Void... params) {
            //Hold result
            String JSONString=null;
            //Grab api key
            Resources res=getResources();
            String api_key=res.getString(R.string.api_key);
            //Create string
            String urlString="http://ws.audioscrobbler.com/2.0/?"+
                                "method=chart.gettopartists&"+
                                "limit=20&format=json&"+
                                "api_key="+api_key;

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
                //TODO Deal with error codes from api???
                JSONString=sb.toString();
            } catch (MalformedURLException e){
                //TODO Deal with malformed URL
                e.printStackTrace();
            } catch (IOException e){
                //TODO Deal with IO exception
                e.printStackTrace();
            }
            return JSONString;
        }

        @Override
        protected void onPostExecute(String fetchedString){
            //Decode and show
            fillListView(decodeJSON(fetchedString));
        }
    }

    /**
     * Decodes a JSON string in required artist information
     * @param input JSON String
     * @return ArrayList of artists
     */
    public ArrayList<artist> decodeJSON(String input){
        //Hold data to return
        ArrayList<artist> output = new ArrayList<>();
        try {
            //Get the JSON Object
            JSONObject allData=new JSONObject(input);
            //Get the artists object
            JSONObject artistsObject = allData.getJSONObject("artists");
            //Get the array of artists
            JSONArray artistsArray=artistsObject.getJSONArray("artist");

            //Loop over it now
            int artistCount=artistsArray.length();
            for (int i = 0; i < artistCount; i++) {
                //Get an element from the array
                JSONObject currentArtist=artistsArray.getJSONObject(i);

                //Retrieve required data
                String artistName=currentArtist.getString("name");
                int listenerCount=currentArtist.getInt("listeners");

                //Add a new artist to the arrayList
                output.add(new artist(artistName,listenerCount));
            }
        } catch (JSONException e){
            //TODO Deal with mal formed JSON gracefully
            e.printStackTrace();
        }
        return output;
    }

    /**
     * Populates the listView
     * @param input ArrayList of artists to use
     */
    public void fillListView(ArrayList<artist> input){
        //Grab reference to listView
        ListView lvTopArtists = (ListView)findViewById(R.id.lvTopArtists);
        //Create the adapter
        ArtistArrayAdapter topArtistsAdapter=new ArtistArrayAdapter(this,R.layout.two_col_listview,input);
        //Bind the adapter
        lvTopArtists.setAdapter(topArtistsAdapter);
    }

    /**
     * Custom adapter for listView
     */
    public class ArtistArrayAdapter extends ArrayAdapter<artist>{
        public ArtistArrayAdapter(Context context, int resource,ArrayList<artist> objects){
            super(context,resource,objects);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup container){
            //Get an inflater from the activity
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            //Inflate our custom class
            //TODO find out why this resource is being directly referenced when the class constructor is passed the same thing
            View customView = inflater.inflate(R.layout.two_col_listview,container,false);

            //Grab references to the controls
            TextView tvArtist = (TextView)customView.findViewById(R.id.tvArtist);
            TextView tvListeners = (TextView)customView.findViewById(R.id.tvListeners);

            //Get current input item
            artist currentItem=getItem(position);

            //Use the data on the current item to fill the view
            tvArtist.setText(currentItem.toString());
            tvListeners.setText(String.valueOf(currentItem.getListeners()));

            //Return the newly built view
            return customView;
        }
    }
}
