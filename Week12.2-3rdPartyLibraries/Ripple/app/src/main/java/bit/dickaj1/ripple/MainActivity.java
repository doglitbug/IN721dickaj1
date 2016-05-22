package bit.dickaj1.ripple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.skyfishjy.library.RippleBackground;

public class MainActivity extends AppCompatActivity {
    //Hold ripple item globally
    public RippleBackground rippleBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Record reference to animation
        rippleBackground=(RippleBackground)findViewById(R.id.content);

        setupRipple();
    }

    public void setupRipple(){
        ImageView imageView=(ImageView)findViewById(R.id.centerImage);
        imageView.setOnClickListener(new rippleClickListener());

    }

    private class rippleClickListener implements View.OnClickListener{
            @Override
            public void onClick(View view) {
                //Swap animation state
                if(rippleBackground.isRippleAnimationRunning()){
                    rippleBackground.stopRippleAnimation();
                } else {
                    rippleBackground.startRippleAnimation();
                }
            }
        }
}
