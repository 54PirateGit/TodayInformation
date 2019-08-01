package com.chenwj.todayinformation.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chenwj.todayinformation.annotation.ViewInJect;
import com.chenwj.todayinformation.mvp.view.LifeCircleMvpFragment;

import butterknife.ButterKnife;

/**
 * author : ChenWJ
 * date : 2019/7/31 22:23
 * description :
 */
public abstract class BaseFragment extends LifeCircleMvpFragment {

    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = null;
        ViewInJect annotation = getClass().getAnnotation(ViewInJect.class);
        if (annotation != null) {
            int layoutId = annotation.bindLayoutId();
            if (layoutId > 0) {
                mView = initFragmentView(inflater, layoutId);
                bindView(mView);
                afterBindView();
            } else {
                throw new RuntimeException("layoutId < 0");
            }
        } else {
            throw new RuntimeException("ViewInJect is null");
        }
        return mView;
    }

    private View initFragmentView(LayoutInflater inflater, int layoutId) {
        return inflater.inflate(layoutId, null);
    }

    // 绑定视图
    private void bindView(View view) {
        ButterKnife.bind(this, view);
    }

    // 模板方法 设计模式
    public abstract void afterBindView();
}
