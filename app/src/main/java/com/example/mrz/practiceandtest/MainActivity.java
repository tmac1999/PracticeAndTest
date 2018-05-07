package com.example.mrz.practiceandtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.blankj.utilcode.util.BarUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         /*set it to be no title*/
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
       // BarUtils.setNavBarVisibility(this,false);
        BarUtils.setNavBarImmersive(this);
        /*set it to be full screen*/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    public void jump(View view) {
        startActivity(new Intent(this, TestTextViewActivity.class));
    }
}
