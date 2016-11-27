package com.example.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */


    int imageid[]={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5};
    int length=imageid.length;
    int sw=-1;
    ImageSwitcher is;
    Button b1;
    Context con=this;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        is=(ImageSwitcher)findViewById(R.id.imageswi);

        b1=(Button)findViewById(R.id.b1);


        is.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView iv=new ImageView(getApplicationContext());
                iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return iv;
            }
        });
        Animation in= AnimationUtils.loadAnimation(this,android.R.anim.fade_in);
        Animation out=AnimationUtils.loadAnimation(this,android.R.anim.fade_out);

        is.setAnimation(in);
        is.setAnimation(out);
        // is.setImageResource(imageid[sw]);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sw++;
                if (sw == length)
                    sw = 0;
                else
                    is.setImageResource(imageid[sw]);


            }
        });
        is.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(con,fillview.class);
                in.putExtra("id",imageid[sw]);
                startActivity(in);
            }
        });
    }
}
