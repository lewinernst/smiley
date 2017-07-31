package com.example.lewin.smiley;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.*;
import android.widget.TextView;

import java.util.ArrayList;
import android.content.res.Resources;
import java.lang.*;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Demo extends AppCompatActivity {

    private int sadnessState = 0;
    private ArrayList<View> Mouth = new ArrayList<View>();
    ;

    private final View.OnTouchListener b1Listener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

        /*Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.hyperspace_jump);
        hyperspaceJumpAnimation.setFillAfter(true);
        findViewById(R.id.t22).startAnimation(hyperspaceJumpAnimation);*/
        //findViewById(R.id.lefteye).animate().translationXBy(20f);

        happier();
        return false;
        }
    };

    private final View.OnTouchListener b2Listener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
        sadder();
        return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.smileyplayground);


        findViewById(R.id.b1).setOnTouchListener(b1Listener);
        findViewById(R.id.b2).setOnTouchListener(b2Listener);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Resources r = getResources();
        String name = getPackageName();

        int pos = 1;
        while(findViewById( getResources().getIdentifier("mouth" + pos, "id", getPackageName()) ) != null) {
                Mouth.add(findViewById( getResources().getIdentifier("mouth" + pos, "id", getPackageName()) ));
                pos++;
        }


    }

    private void sadder (){

        for (View mouthPixel : Mouth) {

            mouthPixel.animate().translationYBy((float)pow((abs(Mouth.indexOf(mouthPixel) - Mouth.size()/2)),2.0));
        }
        sadnessState += 1;


    }

    private void happier (){

        for (View mouthPixel : Mouth) {

            mouthPixel.animate().translationYBy((float)-pow((abs(Mouth.indexOf(mouthPixel) - Mouth.size()/2)),2.0));
        }
        sadnessState -= 1;

    }

}
