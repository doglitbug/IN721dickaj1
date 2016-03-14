package bit.dickaj1.fragmentsintro;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_landscape);

        //Set up button handlers
        setUpButtonHandlers();
    }

    private void setUpButtonHandlers(){
        //Grab handle of buttons
        Button btnShowImageView=(Button)findViewById(R.id.btnShowImageView);
        Button btnShowListView=(Button)findViewById(R.id.btnShowListView);
        //Set event handler
        btnShowImageView.setOnClickListener(new btnShowImageViewHandler());
        btnShowListView.setOnClickListener(new btnShowListViewHandler());
    }

    private class btnShowImageViewHandler implements View.OnClickListener{
        @Override
        public void onClick(View v){
            //Show Image view fragment
            //Create fragment and fragment manager
            Fragment dynamicFragment = new ShowImageFragment();
            FragmentManager fm=getFragmentManager();
            //Start transaction
            FragmentTransaction ft=fm.beginTransaction();
            //Replace placeholder
            ft.replace(R.id.fragment_container1,dynamicFragment);
            //Confirm
            ft.commit();
        }
    }

    private class btnShowListViewHandler implements View.OnClickListener{
        @Override
        public void onClick(View v){
            //Show Image view fragment
            //Create fragment and fragment manager
            Fragment dynamicFragment = new ShowListViewFragment();
            FragmentManager fm=getFragmentManager();
            //Start transaction
            FragmentTransaction ft=fm.beginTransaction();
            //Replace placeholder
            ft.replace(R.id.fragment_container2,dynamicFragment);
            //Confirm
            ft.commit();
        }
    }
}
