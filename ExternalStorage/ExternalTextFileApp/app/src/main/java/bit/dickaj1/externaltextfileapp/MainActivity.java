package bit.dickaj1.externaltextfileapp;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up button handler
        setUpButton();
    }

    /**
     * Sets up handlers for buttons
     */
    private void setUpButton() {
        //Grab reference to button
        Button btnFill = (Button) findViewById(R.id.btnFill);
        //Set onclick handler
        btnFill.setOnClickListener(new btnFillHandler());
    }

    /**
     * On click handler for btnFill
     */
    public class btnFillHandler implements Button.OnClickListener {

        @Override
        public void onClick(View v) {
            //Holds data
            ArrayList<String> data;
            //Fetch data
            data = getList();
            //Display on screen
            displayList(data);
        }
    }

    /**
     * Put the provided data into a list
     *
     * @param data ArrayList of data to display
     */
    private void displayList(ArrayList<String> data) {
        //Grab reference to the listView
        ListView lvCities=(ListView)findViewById(R.id.lvCities);

        //Create the adapter
        ArrayAdapter<String> citiesAdapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,data);

        //Set adapter
        lvCities.setAdapter(citiesAdapter);
    }

    /**
     * Grabs data from asset
     *
     * @return ArrayList of data to place in list
     */
    private ArrayList<String> getList() {
        //Hold data to return
        ArrayList<String> data = new ArrayList<>();

        //Name of asset
        String filename = "city_names.txt";

        //Get Asset manager
        AssetManager am = getAssets();

        //Hold a line of input
        String line;

        try {
            InputStream is = am.open(filename);
            InputStreamReader ir = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(ir);

            while ((line = br.readLine()) != null) {
                data.add(line);
            }

            br.close();
        } catch (IOException e) {
            //TODO Throw a fit?
        }
        return data;
    }
}