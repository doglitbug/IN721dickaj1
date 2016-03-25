package bit.dickaj1.languagetrainerapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class AnswersFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View fragmentView = inflater.inflate(R.layout.fragment_answers, container, false);

        // Do any required setup for the fragment view here...
        //TODO set up however we pass the selected answer back to questionsactivity

        //Set up button handlers
        //Pass in the fragmentView so that we have access to findViewbyId
        setUpButtonHandlers(fragmentView);

        return fragmentView;
    }

    private void setUpButtonHandlers(View fragmentView) {
        //Grab the handle of the buttons
        Button btnAnswer1 = (Button) fragmentView.findViewById(R.id.btnAnswer1);
        Button btnAnswer2 = (Button) fragmentView.findViewById(R.id.btnAnswer2);
        Button btnAnswer3 = (Button) fragmentView.findViewById(R.id.btnAnswer3);
        //Set the onClick handlers
        btnAnswer1.setOnClickListener(new btnAnswerHandler());
        btnAnswer2.setOnClickListener(new btnAnswerHandler());
        btnAnswer3.setOnClickListener(new btnAnswerHandler());

    }

    private class btnAnswerHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //Hold the selected answer
            int answer=-1;
            //An answer button has been selected
            //Figure out which one
            switch(v.getId()) {
                case R.id.btnAnswer1:
                    answer = 1;
                    break;
                case R.id.btnAnswer2:
                    answer = 2;
                    break;
                case R.id.btnAnswer3:
                    answer = 3;
                    break;
                default:
                    //TODO throw an error?
                    break;
            }
            //TODO Send the answer back to the questionactivity or deal with it here if we have
            //the question manager?
            Toast.makeText(getActivity(),"Answer "+answer+" selected",Toast.LENGTH_LONG).show();
        }
    }
}