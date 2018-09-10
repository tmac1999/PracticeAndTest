package com.example.mrz.practiceandtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Utils.init(getApplication());
        findViewById(R.id.content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort("content");
            }
        });
        findViewById(R.id.ll_click).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ToastUtils.showShort("lllllll");
            }
        });
        findViewById(R.id.iv_click).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ToastUtils.showShort("imageview");
            }
        });
    }
//    @Override
//    public void onKeyboardShow() {
//        int offsetY = mKeyboardManager.getSoftKeyboardHeight() + ViewUtil.dp2px(435) - Constants.screenHeight;
//        int screenPositions[] = new int[2];
//        rlItems.getLocationOnScreen(screenPositions);
//        if (offsetY > 0) {
//            ObjectAnimator.ofFloat(rlItems, "translationY", rlItems.getTranslationY(), -offsetY)
//                    .setDuration(100).start();
//        }
//    }
//
//    @Override
//    public void onKeyboardHide() {
//        if (rlItems.getTranslationY() != 0) {
//            ObjectAnimator.ofFloat(rlItems, "translationY", rlItems.getTranslationY(), 0)
//                    .setDuration(100).start();
//        }
//    }
}
