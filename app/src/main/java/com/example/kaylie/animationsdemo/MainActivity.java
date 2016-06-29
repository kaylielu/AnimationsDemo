package com.example.kaylie.animationsdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAnimate = (Button)findViewById(R.id.btnAnimate);

        btnAnimate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(final View view) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                // ObjectAnimator
                // 1. Animate hte y value down to zero
                ObjectAnimator moveToTop = ObjectAnimator.ofFloat(view, "y", 30.0f);
                moveToTop.setDuration(2500);

                // 2. Animate the alpha value to zero
                ObjectAnimator fadeAway = ObjectAnimator.ofFloat(view, "alpha", 0.0f);

                AnimatorSet set = new AnimatorSet();
                set.playSequentially(moveToTop, fadeAway);
                set.start();
                //moveToTop.setRepeatCount(3);
//                moveToTop.setInterpolator(new BounceInterpolator());
                //moveToTop.setRepeatMode(ValueAnimator.REVERSE);



            }
        });

    }
}
