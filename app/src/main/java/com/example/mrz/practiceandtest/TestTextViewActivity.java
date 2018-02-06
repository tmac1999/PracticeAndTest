package com.example.mrz.practiceandtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class TestTextViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_text_view);
//        TextView viewById = (TextView) findViewById(R.id.tv);
//        viewById.setText("90123");
//        viewById.setText("90123312");
//        viewById.setText("9012312323");
        findViewById(R.id.rafl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestTextViewActivity.this,"dsadas",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
