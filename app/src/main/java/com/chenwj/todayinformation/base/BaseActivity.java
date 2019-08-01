package com.chenwj.todayinformation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.chenwj.todayinformation.annotation.ViewInJect;
import com.chenwj.todayinformation.mvp.view.LifeCircleMvpActivity;

import butterknife.ButterKnife;

/**
 * Activity 基类
 */
public abstract class BaseActivity extends LifeCircleMvpActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInJect annotation = getClass().getAnnotation(ViewInJect.class);
        if (annotation != null) {
            int layoutId = annotation.bindLayoutId();
            if (layoutId > 0) {
                setContentView(layoutId);
                bindView();
                afterBindView();
            } else {
                throw new RuntimeException("layoutId < 0");
            }
        } else {
            throw new RuntimeException("ViewInJect is null");
        }
    }

    // 绑定视图
    private void bindView() {
        ButterKnife.bind(this);
    }

    public abstract void afterBindView();
}
