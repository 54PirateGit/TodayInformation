package com.chenwj.todayinformation.splash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.chenwj.todayinformation.main.MainActivity;
import com.chenwj.todayinformation.R;
import com.chenwj.todayinformation.annotation.ViewInJect;
import com.chenwj.todayinformation.base.BaseActivity;
import com.chenwj.todayinformation.widget.FullScreeVideoView;

import java.io.File;

import butterknife.BindView;

/**
 * 启动界面
 * 2019/05/08
 */
@ViewInJect(bindLayoutId = R.layout.activity_splash)
public class SplashActivity extends BaseActivity implements ISplashActivityControl.IView {

    @BindView(R.id.vv_play)
    FullScreeVideoView mVideoView;
    @BindView(R.id.text_over)
    TextView textOver;// 先倒计时，然后显示跳过，倒计时的时候不可以点击

    private ISplashActivityControl.IPresenter mSplashTimerPresenter;

    @Override
    public void afterBindView() {
        // 初始化
        initPresenter();
        initVideo();
        initListener();
    }

    // 初始化Presenter
    private void initPresenter() {
        mSplashTimerPresenter = new SplashTimerPresenter(this);
        mSplashTimerPresenter.initTimer();
    }

    private void initVideo() {
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
    }

    // 初始化监听事件
    private void initListener() {
        // 开启倒计时
        textOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 倒计时结束，点击跳过到主界面
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public void setTimerText(String timer) {
        textOver.setText(timer);
    }
}
