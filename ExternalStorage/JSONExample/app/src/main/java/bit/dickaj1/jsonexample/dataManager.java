package bit.dickaj1.jsonexample;

import android.content.Context;
import android.content.res.AssetManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Arron on 8/04/2016.
 */
public class dataManager {
    //Used for access to getAssets
    Context localContext;

    public dataManager(Context context){
        localContext=context;
    }

    public ArrayList<myEvent> getEvents() {
        //Hold data to return
        ArrayList<myEvent> data = new ArrayList<>();

        //Get the JSONObject
        JSONObject readData = getJSONData();

        //Get the events array part
        //TODO Finish

        //TODO Remove stub data!
        data.add(new myEvent("Test name", "Test description"));
        data.add(new myEvent("Test name 1", "Test description 1"));
        data.add(new myEvent("Test name 2", "Test description 2"));
        return data;
    }

    /**
     * Reads the JSON Object from the asset file
     * In other application it might be from online
     * @return JSONObject
     */
    private JSONObject getJSONData(){
        String filename="city_data.json";
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
