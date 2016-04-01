package bit.dickaj1.welcometodunedinapp;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivitiesActivity extends AppCompatActivity {

    ActivitiesListItem[] activitiesArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);

        initialiseDataArray();
    }

    private void initialiseDataArray(){
        //Get Resources
        Resources res = getResources();
        //Get images
        Drawable larnach=res.getDrawable(R.drawable.ic_larnach_castle,null);
        Drawable moana=res.getDrawable(R.drawable.ic_moana_pool,null);
        Drawable monarch=res.getDrawable(R.drawable.ic_monarch,null);
        Drawable octagon=res.getDrawable(R.drawable.ic_octagon,null);
        Drawable olveston=res.getDrawable(R.drawable.ic_olveston,null);
        Drawable op=res.getDrawable(R.drawable.ic_op,null);
        Drawable peninsula=res.getDrawable(R.drawable.ic_peninsula,null);
        Drawable salt_water=res.getDrawable(R.drawable.ic_salt_water_pool,null);
        Drawable speights=res.getDrawable(R.drawable.ic_speights_brewery,null);
        Drawable st_kilda=res.getDrawable(R.drawable.ic_st_kilda_beach,null);
        Drawable taeri_gorge=res.getDrawable(R.drawable.ic_taeri_gorge_railway,null);

        //initialise the data array
        activitiesArray=new ActivitiesListItem[11];
        activitiesArray[0]=new ActivitiesListItem("Larnach Castle",larnach);
        activitiesArray[1]=new ActivitiesListItem("Moana Pool",moana);
        activitiesArray[2]=new ActivitiesListItem("Monarch Cruise",monarch);
        activitiesArray[3]=new ActivitiesListItem("Octagon",octagon);
        activitiesArray[4]=new ActivitiesListItem("Olveston",olveston);
        activitiesArray[5]=new ActivitiesListItem("Otago Polytechnic",op);
        activitiesArray[6]=new ActivitiesListItem("Peninsula",peninsula);
        activitiesArray[7]=new ActivitiesListItem("Salt Water Pool",salt_water);
        activitiesArray[8]=new ActivitiesListItem("Speights Brewery",speights);
        activitiesArray[9]=new ActivitiesListItem("St Kilda Beach",st_kilda);
        activitiesArray[10]=new ActivitiesListItem("Taeri Gorge Railway",taeri_gorge);
    }
}
