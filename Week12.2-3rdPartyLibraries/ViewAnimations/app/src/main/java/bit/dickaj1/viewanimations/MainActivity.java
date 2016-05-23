package bit.dickaj1.viewanimations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpButtons();
    }

    public void setUpButtons(){
        ImageView iv =(ImageView)findViewById(R.id.clickImage);
        iv.setOnClickListener(new clickListener());
    }

    private class clickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            YoYo.with(Techniques.StandUp).duration(2000).playOn(v);
        }
    }
}
