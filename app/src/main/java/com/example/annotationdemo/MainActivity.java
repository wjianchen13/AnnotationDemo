package com.example.annotationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.annotationdemo.compile.CompileActivity;
import com.example.annotationdemo.runtime.RuntimeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 编译时注解测试
     * @param v
     */
    public void onCompile(View v) {
        startActivity(new Intent(this, CompileActivity.class));
    }

    /**
     * 运行时注解测试
     * @param v
     */
    public void onRuntime(View v) {
        startActivity(new Intent(this, RuntimeActivity.class));
    }
    
}