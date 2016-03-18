package bit.dickaj1.musicschoolapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Arron on 18/03/2016.
 */
public class ConfirmationDialog extends DialogFragment {
    //The empty constructor
    public ConfirmationDialog(){}

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setIcon(R.drawable.ic_music);
        builder.setTitle("Confirm?");
        builder.setPositiveButton("Yes", new YesButtonHandler());
        builder.setNegativeButton("No",new NoButtonHandler());

        Dialog customDialog=builder.create();

        return customDialog;
    }

    public class YesButtonHandler implements DialogInterface.OnClickListener{

        @Override
        public void onClick(DialogInterface dialog, int which) {
            MainActivity myActivity=(MainActivity) getActivity();
            myActivity.GiveMeMyData(true);
        }
    }

    public class NoButtonHandler implements DialogInterface.OnClickListener{

        @Override
        public void onClick(DialogInterface dialog, int which) {
            MainActivity myActivity=(MainActivity) getActivity();
            myActivity.GiveMeMyData(false);
        }
    }

}
