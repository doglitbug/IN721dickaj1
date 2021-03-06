package bit.dickaj1.jsonexample;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Arron on 8/04/2016.
 */
public class dataManager {
    //Used for access to getAssets
    Context localContext;

    /**
     * Constructor
     * @param context from parent so that methods needed are available
     */
    public dataManager(Context context){
        localContext=context;
    }

    /**
     * Decode the JSON into an ArrayList of myEvent
     * @return ArrayList<myEvent></myEvent>
     */
    public ArrayList<myEvent> getEvents() {
        //Hold data to return
        ArrayList<myEvent> data = new ArrayList<>();

        try {
            //Get the JSONObject
            JSONObject allData = getJSONData();
            //Get the events object
            JSONObject eventsOb=allData.getJSONObject("events");
            //Get the event array
            JSONArray eventArray = eventsOb.getJSONArray("event");

            //Loop over it now
            int numberEvents=eventArray.length();

            for (int i=0;i<numberEvents;i++){
                //Get an element from the array
                JSONObject currentEvent=eventArray.getJSONObject(i);

                //Retrieve data and construct a myEvent
                String name=currentEvent.getString("title");
                String description=currentEvent.getString("description");

                data.add(new myEvent(name,description));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return data;
    }

    /**
     * Reads the JSON Object from the asset file
     * In other application it might be from online
     * @return JSONObject
     */
    private JSONObject getJSONData(){
        String filename="dunedin_events.json";
        JSONObject dunedinEvents = null;
        //Get asset manager
        AssetManager am=localContext.getAssets();
        try {
            //Create
            InputStream is=am.open(filename);
            int fileSize=is.available();
            byte[] JSONBuffer=new byte[fileSize];

            //Read the stream into the buffer
            is.read(JSONBuffer);
            is.close();

            //Create a string from the byteArray
            String JSONInput = new String(JSONBuffer);

            //Convert to a JSON object
            dunedinEvents = new JSONObject(JSONInput);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return dunedinEvents;
    }
}
