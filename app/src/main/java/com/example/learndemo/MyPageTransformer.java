package com.example.learndemo;

import android.util.Log;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

public class MyPageTransformer implements ViewPager.PageTransformer {
    private final float MIN_SCALE = 0.5f;
    private final float MIN_ALPHA = 0.5f;
    @Override
    public void transformPage(View page, float position) {
        float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
        float alphaFactor = MIN_ALPHA + (1 - MIN_ALPHA) * (1 - Math.abs(position));
        page.setScaleY(scaleFactor);
        page.setAlpha(alphaFactor);
    }
}
