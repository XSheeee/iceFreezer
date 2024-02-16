package io.github.xsheeee.icefreezer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import io.github.xsheeee.icefreezer.tools.TestAbout;

public class GuideActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        //判断是否为第一次进入,使用不怎么优雅的intent
        SharedPreferences sharedPreferences = getSharedPreferences("share", MODE_PRIVATE);

        TestAbout testAbout=new TestAbout(getApplicationContext());

        //默认false
        boolean isFirstRun = sharedPreferences.getBoolean("isFirstRun", false);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //如果是true就表示已经不是第一次运行app，跳转相应界面就可以了 反之。。。。。。
        if (!TestAbout.isModuleActive()) {
            //上次未在lsp中启用
            Intent intent = new Intent();
            intent.setClass(GuideActivity.this, FirstActivity.class);
            startActivity(intent);
            finish();
        } else if (!isFirstRun) {
            //第一次运行
            editor.putBoolean("isFirstRun", true);
            editor.apply();
            Intent intent = new Intent();
            intent.setClass(GuideActivity.this, FirstActivity.class);
            startActivity(intent);
            finish();
        } else if(isFirstRun && TestAbout.isModuleActive()){
            Intent intent = new Intent();
            intent.setClass(GuideActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}