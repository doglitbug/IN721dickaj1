package bit.dickaj1.languagetrainerapp;

import android.content.Context;
import android.content.res.Resources;

/**
 * Created by Arron on 26/03/2016.
 */
public class Question {
    //TODO accessors here
    public String noun;
    public String article;
    public int imageId;

    public Question(String article, String noun, Context parentContext){
        this.noun=noun;
        this.article=article;

        //Find image ID
        //Get resources
        Resources res=parentContext.getResources();
        //Get resource Id
        int resourceId=res.getIdentifier(article+"_"+noun,"drawable",parentContext.getPackageName());

        this.imageId=resourceId;
    }
}
