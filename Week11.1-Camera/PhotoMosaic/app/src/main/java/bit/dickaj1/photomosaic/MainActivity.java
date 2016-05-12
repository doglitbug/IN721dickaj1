package bit.dickaj1.photomosaic;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    String TAG="ABC123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpButtons();
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
    private void startCamera(){
        //Get new file object
        File mPhotoFile=getNewFile();

        //Get Uri of file
        Uri mPhotoUri= Uri.fromFile(mPhotoFile);

        //Create and intent to start camera
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //Attach Uri to the intent(tell camera where to store the photo taken
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,mPhotoUri);
        Log.i(TAG, "startCamera: file path: "+mPhotoFile.toString());
        //Launch the intent, waiting for result
        startActivityForResult(cameraIntent,1);
    }

    //////////// Non form related stuff ////////////
    /**
     * Create a File object to write an image to
     * @return Unique File object
     */
    private File getNewFile(){
        //Fetch system image folder
        File imageFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        //Make subdirectory
        File myImageFolder=new File(imageFolder,getString(R.string.app_name));
        //Check folder exists(needs to be done every time in case user deletes it while app is running
        if (!myImageFolder.exists()){
            myImageFolder.mkdirs(); //mkdirs creates parent folders as well
        }

        //generate timestamp for file name
        SimpleDateFormat timeStampFormat= new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date currentTime=new Date();
        String timeStamp=timeStampFormat.format(currentTime);

        //Make file name

        String mPhotoFileName="IMG_"+timeStamp+".jpg";

        //Make complete File object(path and filename)
        File photoFile=new File(imageFolder.getPath()+File.separator+mPhotoFileName);

        return photoFile;
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
