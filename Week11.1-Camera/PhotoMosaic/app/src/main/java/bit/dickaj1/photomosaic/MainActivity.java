package bit.dickaj1.photomosaic;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    //Used for debugging
    String TAG="ABC123";

    //Record where we tell the camera to put the photo
    File imageFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpButtons();

        //Restore imageFile if available
        if (savedInstanceState!=null){
            imageFile=(File)savedInstanceState.get("imageFile");
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceData) {
        super.onSaveInstanceState(savedInstanceData);
        //Save imageFile
        savedInstanceData.putSerializable("imageFile", imageFile);
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
    private class btnTakePhotoHandler implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            startCamera();
        }
    }

    /**
     * Start up the camera to get a photo
     */
    private void startCamera() {
        //Get new file object
        getNewFile();

        //Get Uri of file
        Uri mPhotoUri = Uri.fromFile(imageFile);

        //Create and intent to start camera
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //Attach Uri to the intent(tell camera where to store the photo taken
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, mPhotoUri);

        //Launch the intent, waiting for result
        startActivityForResult(cameraIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Is this the return we are waiting for?
        if (requestCode == 1) {
            //Did we get the data?
            if (resultCode == RESULT_OK) {

                //Find out file path of saved image
                String imageFilePath = imageFile.getPath();

                //Make bitmap from that file path
                Bitmap userPhotoBitmap = BitmapFactory.decodeFile(imageFilePath);

                //Pass off to setMosaic to manipulate and display
                setMosaic(userPhotoBitmap);

            } else {
                Toast.makeText(MainActivity.this, "No photo saved. Something went wrong", Toast.LENGTH_LONG).show();
            }
        }
    }

    //////////// Non form related stuff ////////////
    /**
     * Create a File object to write an image to
     */
    private void getNewFile() {
        //Fetch system image folder
        File imageFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        //Make subdirectory
        File myImageFolder = new File(imageFolder, getString(R.string.app_name));

        //Check folder exists(needs to be done every time in case user deletes it while app is running
        if (!myImageFolder.exists()) {
            myImageFolder.mkdirs(); //mkdirs creates parent folders as well
        }

        //generate timestamp for file name
        SimpleDateFormat timeStampFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date currentTime = new Date();
        String timeStamp = timeStampFormat.format(currentTime);

        //Make file name

        String mPhotoFileName = "IMG_" + timeStamp + ".jpg";

        //Make complete File object(path and filename)
        imageFile = new File(myImageFolder.getPath() + File.separator + mPhotoFileName);
    }

    /**
     * Takes an image and displays the mosaic
     * @param input image to use for mosaic
     */
    private void setMosaic(Bitmap input){
        //TODO Turn image into a mosaic

        //Get reference
        ImageView ivMosaic=(ImageView)findViewById(R.id.ivMosaic);
        //Display it
        ivMosaic.setImageBitmap(input);
    }
}
