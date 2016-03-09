package bit.dickaj1.welcometodunedinapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Populate listViewMain
        setUpListViewCategories();

        //Create onClickHandler for listViewMain
    }

    private void setUpListViewCategories(){
        //Get list of categories
        Resources res=getResources();
        String pages[] = res.getStringArray(R.array.categories);

        //Get reference to listViewMain
        ListView listViewCategories=(ListView)findViewById(R.id.listViewCategories);
        //Get a layout
        int layoutID=R.layout.categories_layout;

        //Create the adapter
        ArrayAdapter<String>categoriesAdapter=new ArrayAdapter<String>(this,layoutID,pages);
        listViewCategories.setAdapter(categoriesAdapter);
    }
}
