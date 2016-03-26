package bit.dickaj1.languagetrainerapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
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
     * Get the current question, show image and set up answer fragment
     */
    private void showAnswersFragment() {
        //Get data from the questionManager
        Question currentQuestion=questionManager.getCurrentQuestion();
        int imageId=currentQuestion.imageId;
        //Set image
        ImageView image=(ImageView)findViewById(R.id.imageViewQuestion);
        image.setImageResource(imageId);

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
     * Show the result fragment with given data
     */
    private void showResultFragment(String answer, String expected){
        //Bundle up the data to pass to the fragment
        Bundle bundle=new Bundle();
        bundle.putString("answer",answer);
        bundle.putString("expected",expected);

        //Create fragment and fragment manager
        Fragment dynamicFragment = new ResultFragment();
        //Bundle in the data
        dynamicFragment.setArguments(bundle);
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
        //Get the expected answer
        String expected=questionManager.getCurrentQuestion().article;
        //Check if it was correct with the manager
        questionManager.checkAnswer(answer);
        //Pass on to the results fragment
        showResultFragment(answer, expected);
    }

    /**
     * Deal with user selecting continue on result fragment
     */
    public void continueSelected(){
        //If out of question go to finish screen or next question
        if (!questionManager.nextQuestion()){
            //Get number of correct questions
            int correctAnswers=questionManager.getCorrectSoFar();
            int totalQuestions=questionManager.getTotalQuestions();
            showFinishActivity(correctAnswers,totalQuestions);
        } else {
            showAnswersFragment();
        }
    }

    /**
     * Start up the finish activity and pass in the question data
     * @param correctAnswers number of correct answers
     * @param totalQuestions number of questions total
     */
    private void showFinishActivity(int correctAnswers,int totalQuestions){
        //Create Intent
        Intent finishIntent = new Intent(QuestionsActivity.this,FinishActivity.class);
        //Bundle in the data to show
        finishIntent.putExtra("correct",correctAnswers);
        finishIntent.putExtra("total",totalQuestions);

        //Show the finish activity
        startActivity(finishIntent);
    }
}