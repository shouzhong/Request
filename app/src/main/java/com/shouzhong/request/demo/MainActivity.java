package com.shouzhong.request.demo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.shouzhong.request.Callback;
import com.shouzhong.request.Request;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickNext(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("data", "aabbcc");
        new Request().with(this).setIntent(intent).setCallback(new Callback() {
            @Override
            public void call(int resultCode, Intent data) {
                Log.e("MainActivity", "resultCode=" + resultCode);
                if (resultCode == Activity.RESULT_OK) {
                    Log.e("MainActivity", "data=" + data.getStringExtra("data"));
                }
            }
        }).start();
    }
}
