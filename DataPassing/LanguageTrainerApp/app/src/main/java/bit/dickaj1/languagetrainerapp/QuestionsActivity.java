package bit.dickaj1.languagetrainerapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class QuestionsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        //TODO check intent to see if this is the start of question time or in the middle of such
        //TODO retrieve question manager

        //TODO Move to a select new question method
        showAnswersFragment();
        ImageView temp=(ImageView)findViewById(R.id.imageViewQuestion);
        temp.setImageResource(R.drawable.das_auto);
    }

    /**
     * Show the selectable answer fragment
     */
    private void showAnswersFragment() {
        //TODO read these from the question manager
        String correctAnswer="";
        //Create fragment and fragment manager
        Fragment dynamicFragment = new AnswersFragment();
        FragmentManager fm = getFragmentManager();
        //Start transaction
        FragmentTransaction ft = fm.beginTransaction();
        //Replace placeholder
        ft.replace(R.id.fragment_answer_result, dynamicFragment);
        //Confirm
        ft.commit();
    }

    /**
     * Show the result fragment
     */
    private void showResultFragment(){
        //TODO Check anwser etc and pass the required data to this fragment before showing

        //Create fragment and fragment manager
        Fragment dynamicFragment = new ResultFragment();
        FragmentManager fm = getFragmentManager();
        //Start transaction
        FragmentTransaction ft = fm.beginTransaction();
        //Replace placeholder
        ft.replace(R.id.fragment_answer_result, dynamicFragment);
        //Confirm
        ft.commit();
    }


    /**
     * Receive an answer from the answer fragment
     * @param answer
     */
    public void receiveAnswer(int answer) {
        //TODO finish method

        //TODO Check answer against question and show result fragment

        Log.i("ABC:QuestionActivity", "Received answer number: " + answer);

        showResultFragment();
    }

    /**
     * Deal with user selecting continue on result fragment
     */
    public void continueSelected(){
        //TODO deal with using selected continue on result fragment
        //ie next question or go to game over screen
        Log.i("ABC:QuestionActivity","User selected continue");

        showAnswersFragment();
    }
}