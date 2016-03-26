package bit.dickaj1.languagetrainerapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class QuestionsActivity extends AppCompatActivity{
private QuestionManager questionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        //Create questionManager
        questionManager=new QuestionManager(getApplicationContext());

        showAnswersFragment();
    }

    /**
     * Show the selectable answer fragment
     */
    private void showAnswersFragment() {
        //Get data from the questionManager
        Question currentQuestion=questionManager.getCurrentQuestion();
        int imageId=currentQuestion.imageId;

        //Set image
        ImageView image=(ImageView)findViewById(R.id.imageViewQuestion);
        image.setImageResource(imageId);

        //TODO


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
        //TODO Check answer etc and pass the required data to this fragment before showing

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
    public void receiveAnswer(String answer) {
        //TODO finish method

        //TODO Check answer against question and show result fragment
        switch(questionManager.getCurrentQuestion().article){

        }
        Log.i("ABC:QuestionActivity", "Received answer number: " + answer);
        //TODO check for end of questions
        questionManager.nextQuestion();
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