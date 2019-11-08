package com.example.learndemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 测试线性布局
     * @param view
     */
    public void testLinearLayout(View view){
        startActivity(new Intent(this,LinearLayoutDemo.class));
    }
}
