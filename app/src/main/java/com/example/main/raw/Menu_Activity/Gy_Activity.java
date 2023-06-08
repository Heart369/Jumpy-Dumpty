package com.example.main.raw.Menu_Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.main.R;
import com.example.main.mvvm.base.BaseActivity;
import com.example.main.raw.Class_Custom.gx;
import com.example.main.raw.activity.MainActivity;

public class Gy_Activity extends BaseActivity {
    RelativeLayout r1;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gy);
        TextView t = findViewById(R.id.version);
        gx gx = new gx(this);
        try {
            t.setText("版本号:" + com.example.main.raw.Class_Custom.gx.getVersionName(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
        setToolbar(R.id.toolbar_gy, R.id.title_gy, "关于");
        r1 = findViewById(R.id.bbzd_re);
        Glide.with(this)
                .load(R.drawable.ntm_ct)
                .transform(new RoundedCorners(50))
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        r1.setBackground(resource);
                    }
                });
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String url = "mqqwpa://im/chat?chat_type=wpa&uin=1306433548";
                    //uin是发送过去的qq号码
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(Gy_Activity.this, "惊,竟然没有QQ？", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }


}