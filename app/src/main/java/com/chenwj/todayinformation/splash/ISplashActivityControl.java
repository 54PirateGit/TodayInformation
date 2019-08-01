package com.chenwj.todayinformation.splash;

import com.chenwj.todayinformation.mvp.ILifeCircle;
import com.chenwj.todayinformation.mvp.IMvpView;
import com.chenwj.todayinformation.mvp.MvpControl;

/**
 * author : ChenWJ
 * date : 2019/7/29 22:26
 * description :
 */
public interface ISplashActivityControl {

    interface IView extends IMvpView {

        void setTimerText(String timer);
    }

    interface IPresenter extends ILifeCircle {

        void initTimer();
    }

    IView emptyView = new IView() {
        @Override
        public void setTimerText(String timer) {

        }

        @Override
        public MvpControl getMvpControl() {
            return null;
        }
    };
}
