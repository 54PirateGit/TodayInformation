package com.chenwj.todayinformation.mvp.presenter;

import com.chenwj.todayinformation.mvp.ILifeCircle;
import com.chenwj.todayinformation.mvp.IMvpView;
import com.chenwj.todayinformation.mvp.MvpControl;

import java.lang.ref.WeakReference;

/**
 * author : ChenWJ
 * date : 2019/7/28 22:25
 * description : 抽象中介，保存和获取V层引用
 */
public abstract class LifeCircleMvpPresenter<T extends IMvpView> implements ILifeCircle {

    private WeakReference<T> mWeakReference;

    protected LifeCircleMvpPresenter() {
        super();
    }

    public LifeCircleMvpPresenter(IMvpView iMvpView) {
        super();
        attachView(iMvpView);
        MvpControl mvpControl = iMvpView.getMvpControl();
        mvpControl.savePresenter(this);
    }

    @Override
    public void attachView(IMvpView iMvpView) {
        if (mWeakReference == null) {
            mWeakReference = new WeakReference(iMvpView);
        } else {
            T view = mWeakReference.get();
            if (view != iMvpView) {
                mWeakReference = new WeakReference(iMvpView);
            }
        }
    }

    @Override
    public void onDestroy() {
        mWeakReference = null;
    }

    protected T getView() {
        T view = mWeakReference != null ? mWeakReference.get() : null;
        if (view == null) {
            return getEmptyView();
        }
        return view;
    }

    protected abstract T getEmptyView();
}
