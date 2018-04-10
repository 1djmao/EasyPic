package com.idjmao.easypic;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.idjmao.easypiclib.progress.CircleProgressView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView mImageView2;
    CountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView=new TextView(this);
        textView.setText("addText");

        imageView=findViewById(R.id.img1);
        mImageView2=findViewById(R.id.img2);

        CircleProgressView progressView=findViewById(R.id.progressView);
        progressView.setProgress(35);

        final ImageView.ScaleType oldScaleType=imageView.getScaleType();


        timer=new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long l) {
                setPregress(l/10000f);
            }

            @Override
            public void onFinish() {
                showImg(oldScaleType);
            }
        };
        timer.start();

        loadImg();

        findViewById(R.id.reload).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(MainActivity.this)
                        .load(R.mipmap.ic_launcher)
                        .into(mImageView2);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.get(MainActivity.this).clearDiskCache();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Glide.get(MainActivity.this).clearMemory();
                                loadImg();
                            }
                        });
                    }
                }).start();
            }
        });

    }

    private void loadImg() {
        final String url="http://www.jcodecraeer.com/uploads/141104/1-141104104116307.gif";
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                RequestOptions options=new RequestOptions();

                Glide.with(MainActivity.this)
                        .load(url)
                        .apply(options)
                        .into(mImageView2);
            }
        });
    }

    private void setPregress(float pregress){
        //只有 version 23 以上的 ImageView 才能设置 Foreground
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            imageView.setForegroundGravity(Gravity.CENTER);
            imageView.setForeground(new BitmapDrawable(BitMapp.getBitMap(pregress)));
        }else {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setImageDrawable(new BitmapDrawable(BitMapp.getBitMap(pregress)));
        }
    }

    private void showImg(ImageView.ScaleType type){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            imageView.setForeground(null);
        }else {
            imageView.setScaleType(type);
            imageView.setImageResource(R.drawable.pic);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        timer.cancel();
    }
}
