package com.example.ymj.activity;

import com.example.valueanimatordemo.R;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class AnimatorActivity extends ActionBarActivity{
    private TextView mIntDemo;
    private View mAlphaDemo;
    private View group_anim_demo;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animator_demo_layout);
        initWidget();
        startAnimInt();
    }
    
    private void initWidget(){
        mIntDemo = (TextView)findViewById(R.id.int_demo);
        mAlphaDemo = (View)findViewById(R.id.alpha_demo);
        group_anim_demo = (View)findViewById(R.id.group_anim_demo);
    }
    
    //组合动画
    private void groupAnim(){
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(group_anim_demo, "translationX", -500f, 0f);  
        ObjectAnimator rotate = ObjectAnimator.ofFloat(group_anim_demo, "rotation", 0f, 360f);  
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(group_anim_demo, "alpha", 1f, 0f, 1f);  
        AnimatorSet animSet = new AnimatorSet();  
        animSet.play(rotate).with(fadeInOut).after(moveIn);  
        animSet.setDuration(5000);  
        animSet.start();  
    }
    
    private void startAnimInt(){
        mIntDemo.setText("100");
        
        ValueAnimator anim1 = ValueAnimator.ofInt(100, 0, 100);
        anim1.setDuration(3000);
        anim1.addUpdateListener(new AnimatorUpdateListener() {
            
            @Override
            public void onAnimationUpdate(final ValueAnimator animation) {
                mIntDemo.post(new Runnable() {
                    
                    @Override
                    public void run() {
                        mIntDemo.setText(animation.getAnimatedValue() + "");
                    }
                });
                
                Log.i("", "ymj--current value：" + animation.getAnimatedValue());
            }
        });
        anim1.addListener(new AnimatorListener() {
            
            @Override
            public void onAnimationStart(Animator animation) {
                
            }
            
            @Override
            public void onAnimationRepeat(Animator animation) {
                
            }
            
            @Override
            public void onAnimationEnd(Animator animation) {
                startAnimAlpha();
            }
            
            @Override
            public void onAnimationCancel(Animator animation) {
                
            }
        });
        anim1.start();
        
    }
    
    private void startAnimAlpha(){
        ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(mAlphaDemo, "alpha", 1f, 0f, 1f);
        alphaAnim.setDuration(1000);
        alphaAnim.setRepeatCount(2);
        alphaAnim.addListener(new AnimatorListener() {
            
            @Override
            public void onAnimationStart(Animator animation) {
                
            }
            
            @Override
            public void onAnimationRepeat(Animator animation) {
                
            }
            
            @Override
            public void onAnimationEnd(Animator animation) {
                startAnimRotation();
            }
            
            @Override
            public void onAnimationCancel(Animator animation) {
                
            }
        });
        alphaAnim.start();
        
    }
    
    private void startAnimRotation(){
        ObjectAnimator rotationAnim = ObjectAnimator.ofFloat(mAlphaDemo, "rotation", 0f, 360f);
        rotationAnim.setDuration(1000);
        rotationAnim.addListener(new AnimatorListener() {
            
            @Override
            public void onAnimationStart(Animator animation) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void onAnimationRepeat(Animator animation) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void onAnimationEnd(Animator animation) {
                // TODO Auto-generated method stub
                startAnimTranslationX();
            }
            
            @Override
            public void onAnimationCancel(Animator animation) {
                // TODO Auto-generated method stub
                
            }
        });
        rotationAnim.start();
      
    }
    
    private void startAnimTranslationX(){
        float currentTransX = mAlphaDemo.getTranslationX();
        ObjectAnimator transAnim = ObjectAnimator.ofFloat(mAlphaDemo, "translationX", currentTransX, -500f, currentTransX);
        transAnim.setDuration(1000);
        transAnim.addListener(new AnimatorListener() {
            
            @Override
            public void onAnimationStart(Animator animation) {
                
            }
            
            @Override
            public void onAnimationRepeat(Animator animation) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void onAnimationEnd(Animator animation) {
                // TODO Auto-generated method stub
                startAnimScaleX();
            }
            
            @Override
            public void onAnimationCancel(Animator animation) {
                // TODO Auto-generated method stub
            }
        });
        transAnim.start();
        
       
    }
    
    private void startAnimScaleX(){
        ObjectAnimator transAnim = ObjectAnimator.ofFloat(mAlphaDemo, "scaleY", 1f, 3f, 1f);
        transAnim.setDuration(1000);
        transAnim.addListener(new AnimatorListener() {
            
            @Override
            public void onAnimationStart(Animator animation) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void onAnimationRepeat(Animator animation) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void onAnimationEnd(Animator animation) {
                // TODO Auto-generated method stub
                groupAnim();
            }
            
            @Override
            public void onAnimationCancel(Animator animation) {
                // TODO Auto-generated method stub
                
            }
        });
        transAnim.start();
    }
    
    
    
    
}
