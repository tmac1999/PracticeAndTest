package com.example.mrz.practiceandtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class TestImageViewActivity extends AppCompatActivity {
    ListView lv = (ListView) findViewById(R.id.lv);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_image_view);
        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = View.inflate(TestImageViewActivity.this, R.layout.item, null);
//                ImageView img = view.findViewById(R.id.iv);
//                img.setLayoutParams(new LinearLayout.LayoutParams(getScreenWidth(TestImageViewActivity.this),getScreenWidth(TestImageViewActivity.this)/2));

                return view;
            }
        });
    }

    public static int getScreenWidth(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }

    public static int getScreenHeight(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.heightPixels;
    }
}
