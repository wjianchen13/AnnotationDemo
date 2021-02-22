package com.example.annotationdemo.runtime;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.annotationdemo.R;

public class RuntimeActivity extends AppCompatActivity implements View.OnClickListener{

    //自动创建对象，不用我们去new UserInfo()了
    @AutoWired
    public UserInfo mUserInfo;

    //自动绑定view
    @BindView(R.id.btn_bindview)
    Button mTextView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runtime);
        AutoWiredProcess.bind(this);
        System.out.println("===============> name: " + mUserInfo.name + "  age: " + mUserInfo.getAge());

        ButterKnifeProcess.bind(this);
        mTextView.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View view) {
        Toast.makeText(this, "BindView 成功", Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.btn_onclick})
    public void testOnClick() {
        Toast.makeText(this, "点击触发了testOnClick注解的函数", Toast.LENGTH_SHORT).show();
    }
}