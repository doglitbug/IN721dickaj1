package bit.dickaj1.languagetrainerapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        //TODO check intent to see if this is the start of question time or in the middle of such
        //TODO retrieve question manager



        //TODO Load an image

        
        showAnswersFragment();

    }

    private void showAnswersFragment(){
        //Create fragment and fragment manager
        Fragment dynamicFragment = new AnswersFragment();
        FragmentManager fm=getFragmentManager();
        //Start transaction
        FragmentTransaction ft=fm.beginTransaction();
        //Replace placeholder
        ft.replace(R.id.fragment_answer_result,dynamicFragment);
        //Confirm
        ft.commit();
    }

    //TODO get the answer selected here? like in the pizza dialog
}