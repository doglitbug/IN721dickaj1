package bit.dickaj1.languagepreferenceapp;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prefs;
    SharedPreferences.Editor prefsEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up radio group handler to enable set button
        setUpRadioGroup();

        //Set up button handler
        setUpButton();

        //Set up preferences access and load last
        setUpPrefs();
    }

    /**
     * Sets up shared preferences and preferences editor
     * Loads previous preferences if found
     */
    private void setUpPrefs(){
        prefs=getSharedPreferences("prefsDemo",MODE_PRIVATE);
        prefsEditor=prefs.edit();

        //Check previous preference
        String language=prefs.getString("language",null);
        String color=prefs.getString("color",null);

        //TODO Issue if only one preference is set, or should that never happen?
        if (language!=null && color!=null){
            setWelcomeMessage(language,color);
        }

    }

    /**
     * Sets up an on check changed listener for the radiogroup
     * this is to enable the set button
     */
    private void setUpRadioGroup(){
        //Get reference to radiogroup
        RadioGroup rgLanguage=(RadioGroup)findViewById(R.id.rgLanguage);
        //Set onclick handler
        rgLanguage.setOnCheckedChangeListener(new rgLanguageHandler());
    }

    /**
     * Handler for radio group language
     */
    public class rgLanguageHandler implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            //Get reference to button
            Button btnSet=(Button)findViewById(R.id.btnSet);
            //Set enabled
            btnSet.setEnabled(true);
        }
    }

    /**
     * Sets up an onclick handler for the set button
     */
    private void setUpButton() {
        //Get reference to button
        Button btnSet = (Button) findViewById(R.id.btnSet);
        //Set onclick handler
        btnSet.setOnClickListener(new btnSetHandler());
    }

    /**
     * Handler for the set button
     */
    public class btnSetHandler implements Button.OnClickListener{
        @Override
        public void onClick(View v) {
            //Get language
            String language=getSelectedLanguage();
            //Set preference
            prefsEditor.putString("language",language);
            prefsEditor.commit();
            //Set message
            setWelcomeMessage(language);
        }
    }

    /**
     * Sets the welcome message
     * @param language Language to use
     * @param color Color to set
     */
    private void setWelcomeMessage(String language, String color){
        //Get reference to textview
        TextView tvWelcome=(TextView)findViewById(R.id.tvWelcome);
        //Get resources
        Resources res=getResources();
        String message="";
        int colorToSet=0;

        //TODO refactor so that a switch isn't used
        //Would require usage of string array, and pref being stored as a number and rb being
        //dynamically populated. Sigh
        switch(language){
            case "French":
                message=res.getString(R.string.greeting1);
                break;
            case "German":
                message=res.getString(R.string.greeting2);
                break;
            case "Spanish":
                message=res.getString(R.string.greeting3);
                break;
            default:
                break;
        }
        //Set message
        tvWelcome.setText(message);

        switch(color){
            case "Red":
                colorToSet=Color.rgb(255,0,0);
                break;
            case "Blue":
                colorToSet=Color.rgb(0,0,255);
                break;
            case "Green":
                colorToSet=Color.rgb(0,255,0);
                break;
            default:
                break;
        }
        //Set color on the text welcome
        tvWelcome.setTextColor(colorToSet);
    }

    /**
     * Look at the radiogroup and find selected language
     * @return String of selected language
     */
    private String getSelectedLanguage(){
        //TODO check for unselected?
        //Get radiogroup
       RadioGroup rgLanguage=(RadioGroup)findViewById(R.id.rgLanguage);
        //Get selected index
        int rbIndex=rgLanguage.getCheckedRadioButtonId();
        //Get the selected radio button
        RadioButton rbButton=(RadioButton)findViewById(rbIndex);
        //Get the string and return
        return rbButton.getText().toString();
    }
}