package bit.dickaj1.welcometodunedinapp;

import android.graphics.drawable.Drawable;

/**
 * Created by Arron on 1/04/2016.
 */
public class ActivitiesListItem {
    Drawable imageIcon;
    String name;

    public ActivitiesListItem(String name, Drawable imageIcon){
        this.imageIcon=imageIcon;
        this.name=name;
    }

    @Override
    public String toString(){
        return name;
    }
}
