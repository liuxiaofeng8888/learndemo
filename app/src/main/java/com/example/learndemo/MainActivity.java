package com.example.learndemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ViewStub viewStub;
    private TextView tvViewStub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewStub = findViewById(R.id.viewstub);
        viewStub.inflate();
        tvViewStub = findViewById(R.id.tv_viewstub);
        tvViewStub.setText("asd");
    }

    /**
     * 测试线性布局
     * @param view
     */
    public void testLinearLayout(View view){
        startActivity(new Intent(this,LinearLayoutDemo.class));
    }
}
