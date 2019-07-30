package com.shouzhong.request.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("SecondActivity", "data=" + getIntent().getStringExtra("data"));
        setContentView(R.layout.activity_second);
    }

    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("data", "1234567890");
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
