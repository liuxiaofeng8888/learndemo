package com.example.learndemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LinearLayoutDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout_demo);
        initFragment();
    }

    private void initFragment(){
        BlankFragment blankFragment = new BlankFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_fragment,blankFragment).commit();
    }
}
