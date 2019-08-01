package com.chenwj.todayinformation.main;

import android.support.v4.app.Fragment;

import com.chenwj.todayinformation.mvp.ILifeCircle;
import com.chenwj.todayinformation.mvp.IMvpView;
import com.chenwj.todayinformation.mvp.MvpControl;

/**
 * author : ChenWJ
 * date : 2019/7/31 22:36
 * description :
 */
public interface IMainActivityContract {

    interface Iview extends IMvpView {

        void showFragment(Fragment mFragment);

        void addFragment(Fragment mFragment);

        void hideFragment(Fragment mFragment);

    }

    interface IPresenter extends ILifeCircle {

        void initHomeFragment();

        int getCurrentCheckedId();

        void replaceFragment(int mCurrentFragmentIndex);

        int getCurrentCheckedIndex();

        int getTopPosition();

        int getBottomPosition();
    }

    Iview emptyView = new Iview() {

        @Override
        public void showFragment(Fragment mFragment) {

        }

        @Override
        public void addFragment(Fragment mFragment) {

        }

        @Override
        public void hideFragment(Fragment mFragment) {

        }

        @Override
        public MvpControl getMvpControl() {
            return null;
        }
    };
}
