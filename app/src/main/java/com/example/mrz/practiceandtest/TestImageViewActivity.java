package com.example.mrz.practiceandtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import com.example.mrz.practiceandtest.view.SlidingTabLayout;

import java.util.ArrayList;

public class TestImageViewActivity extends AppCompatActivity {
    //    ListView lv = (ListView) findViewById(R.id.lv);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_image_view);
//        ListView lv = (ListView) findViewById(R.id.lv);
//        lv.setAdapter(new BaseAdapter() {
//            @Override
//            public int getCount() {
//                return 3;
//            }
//
//            @Override
//            public Object getItem(int position) {
//                return null;
//            }
//
//            @Override
//            public long getItemId(int position) {
//                return 0;
//            }
//
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                View view = View.inflate(TestImageViewActivity.this, R.layout.item, null);
////                ImageView img = view.findViewById(R.id.iv);
////                img.setLayoutParams(new LinearLayout.LayoutParams(getScreenWidth(TestImageViewActivity.this),getScreenWidth(TestImageViewActivity.this)/2));
//
//                return view;
//            }
//        });
        SlidingTabLayout id_slidingtab_indicator = (SlidingTabLayout) findViewById(R.id.id_slidingtab_indicator);
        ViewPager vp = (ViewPager) findViewById(R.id.vp);
        BlankFragment blankFragment = new BlankFragment();
        BlankFragment blankFragment1 = new BlankFragment();
        BlankFragment blankFragment2 = new BlankFragment();
        final ArrayList<BlankFragment> list = new ArrayList<>();
        list.add(blankFragment);
        list.add(blankFragment1);
        // list.add(blankFragment2);
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Fragment getItem(int position) {
                getScreenWidth(null);

                return list.get(position);
            }
        });
        String[] strings = {"阿萨德", "阿萨德到底"};
        id_slidingtab_indicator.setViewPager(vp, strings);
        getScreenWidth(this);
    }

    public static int getScreenWidth(@NonNull Activity activity) {
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
