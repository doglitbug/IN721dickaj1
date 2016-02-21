package bit.dickaj1.firstandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtRandomString = (TextView)findViewById(R.id.textViewDogBreed);

        //Choose a breed at random
        String dogBreed = chooseBreed();

        //Set the TextView
        txtRandomString.setText(dogBreed);
    }

    /**
     * Choose a breed randomly from a given list
     * @return String of choosen breed
     */
    private String chooseBreed(){
        //Create Random Number Generator
        Random rand=new Random();
        //Store a list of dog breeds to choose from
        String[] breeds={
                "Poodle",
                "Labrador",
                "Shar Pei",
                "Newfoundland"
        };

        //Choose one of the breeds at random from the array
        int dogBreed=rand.nextInt(breeds.length);
        String breedChosen=breeds[dogBreed];

        return breedChosen;
    }
}