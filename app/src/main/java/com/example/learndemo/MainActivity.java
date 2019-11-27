package com.example.learndemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
        tvViewStub.setText("asdhotfux");
        tvViewStub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("click", "onClick: ");
            }
        });
        hookOnClickListener(tvViewStub);
    }

    /**
     * 测试线性布局
     *
     * @param view
     */
    public void testLinearLayout(View view) {
//        startActivity(new Intent(this, LinearLayoutDemo.class));
    }

    /**
     * 测试viewpager
     *
     * @param view
     */
    public void testViewpager(View view) {
        startActivity(new Intent(this, ViewpagerDemoActivity.class));
    }

    private void hookOnClickListener(View view) {
        try {
            // 得到 View 的 ListenerInfo 对象
            Method getListenerInfo = View.class.getDeclaredMethod("getListenerInfo");
            getListenerInfo.setAccessible(true);
            Object listenerInfo = getListenerInfo.invoke(view);
            // 得到 原始的 OnClickListener 对象
            Class<?> listenerInfoClz = Class.forName("android.view.View$ListenerInfo");
            Field mOnClickListener = listenerInfoClz.getDeclaredField("mOnClickListener");
            mOnClickListener.setAccessible(true);
            View.OnClickListener originOnClickListener = (View.OnClickListener) mOnClickListener.get(listenerInfo);
            // 用自定义的 OnClickListener 替换原始的 OnClickListener
            View.OnClickListener hookedOnClickListener = new HookedOnClickListener(originOnClickListener);
            mOnClickListener.set(listenerInfo, hookedOnClickListener);
        } catch (Exception e) {
            Log.i("method", "hook clickListener failed!", e);
        }
    }

    class HookedOnClickListener implements View.OnClickListener {
        private View.OnClickListener origin;

        HookedOnClickListener(View.OnClickListener origin) {
            this.origin = origin;
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "hook click", Toast.LENGTH_SHORT).show();
            Log.i("click", "Before click, do what you want to to.");
            if (origin != null) {
                origin.onClick(v);
            }
            Log.i("click", "After click, do what you want to to.");
        }
    }
}
