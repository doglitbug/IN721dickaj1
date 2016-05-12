package bit.dickaj1.photomosaic;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpButtons();

        //TODO Set up file path etc
    }

    /**
     * Initializes button click handlers
     */
    private void setUpButtons(){
        //Get reference to button
        Button btnTakePhoto=(Button)findViewById(R.id.btnTakePhoto);
        //Set handler
        btnTakePhoto.setOnClickListener(new btnTakePhotoHandler());
    }

    /**
     * On click handler for btnTakePhoto
     */
    public class btnTakePhotoHandler implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //TODO launch camera intent to get photo
        }
    }

    /**
     * Takes an image and displays the mosaic
     * @param input image to use for mosaic
     */
    private void setMosaic(Bitmap input){
        if (input==null){
            //TODO Deal with null image being provided
        }
        //TODO The photo mosaic stuff and display it
    }
}
