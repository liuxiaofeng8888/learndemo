package com.example.learndemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class ViewpagerDemoActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ArrayList<Integer> image = new ArrayList<>();
    private int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_demo);
        viewPager = findViewById(R.id.viewpager);
        image.add(R.drawable.image01);
        image.add(R.drawable.image02);
        image.add(R.drawable.image03);
        viewPager.setAdapter(new viewpagerAdapter(this, image));
        viewPager.setPageMargin(-300);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setPageTransformer(true, new MyPageTransformer());
        viewPager.setCurrentItem(Integer.MAX_VALUE / 2);
    }
}
