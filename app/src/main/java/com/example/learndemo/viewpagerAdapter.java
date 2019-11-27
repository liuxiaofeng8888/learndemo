package com.example.learndemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class viewpagerAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<Integer> images;

    public viewpagerAdapter(Context context, ArrayList<Integer> images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = createImageView(context, position);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }


    private ImageView createImageView(Context mContext, int position) {
        ImageView imageview = new ImageView(mContext);
        ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams(); // 等价于ViewGroup.LayoutParams(FILL_PARENT, FILL_PARENT)
        layoutParams.width = 1080;
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
        imageview.setLayoutParams(layoutParams); // 设置ImageView充满父容器
        imageview.setPadding(200, 80, 200, 80);
        imageview.setImageResource(images.get(position%images.size())); // 设置ImageView的显示图片
        imageview.setScaleType(ImageView.ScaleType.FIT_XY); // 设置ImageView缩放样式
        return imageview;
    }
}
