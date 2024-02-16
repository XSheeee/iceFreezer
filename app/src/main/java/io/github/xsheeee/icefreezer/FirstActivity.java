package io.github.xsheeee.icefreezer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.Explode;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import io.github.xsheeee.icefreezer.tools.TestAbout;

public class FirstActivity extends AppCompatActivity {
    private int times = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Button nextButton = findViewById(R.id.nextButton);
        TextView helloText = findViewById(R.id.helloText);
        //不优雅的调用方式
        TestAbout testAbout = new TestAbout(getApplicationContext());
        //判断是否root
//        if (!testAbout.is_root()) {
//            testAbout.showToast("设备未root,无法使用本模块");
//        }
//        //已经root
//        testAbout.showToast("设备已root,可以使用本模块");
        nextButton.setOnClickListener(v -> {
            switch (times) {
                case 0: {
                    helloText.setText(this.getString(R.string.second));
                    helloText.setTextSize(20);
                    times++;
                    return;
                }
                case 1: {
                    if (TestAbout.isModuleActive()) {
                        testAbout.showToast("已启用，可以获取root权限");
                        nextButton.setText("获取root权限");
                    } else {
                        testAbout.showToast("未启用，请先在lsp管理器中启用本模块,然后再次点击按钮");
                        nextButton.setText("请先启用");
                        nextButton.setBackgroundColor(this.getColor(R.color.teal_700));
                        times=10;
                        return;
                    }
                    times++;
                    return;
                }
                case 2: {
                    try {
                        Runtime.getRuntime().exec("su");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    helloText.setText(this.getString(R.string.third));
                    nextButton.setText("开始使用");
                    times++;
                    return;
                }
                case 3: {
                    Intent intent = new Intent();
                    intent.setClass(FirstActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                case 10:{
                    if (TestAbout.isModuleActive()) {
                        testAbout.showToast("已启用，可以获取root权限");
                        nextButton.setText("获取root权限");
                    } else {
                        testAbout.showToast("未启用，请先在lsp管理器中启用本模块(重启本模块)");
                        nextButton.setText("请先启用");
                        nextButton.setBackgroundColor(this.getColor(R.color.teal_700));
                        times=10;
                        return;
                    }
                    times=2;
                    return;
                }

            }
        });
    }

}