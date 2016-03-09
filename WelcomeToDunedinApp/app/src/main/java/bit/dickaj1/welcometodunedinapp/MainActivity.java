package bit.dickaj1.welcometodunedinapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Populate listViewCategories and set handler
        setUpListViewCategories();
    }

    /**
     * Sets up the listView with the pages that can be selected
     * and sets on click handler
     */
    private void setUpListViewCategories(){
        //Get reference to listViewCategories
        ListView listViewCategories=(ListView)findViewById(R.id.listViewCategories);

        //Get list of categories for res
        Resources res=getResources();
        String categories[] = res.getStringArray(R.array.categories);

        //Get a layout
        int layoutID=R.layout.categories_layout;

        //Create the adapter
        ArrayAdapter<String>categoriesAdapter=new ArrayAdapter<String>(this,layoutID,categories);
        //Set adapter
        listViewCategories.setAdapter(categoriesAdapter);

        //Set up handler
        listViewCategories.setOnItemClickListener(new listViewCategoriesHandler());
    }

    /**
     * Sets up the onClick handler for the listView
     */
    public class listViewCategoriesHandler implements ListView.OnItemClickListener{


        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Find out which category was clicked
            String clickedItemString=(String)parent.getItemAtPosition(position).toString();
            //Output as toast
            Toast.makeText(MainActivity.this, clickedItemString, Toast.LENGTH_LONG).show();

            //Find the next activity based off the clicked item
            //Build correct name of activity
            clickedItemString="activity_"+clickedItemString.toLowerCase();
            Class<?> nextActivity=null;
            try {
                nextActivity = Class.forName(clickedItemString);
            } catch(ClassNotFoundException e){
                //TODO Handle this gracefully
                e.printStackTrace();
            }

            //Create new intent and transfer control
            Intent newIntent=new Intent(MainActivity.this,nextActivity);
            startActivity(newIntent);
        }
    }
}
