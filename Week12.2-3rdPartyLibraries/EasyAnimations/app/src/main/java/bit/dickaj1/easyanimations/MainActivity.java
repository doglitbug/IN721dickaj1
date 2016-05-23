package bit.dickaj1.easyanimations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.easyandroidanimations.library.ExplodeAnimation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpButtons();
    }

    /**
     * Sets up onclick event for the image
     */
    private void setUpButtons(){
        ImageView iv = (ImageView)findViewById(R.id.centerImage);
        iv.setOnClickListener(new clickListener());
    }

    /**
     * OnClick listener
     */
    private class clickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            new ExplodeAnimation(v).animate();
        }
    }
}
