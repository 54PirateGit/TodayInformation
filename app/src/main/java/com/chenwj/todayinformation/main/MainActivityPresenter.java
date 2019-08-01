package com.chenwj.todayinformation.main;

import android.support.v4.app.Fragment;

import com.chenwj.todayinformation.R;
import com.chenwj.todayinformation.main.beiing.BeiJingFragment;
import com.chenwj.todayinformation.main.hangzhou.HangZhouFragment;
import com.chenwj.todayinformation.main.shanghai.ShangHaiFragment;
import com.chenwj.todayinformation.main.shenzhen.ShenZhenFragment;
import com.chenwj.todayinformation.mvp.base.BaseMvpPresenter;
import com.chenwj.todayinformation.utils.IntegerConstantTool;

/**
 * author : ChenWJ
 * date : 2019/7/31 22:36
 * description :
 */
public class MainActivityPresenter extends BaseMvpPresenter<IMainActivityContract.Iview> implements IMainActivityContract.IPresenter {

    // 当前Fragment的 角标
    private int mCurrentFragmentIndex;
    private Fragment[] mFragments = new Fragment[4];
    private int mCurrentCheckedId;
    private int mTopPosition;
    private int mBottomPositon;

    public MainActivityPresenter(IMainActivityContract.Iview view) {
        super(view);
    }

    @Override
    public void initHomeFragment() {
        mCurrentFragmentIndex = IntegerConstantTool.SHANGHAI;
        replaceFragment(mCurrentFragmentIndex);
    }

    //切换Fragment的 方法
    @Override
    public void replaceFragment(int mCurrentFragmentIndex) {
        for (int i = 0; i < mFragments.length; i++) {
            if (mCurrentFragmentIndex != i) {
                if (mFragments[i] != null) {
                    hideFragment(mFragments[i]);
                }
            }
        }

        Fragment mFragment = mFragments[mCurrentFragmentIndex];
        if (mFragment != null) {
            addAndShowFragment(mFragment);
            setCurChecked(mCurrentFragmentIndex);
        } else {
            newCurrentFragment(mCurrentFragmentIndex);
            setCurChecked(mCurrentFragmentIndex);
        }
    }

    @Override
    public int getCurrentCheckedId() {
        return mCurrentCheckedId;
    }

    @Override
    public int getCurrentCheckedIndex() {
        return mCurrentFragmentIndex;
    }

    @Override
    public int getTopPosition() {
        return mTopPosition;
    }

    @Override
    public int getBottomPosition() {
        return mBottomPositon;
    }

    @Override
    protected IMainActivityContract.Iview getEmptyView() {
        return IMainActivityContract.emptyView;
    }

    // 记录当前 角标
    private void setCurChecked(int mCurrentFragmentIndex) {
        this.mCurrentFragmentIndex = mCurrentFragmentIndex;
        switch (mCurrentFragmentIndex) {
            case IntegerConstantTool.SHANGHAI:
                mCurrentCheckedId = R.id.rb_main_shanghai;
                mTopPosition = IntegerConstantTool.SHANGHAI;
                break;
            case IntegerConstantTool.HANGZHOU:
                mCurrentCheckedId = R.id.rb_main_hangzhou;
                mTopPosition = IntegerConstantTool.HANGZHOU;
                break;
            case IntegerConstantTool.BEIJING:
                mCurrentCheckedId = R.id.rb_main_nav_home_beijing;
                mBottomPositon = IntegerConstantTool.BEIJING;
                break;
            case IntegerConstantTool.SHENZHEN:
                mCurrentCheckedId = R.id.rb_main_nav_car_source_shenzhen;
                mBottomPositon = IntegerConstantTool.SHENZHEN;
                break;
        }
    }

    // 创建 当前 Fragment
    private void newCurrentFragment(int mCurrentFragmentIndex) {
        Fragment fragment = null;
        switch (mCurrentFragmentIndex) {
            case IntegerConstantTool.SHANGHAI:
                fragment = new ShangHaiFragment();
                break;
            case IntegerConstantTool.HANGZHOU:
                fragment = new HangZhouFragment();
                break;
            case IntegerConstantTool.BEIJING:
                fragment = new BeiJingFragment();
                break;
            case IntegerConstantTool.SHENZHEN:
                fragment = new ShenZhenFragment();
                break;
        }
        mFragments[mCurrentFragmentIndex] = fragment;
        addAndShowFragment(fragment);
    }

    // 显示 Fragment
    private void addAndShowFragment(Fragment mFragment) {
        if (mFragment.isAdded()) {
            getView().showFragment(mFragment);
        } else {
            getView().addFragment(mFragment);
        }
    }

    // 隐藏Fragment
    private void hideFragment(Fragment mFragment) {
        if (mFragment != null && mFragment.isVisible()) {
            getView().hideFragment(mFragment);
        }
    }
}
