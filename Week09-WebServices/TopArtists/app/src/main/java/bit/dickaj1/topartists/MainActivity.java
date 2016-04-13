package bit.dickaj1.topartists;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
            } catch (IOException e){
                //TODO Deal with IO exception
            }
            return JSONString;
        }

        @Override
        protected void onPostExecute(String fetchedString){
            //TODO Check fetchedString is not null?

            //TODO Put in the list view

            Toast.makeText(MainActivity.this, fetchedString, Toast.LENGTH_SHORT).show();
            Log.d("ABC123", "onPostExecute: "+fetchedString);
        }
    }
}
