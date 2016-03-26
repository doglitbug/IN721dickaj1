package bit.dickaj1.languagetrainerapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Arron on 26/03/2016.
 */
public class QuestionManager {
    //List of questions
    List<Question> questionList;
    //Current question number
    int currentQuestion;
    //Number of correct answers so far
    int correctSoFar;

    /**
     * Constructor, creates questions and resets for a new game
     * @param parentContext context from parent activity so we can access Resources
     */
    public QuestionManager(Context parentContext){
        questionList=new ArrayList<>();
        //Load questions, not putting these in string.xml
        questionList.add(new Question("das","auto",parentContext));
        questionList.add(new Question("das","haus",parentContext));
        questionList.add(new Question("das","schaf",parentContext));
        questionList.add(new Question("der","apfel",parentContext));
        questionList.add(new Question("der","baum",parentContext));
        questionList.add(new Question("der","stuhl",parentContext));
        questionList.add(new Question("die","ente",parentContext));
        questionList.add(new Question("die","hexe",parentContext));
        questionList.add(new Question("die","kuh",parentContext));
        questionList.add(new Question("die","milch",parentContext));
        questionList.add(new Question("die","strasse",parentContext));

        reset();
    }

    /**
     * Sets current question number/correct to 0 and shuffles questions
     */
    public void reset(){
        currentQuestion=correctSoFar=0;
        shuffle();
    }

    /**
     * Shuffles the questions
     * Yes this is the lazy(?) way to do it...hehehe(K.I.S.S.)
     * TODO shuffle using loop of 100 and choose random place
     */
    private void shuffle(){
        Collections.shuffle(questionList);
    }

    /**
     * Increments to the next question and checks if there is any left
     * @return true if there is still questions left
     */
    public boolean nextQuestion(){
        currentQuestion++;
        //Check this is not the last question in the series
        return (currentQuestion<questionList.size());
    }

    /**
     * Get the current Question
     * @return current Question
     */
    public Question getCurrentQuestion(){
        //TODO Check out of bounds error?
        return questionList.get(currentQuestion);
    }

    /**
     * Checks if the supplied answer is correct and increments count of correct answers
     * @param answer Answer to check
     */
    public void checkAnswer(String answer){
        if (answer==getCurrentQuestion().article){
            correctSoFar++;
        }
    }
}

