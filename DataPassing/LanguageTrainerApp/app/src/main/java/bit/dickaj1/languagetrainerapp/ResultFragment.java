package bit.dickaj1.languagetrainerapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class ResultFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View fragmentView = inflater.inflate(R.layout.fragment_result, container, false);

        //Set up button handlers
        setUpButtonHandlers(fragmentView);

        return fragmentView;
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