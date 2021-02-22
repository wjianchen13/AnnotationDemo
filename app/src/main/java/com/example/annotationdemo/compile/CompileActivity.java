package com.example.annotationdemo.compile;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.annotation.CBindView;
import com.example.annotation.COnClick;
import com.example.annotationdemo.R;
import com.example.binder.Binding;

public class CompileActivity extends AppCompatActivity {

    @CBindView(R.id.tv_test)
    TextView tvTest;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compile);
        Binding.bind(this);
    }

    @COnClick(R.id.btn_runtime)
    void onHelloBtnClick(View v){
        tvTest.setText("hello android annotation processor");
    }
    
}