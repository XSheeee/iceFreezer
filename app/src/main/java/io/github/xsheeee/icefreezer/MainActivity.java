package io.github.xsheeee.icefreezer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.Explode;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView aboutButton=findViewById(R.id.logoImage);
        ImageView settingButton=findViewById(R.id.settingImage);
        aboutButton.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        });
        settingButton.setOnClickListener(v->{
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, SettingActivity.class);
            startActivity(intent);
        });

    }
}