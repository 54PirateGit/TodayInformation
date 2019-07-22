package com.chenwj.todayinformation;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.File;

/**
 * 启动界面
 * 2019/05/08
 */
public class SplashActivity extends AppCompatActivity {

    private CustomCountDownTimer mCustomCountDownTimer;// 计时器

    private FullScreeVideoView mVideoView;
    private TextView textOver;// 先倒计时，然后显示跳过，倒计时的时候不可以点击

    private final int mCountDownTime = 5;// 给定时间

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();
    }

    // 初始化界面
    private void initView() {
        mVideoView = findViewById(R.id.vv_play);
        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));

        // 播放器准备回调
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });

        // 播放完成
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });

        // 开启倒计时
        textOver = findViewById(R.id.text_over);
        mCustomCountDownTimer = new CustomCountDownTimer(mCountDownTime, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                textOver.setText(time + "S");
            }

            @Override
            public void finish() {
                textOver.setText("跳过");
                textOver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // 倒计时结束，点击跳过到主界面
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                        finish();
                    }
                });
            }
        });
        mCustomCountDownTimer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCustomCountDownTimer != null) {
            mCustomCountDownTimer.cancel();
        }
    }
}
