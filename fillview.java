package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by android on 7/9/15.
 */


public class fillview extends Activity {
    public int currentimageindex=0;
    //    Timer timer;
//    TimerTask task;
    ImageView slidingimage;
    ImageView i;
    private int[] image = {
            R.drawable.a1, R.drawable.a2, R.drawable.a3,
            R.drawable.a4,R.drawable.a5
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fillview);
        Intent in=getIntent();
        i=(ImageView)findViewById(R.id.image);
        int id=in.getExtras().getInt("id");
        i.setImageResource(id);
        final Handler mHandler = new Handler();

        // Create runnable for posting
        final Runnable mUpdateResults = new Runnable() {
            public void run() {

                AnimateandSlideShow();

            }
        };

        int delay = 500; // delay for 1 sec.

        int period = 10000; // repeat every 4 sec.

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {

                mHandler.post(mUpdateResults);

            }

        }, delay, period);



    }

    public void onClick(View v) {

        finish();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    /**
     * Helper method to start the animation on the splash screen
     */
    private void AnimateandSlideShow() {


        slidingimage = (ImageView)findViewById(R.id.image);
        slidingimage.setImageResource(image[currentimageindex % image.length]);

        currentimageindex++;

        // Animation rotateimage = AnimationUtils.loadAnimation(this, R.anim.fade_in);


        // slidingimage.startAnimation(rotateimage);

    }
}
