package com.example.dell.tg;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout constraintLayout=findViewById(R.id.layout);
        AnimationDrawable animationDrawable=(AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();
        final Intent i=new Intent(MainActivity.this,Activity2.class);

        TextView tv1,tv2;
        tv1=(TextView)findViewById(R.id.travel);
        tv2=(TextView)findViewById(R.id.guide);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.fade);
        tv1.setAnimation(animation);
        tv2.setAnimation(animation);

        Thread timer=new Thread(){
            public void run(){
                try {
                    sleep(10000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}

