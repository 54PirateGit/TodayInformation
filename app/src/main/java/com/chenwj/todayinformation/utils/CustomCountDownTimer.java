package com.chenwj.todayinformation.utils;

import android.os.Handler;

/**
 * 计时器，倒计时
 * 2019/07/22
 */
public class CustomCountDownTimer implements Runnable {

    private ICountDownHandler mICountDownHandler;
    private int mTime;// 时间

    private Handler mHandler;
    private boolean isRun;// 是否正在运行

    /**
     * 时间，单位 s
     */
    public CustomCountDownTimer(int time, ICountDownHandler iCountDownHandler) {
        this.mTime = time;
        this.mICountDownHandler = iCountDownHandler;
        mHandler = new Handler();
    }

    @Override
    public void run() {
        if (isRun) {
            // 判断是不是倒计时结束
            if (mTime == 0) {
                cancel();
                if (mICountDownHandler != null) {
                    mICountDownHandler.finish();
                }
            } else {
                if (mICountDownHandler != null) {
                    mICountDownHandler.onTicker(mTime);
                }
                mTime--;
                mHandler.postDelayed(this, 1000L);
            }
        }
    }

    /**
     * 开始倒计时
     */
    public void start() {
        if (!isRun) {
            isRun = true;
            mHandler.post(this);
        }
    }

    /**
     * 移除计时器
     */
    public void cancel() {
        if (isRun) {
            mHandler.removeCallbacks(this);
            isRun = false;
        }
    }

    public interface ICountDownHandler {

        /**
         * 到时间实时回调
         * @param time 时间
         */
        void onTicker(int time);

        /**
         * 倒计时完成
         */
        void finish();
    }

}
