package com.chenwj.todayinformation.splash;

import android.util.Log;

import com.chenwj.todayinformation.mvp.base.BaseMvpPresenter;
import com.chenwj.todayinformation.utils.CustomCountDownTimer;

/**
 * author : ChenWJ
 * date : 2019/7/29 22:30
 * description :
 */
public class SplashTimerPresenter extends BaseMvpPresenter<ISplashActivityControl.IView> implements ISplashActivityControl.IPresenter {

    private CustomCountDownTimer mCustomCountDownTimer;// 计时器
    private final int mCountDownTime = 5;// 给定时间

    public SplashTimerPresenter(ISplashActivityControl.IView view) {
        super(view);
    }

    public void initTimer() {
        mCustomCountDownTimer = new CustomCountDownTimer(mCountDownTime, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                getView().setTimerText(time + "S");
            }

            @Override
            public void finish() {
                getView().setTimerText("跳过");
            }
        });
        mCustomCountDownTimer.start();
    }

    // 取消定时器
    private void cancel() {
        if (mCustomCountDownTimer != null) {
            mCustomCountDownTimer.cancel();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancel();
        Log.d("XXX", "Timer cancel");
    }

    /**
     * 防止空指针异常
     */
    @Override
    protected ISplashActivityControl.IView getEmptyView() {
        return ISplashActivityControl.emptyView;
    }
}
