package bit.dickaj1.languagetrainerapp;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class ResultFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View fragmentView = inflater.inflate(R.layout.fragment_result, container, false);

        //Get arguments
        String answer=getArguments().getString("answer");
        String expected=getArguments().getString("expected");
        //Show result string in fragment
        showResultString(answer,expected, fragmentView);

        //Set up button handlers
        setUpButtonHandlers(fragmentView);

        return fragmentView;
    }

    /**
     *
     * @param answer Answer user provided
     * @param expected Correct answer
     * @param fragmentView View to access findViewById
     */
    private void showResultString(String answer, String expected, View fragmentView){
        Resources res=getResources();
        String correctness;
        //Get the textView
        TextView textViewResult =(TextView)fragmentView.findViewById(R.id.textViewResult);


        //Was the answer correct?
        if (answer==expected){
            correctness=res.getString(R.string.result_correct);
        } else {
            correctness=res.getString(R.string.result_incorrect);
        }
        //Get the string to fill and build it

        String output=String.format(res.getString(R.string.result),answer,correctness);
        //Set result
        textViewResult.setText(output);
    }
    /**
     * Set up the button handlers for the three answer buttons
     * @param fragmentView Used so we have access to findViewbyId
     */
    private void setUpButtonHandlers(View fragmentView) {
        //Grab the handle of the buttons
        Button btnContinue = (Button) fragmentView.findViewById(R.id.btnContinue);
        //Set the onClick handlers
        btnContinue.setOnClickListener(new btnContinueHandler());
    }

    /**
     * Continue button onClick handler
     */
    private class btnContinueHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //TODO Upcouple
            //Yes this is coupled, yes I looked at the docs and no I couldn't figure out frag->Activity communication
            QuestionsActivity parent=(QuestionsActivity)getActivity();
            parent.continueSelected();
        }
    }
}