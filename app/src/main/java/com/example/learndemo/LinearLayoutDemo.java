package com.example.learndemo;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class LinearLayoutDemo extends AppCompatActivity {
    private ImageView ivGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout_demo);
        initFragment();
        ivGo = findViewById(R.id.iv_animation);
    }

    private void initFragment() {
        BlankFragment blankFragment = new BlankFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_fragment, blankFragment).commit();
    }

    public void go(View view) {
        AnimationDrawable animationDrawable = (AnimationDrawable) ivGo.getBackground();
        if (!animationDrawable.isRunning()){
            animationDrawable.start();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        finish();
//        overridePendingTransition(R.anim.module_dialog_up,R.anim.module_dialog_down);
        ActivityCompat.finishAfterTransition(this);
    }
}
