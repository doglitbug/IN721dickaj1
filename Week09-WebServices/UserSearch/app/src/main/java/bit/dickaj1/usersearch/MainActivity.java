package bit.dickaj1.usersearch;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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

        //Set up button handler
        Button btnSearch = (Button)findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new btnSearchHandler());
    }

    /**
     * Button Search handler
     */
    public class btnSearchHandler implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            //Get search string
            EditText editSearch=(EditText)findViewById(R.id.editSearch);
            String searchString=editSearch.getText().toString();
            //Check user entered something to search for
            if (searchString.length()!=0) {
                //TODO Do nothing if empty(no point bothering the service!)
                AsyncGetSimilarArtists thread = new AsyncGetSimilarArtists();
                thread.execute(searchString);
            } else {
                Toast.makeText(MainActivity.this, "Please enter an artist to search for", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * Async task to download similar artists from last.fm
     */
    public class AsyncGetSimilarArtists extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... params) {
            //Hold result
            String JSONString=null;
            //Grab api key
            Resources res=getResources();
            String api_key=res.getString(R.string.api_key);
            //Create string
            String urlString="http://ws.audioscrobbler.com/2.0/?"+
                    "method=artist.getsimilar&"+
                    "limit=10&"+
                    "artist="+params[0]+"&"+
                    "api_key="+api_key+"&format=json";
            Log.d("ABC123", "doInBackground: "+urlString);
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

    public ArrayList<String> decodeJSON(String input){
        //Hold data to return
        //TODO
        Log.d("ABC123", "decodeJSON: "+input);
        return null;
    }

    /**
     * Populates the listView
     * @param input ArrayList of artists to use
     */
    public void fillListView(ArrayList<String> input){
        //Grab reference to listView
        ListView lvResults = (ListView)findViewById(R.id.lvResults);
        //Create the adapter
        ArrayAdapter<String> similarArtistsAdapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,input);
        //Bind the adapter
        //lvResults.setAdapter(similarArtistsAdapter);
    }
}