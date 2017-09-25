package com.example.mrz.practiceandtest;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class TestPermissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_permission);
    }

    public void check1(View v){
        //if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
            Log.d("check1","PERMISSION_GRANTED===="+checkVoice1(this));
        Toast.makeText(this,"ContextCompat.checkSelfPermission==="+checkVoice1(this),Toast.LENGTH_SHORT).show();
            Log.d("check1","PERMISSION_GRANTED====CAMERA"+ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA));
       // }
    }

    public void check2(View v) {
        //if(PermissionChecker.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
            Log.d("check2","PERMISSION_GRANTED===="+checkVoice2(this));
        Toast.makeText(this,"PermissionChecker.checkSelfPermission===="+checkVoice2(this),Toast.LENGTH_SHORT).show();
        Log.d("check1","PERMISSION_GRANTED====CAMERA"+ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA));
       // }、
    }


    /**
     * 检查录音权限6.0
     * cwq
     */
    public static boolean checkVoice1(Context context) {

        try {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return true;
        }
    }

    /**
     * 检查录音权限6.0
     * cwq
     */
    public static boolean checkVoice2(Context context) {

        try {
            if (PermissionChecker.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return true;
        }
    }
}
