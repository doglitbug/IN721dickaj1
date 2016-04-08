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

    //Preferences and editor, set here so global!
    SharedPreferences prefs;
    SharedPreferences.Editor prefsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up button handler
        setUpButton();

        //Set up preferences access and load previous settings
        setUpPrefs();
    }

    /**
     * Sets up shared preferences and preferences editor
     * Loads previous preferences if found
     */
    private void setUpPrefs() {
        prefs = getSharedPreferences("prefsDemo", MODE_PRIVATE);
        prefsEditor = prefs.edit();

        //Check previous preference
        String language = prefs.getString("language", null);
        String color = prefs.getString("color", null);

        //TODO Issue if only one preference is set, or should that never happen?
        if (language != null && color != null) {
            setWelcomeMessage(language, color);
        }

        //Set radio buttons to the previous settings
        //-----Language
        //Get radioGroup
        RadioGroup rgLanguage = (RadioGroup) findViewById(R.id.rgLanguage);

        //Loop through all Radio buttons
        for (int i = 0; i < rgLanguage.getChildCount(); i++) {
            //Get current RadioButton
            RadioButton rbButton = (RadioButton) rgLanguage.getChildAt(i);
            //Get the buttons string
            String currentRbText = rbButton.getText().toString();
            if (currentRbText.equals(language)) {
                rbButton.setChecked(true);
            }
        }


        //-----Color
        //Get radioGroup
        RadioGroup rgColor = (RadioGroup) findViewById(R.id.rgColor);

        //Loop through all Radio buttons
        for (int i = 0; i < rgColor.getChildCount(); i++) {
            //Get current RadioButton
            RadioButton rbButton = (RadioButton) rgColor.getChildAt(i);
            //Get the buttons string
            String currentRbText = rbButton.getText().toString();
            if (currentRbText.equals(color)) {
                rbButton.setChecked(true);
            }
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
            //Get color
            String color=getSelectedColor();
            //Set preference
            prefsEditor.putString("language",language);
            prefsEditor.putString("color",color);
            prefsEditor.commit();
            //Update message and color on screen to selected
            setWelcomeMessage(language,color);
        }
    }

    /**
     * Sets the welcome message and color
     * @param language Language to use
     * @param color Color to set
     */
    private void setWelcomeMessage(String language, String color){
        //Get reference to textView
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
            case "Green":
                colorToSet=Color.rgb(0,255,0);
                break;
            case "Blue":
                colorToSet=Color.rgb(0,0,255);
                break;
            default:
                break;
        }
        //Set color on the text welcome
        tvWelcome.setTextColor(colorToSet);
    }

    /**
     * Look at the radioGroup and find selected language
     * @return String of selected language
     */
    private String getSelectedLanguage(){
        //Get radioGroup
       RadioGroup rgLanguage=(RadioGroup)findViewById(R.id.rgLanguage);
        //Get selected index
        int rbIndex=rgLanguage.getCheckedRadioButtonId();
        //Get the selected radio button
        RadioButton rbButton=(RadioButton)findViewById(rbIndex);
        //Get the string and return
        return rbButton.getText().toString();
    }

    /**
     * Look at the radioGroup and find the selected color
     * @return String of the selected color
     */
    private String getSelectedColor(){
        //Get radioGroup
        RadioGroup rgColor=(RadioGroup)findViewById(R.id.rgColor);
        //Get selected index
        int rbIndex=rgColor.getCheckedRadioButtonId();
        //Get the selected radio button
        RadioButton rbButton=(RadioButton)findViewById(rbIndex);
        //Get the string and return
        return rbButton.getText().toString();
    }
}