package com.example.mrz.practiceandtest;

import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.mrz.practiceandtest.view.PinchImageView;

public class RotateImageViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate_image_view);
    }

    int i = 0;

    public void rotate(View view) {
        PinchImageView image = (PinchImageView) view;
//        image.setPivotX(image.getWidth() / 2);
//        image.setPivotY(image.getHeight() / 2);//支点在图片中心
//
//        image.setRotation(i * 90 % 360);
        Matrix matrix = new Matrix();
        matrix.postRotate(90, image.getWidth()/2, image.getHeight()/2);
        image.outerMatrixTo(matrix, 200);

        i++;
    }
}
