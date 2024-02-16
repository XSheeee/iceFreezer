package io.github.xsheeee.icefreezer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        TextView xshe = findViewById(R.id.XShe);
        TextView mowei = findViewById(R.id.MoWei);
        TextView lanz=findViewById(R.id.lanz);
        xshe.setOnClickListener(v -> {
            try {
                Intent intent = new Intent();
                intent.setClassName("com.coolapk.market", "com.coolapk.market.view.AppLinkActivity");
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse("coolmarket://u/20552855"));
                startActivity(intent);
            }catch (Exception e){
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.link_author1))));
            }
        });
        mowei.setOnClickListener(v ->{
            try {
                Intent intent = new Intent();
                    intent.setClassName("com.coolapk.market", "com.coolapk.market.view.AppLinkActivity");
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse("coolmarket://u/24268987"));
                    startActivity(intent);
            }catch (Exception e){
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.link_author2))));
            }
        });
        lanz.setOnClickListener(v->startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.link_lanz)))));
    }

    }
