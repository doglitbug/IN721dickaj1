package bit.dickaj1.languagetrainerapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Arron on 26/03/2016.
 */
public class QuestionManager {
    //List of questions
    private List<Question> questionList;
    //Current question number
    private int currentQuestion;
    //Number of correct answers so far
    private int correctSoFar;

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
    private void reset(){
        currentQuestion=correctSoFar=0;
        shuffle();
    }

    /**
     * Shuffles the questions
     */
    private void shuffle(){
        //Collections.shuffle(questionList);
        Random rnd=new Random();

        for (int i=0;i<100;i++){
            //Choose positions to swap randomly
            int position1=rnd.nextInt(questionList.size());;
            int position2=rnd.nextInt(questionList.size());
            //Swap the elements
            Question temp=questionList.get(position1);
            questionList.set(position1,questionList.get(position2));
            questionList.set(position2,temp);
        }
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
        //nextQuestion shouldn't get called by parent activity if it is...
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

    /**
     * How many questions have ben answered correctly
     * @return correctly answer questions
     */
    public int getCorrectSoFar(){
        return correctSoFar;
    }

    /**
     * How many questions is there is total
     * @return Total number of questions
     */
    public int getTotalQuestions(){
        return questionList.size();
    }
}

