package com.example.lewin.smiley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;
import java.util.ArrayList;
import android.content.res.Resources;
import android.graphics.drawable.TransitionDrawable;
import android.graphics.drawable.Drawable;

import junit.framework.Assert;

import java.lang.*;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Demo extends AppCompatActivity {

    //Make sure to keep these
    private int sadnessState = 0;
    private ArrayList<View> Mouth = new ArrayList<View>();
    private ArrayList<View> Eyes = new ArrayList<View>();


    //You don't need this stuff, but it shows how it works
    private final View.OnTouchListener b1Listener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
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

    private final View.OnTouchListener b3Listener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            setSadnessState((float)0.5);
            return false;
        }
    };

    private final View.OnTouchListener b4Listener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Random rand = new Random();
            setSadnessState((rand.nextFloat()));
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.smileyplayground);


        findViewById(R.id.b1).setOnTouchListener(b1Listener);
        findViewById(R.id.b2).setOnTouchListener(b2Listener);
        findViewById(R.id.b3).setOnTouchListener(b3Listener);
        findViewById(R.id.b4).setOnTouchListener(b4Listener);


    }

    //MARK what you actually need
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

        pos = 1;
        while(findViewById( getResources().getIdentifier("eye" + pos, "id", getPackageName()) ) != null) {
            Eyes.add(findViewById( getResources().getIdentifier("eye" + pos, "id", getPackageName()) ));
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

    //Takes float between 0 and 1 and sets smiley accordingly
    private void setSadnessState (float howHappy){

        for (View mouthPixel : Mouth){
            mouthPixel.animate().translationY((float)(howHappy-0.5)*((float)-pow((5.0*abs(Mouth.indexOf(mouthPixel) - Mouth.size()/2)),2.0)));



            if (0.0 <= howHappy && howHappy < 0.2) {
                TransitionDrawable td = new TransitionDrawable( new Drawable[] {((ImageView)mouthPixel).getDrawable(), getResources().getDrawable(R.drawable.smiley0, null)});
                ((ImageView)mouthPixel).setImageDrawable(td);
                td.startTransition(500);
            }
            if (0.2 <= howHappy && howHappy < 0.4)  {
                TransitionDrawable td = new TransitionDrawable( new Drawable[] {((ImageView)mouthPixel).getDrawable(), getResources().getDrawable(R.drawable.smiley1, null)});
                ((ImageView)mouthPixel).setImageDrawable(td);
                td.startTransition(500);
            }
            if (0.4 <= howHappy && howHappy < 0.6)  {
                TransitionDrawable td = new TransitionDrawable( new Drawable[] {((ImageView)mouthPixel).getDrawable(), getResources().getDrawable(R.drawable.smiley2, null)});
                ((ImageView)mouthPixel).setImageDrawable(td);
                td.startTransition(500);
            }
            if (0.6 <= howHappy && howHappy < 0.8)  {
                TransitionDrawable td = new TransitionDrawable( new Drawable[] {((ImageView)mouthPixel).getDrawable(), getResources().getDrawable(R.drawable.smiley3, null)});
                ((ImageView)mouthPixel).setImageDrawable(td);
                td.startTransition(500);
            }
            if (0.8 < howHappy && howHappy <= 1.0)  {
                TransitionDrawable td = new TransitionDrawable( new Drawable[] {((ImageView)mouthPixel).getDrawable(), getResources().getDrawable(R.drawable.smiley4, null)});
                ((ImageView)mouthPixel).setImageDrawable(td);
                td.startTransition(500);
            }



        }

        for (View eyePixel : Eyes){

            if (0.0 <= howHappy && howHappy < 0.2) {
                TransitionDrawable td = new TransitionDrawable( new Drawable[] {((ImageView)eyePixel).getDrawable(), getResources().getDrawable(R.drawable.smiley0, null)});
                ((ImageView)eyePixel).setImageDrawable(td);
                td.startTransition(500);
            }
            if (0.2 <= howHappy && howHappy < 0.4)  {
                TransitionDrawable td = new TransitionDrawable( new Drawable[] {((ImageView)eyePixel).getDrawable(), getResources().getDrawable(R.drawable.smiley1, null)});
                ((ImageView)eyePixel).setImageDrawable(td);
                td.startTransition(500);
            }
            if (0.4 <= howHappy && howHappy < 0.6)  {
                TransitionDrawable td = new TransitionDrawable( new Drawable[] {((ImageView)eyePixel).getDrawable(), getResources().getDrawable(R.drawable.smiley2, null)});
                ((ImageView)eyePixel).setImageDrawable(td);
                td.startTransition(500);
            }
            if (0.6 <= howHappy && howHappy < 0.8)  {
                TransitionDrawable td = new TransitionDrawable( new Drawable[] {((ImageView)eyePixel).getDrawable(), getResources().getDrawable(R.drawable.smiley3, null)});
                ((ImageView)eyePixel).setImageDrawable(td);
                td.startTransition(500);
            }
            if (0.8 < howHappy && howHappy <= 1.0)  {
                TransitionDrawable td = new TransitionDrawable( new Drawable[] {((ImageView)eyePixel).getDrawable(), getResources().getDrawable(R.drawable.smiley4, null)});
                ((ImageView)eyePixel).setImageDrawable(td);
                td.startTransition(500);
            }



        }
    }


}
