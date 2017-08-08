package com.example.mrz.practiceandtest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestCropImgActivity extends AppCompatActivity {
    public static final int CROP_IMAGE_REQUESTCODE = 234;//裁剪

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_crop_img);
        final File file = new File(Environment.getExternalStorageDirectory(), "ttt.jpg");
        try {
            writeBytesToFile(getAssets().open("bbb.jpg"),file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        findViewById(R.id.tv_crop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cropImage(file);
            }
        });
    }

    /**
     * 裁剪照片
     *
     * @param file
     */
    private void cropImage(File file) {
        Uri mUri = Uri.fromFile(file);

        if (null == mUri)
            return;
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(mUri, "image/*");// mUri是已经选择的图片Uri
        intent.putExtra("crop", "true");// crop=true是设置在开启的Intent中设置显示的VIEW可裁剪
        //宽高比例
        intent.putExtra("aspectX", 2);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 200);
        intent.putExtra("outputY", 100);
        intent.putExtra("outputFormat", "JPEG");
        intent.putExtra("scale", true);
        intent.putExtra("noFaceDetection", true);
        //若为false则表示不返回数据
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_IMAGE_REQUESTCODE);
    }

    public static void writeBytesToFile(InputStream is, File file) throws IOException {
        FileOutputStream fos = null;
        try {
            byte[] data = new byte[2048];
            int nbread = 0;
            fos = new FileOutputStream(file);
            while((nbread=is.read(data))>-1){
                fos.write(data,0,nbread);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally{
            if (fos!=null){
                fos.close();
            }
        }
    }
}
