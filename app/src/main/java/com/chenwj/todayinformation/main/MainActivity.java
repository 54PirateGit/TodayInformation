package com.chenwj.todayinformation.main;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.chenwj.todayinformation.R;
import com.chenwj.todayinformation.annotation.ViewInJect;
import com.chenwj.todayinformation.base.BaseActivity;
import com.chenwj.todayinformation.utils.IntegerConstantTool;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 主界面
 * ChenWJ
 * 2019/07/31
 */
@ViewInJect(bindLayoutId = R.layout.activity_main)
public class MainActivity extends BaseActivity implements IMainActivityContract.Iview {

    IMainActivityContract.IPresenter mPresenter = new MainActivityPresenter(this);

//    @BindView(R.id.fac_main_home)
//    FloatingActionButton facMainHome;
//    @BindView(R.id.fl_main_bottom)
//    FrameLayout flMainBottom;
//    @BindView(R.id.fl_main_content)
//    FrameLayout flMainContent;
//    @BindView(R.id.rb_main_shanghai)
//    LottieAnimationView rbMainShanghai;
//    @BindView(R.id.rb_main_hangzhou)
//    LottieAnimationView rbMainHangzhou;
//    @BindView(R.id.rg_main_top)
//    LinearLayout rgMainTop;
    @BindView(R.id.rb_main_nav_home_beijing)
    RadioButton rbMainNavHomeBeijing;
    @BindView(R.id.rb_main_nav_car_source_shenzhen)
    RadioButton rbMainNavCarSourceShenzhen;
    @BindView(R.id.rg_main_bottom)
    RadioGroup rgMainBottom;

    @BindView(R.id.rb_main_shanghai)
    RadioButton rbMainShanghai;
    @BindView(R.id.rb_main_hangzhou)
    RadioButton rbMainHangzhou;
    @BindView(R.id.rg_main_top)
    RadioGroup rgMainTop;

    private boolean isChangeTopOrBottom;

    @Override
    public void afterBindView() {
        initHomeFragment();
        changeAnim(rgMainBottom,rgMainTop);
        initCheckListener();
    }

    // 初始化 Fragment
    private void initHomeFragment() {
        mPresenter.initHomeFragment();
    }

    private void initCheckListener() {
//        rbMainShanghai.playAnimation();
//        rbMainShanghai.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (rbMainShanghai.getId() == mPresenter.getCurrentCheckedId()) {
//                    return;
//                }
//                mPresenter.replaceFragment(IntegerConstantTool.SHANGHAI);
//                rbMainShanghai.playAnimation();
//                rbMainHangzhou.reverseAnimation();
//            }
//        });
//
//        rbMainHangzhou.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (rbMainHangzhou.getId() == mPresenter.getCurrentCheckedId()) {
//                    return;
//                }
//                mPresenter.replaceFragment(MainConstantTool.HANGZHOU);
//                rbMainHangzhou.playAnimation();
//                rbMainShanghai.reverseAnimation();
//            }
//        });

        rgMainTop.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mPresenter.getCurrentCheckedId()) {
                    return;
                }
                switch (checkedId) {
                    case R.id.rb_main_shanghai:
                        mPresenter.replaceFragment(IntegerConstantTool.SHANGHAI);
                        break;
                    case R.id.rb_main_hangzhou:
                        mPresenter.replaceFragment(IntegerConstantTool.HANGZHOU);
                        break;
                }
            }
        });

        rgMainBottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mPresenter.getCurrentCheckedId()) {
                    return;
                }
                switch (checkedId) {
                    case R.id.rb_main_nav_home_beijing:
                        mPresenter.replaceFragment(IntegerConstantTool.BEIJING);
                        break;
                    case R.id.rb_main_nav_car_source_shenzhen:
                        mPresenter.replaceFragment(IntegerConstantTool.SHENZHEN);
                        break;
                }
            }
        });
    }

    @OnClick(R.id.fac_main_home)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fac_main_home:
                isChangeTopOrBottom = !isChangeTopOrBottom;
                if (isChangeTopOrBottom) {
                    changeAnim(rgMainTop,rgMainBottom);
                    handleTopPosition();
                } else {
                    changeAnim(rgMainBottom,rgMainTop);
                    handleBottomPosition();
                }
                break;
        }
    }

    // 北京 深圳
    private void handleBottomPosition() {
        if (mPresenter.getTopPosition() != IntegerConstantTool.HANGZHOU) {
            mPresenter.replaceFragment(IntegerConstantTool.SHANGHAI);
            rbMainShanghai.setChecked(true);
//            rbMainShanghai.pauseAnimation();
        }else {
            mPresenter.replaceFragment(IntegerConstantTool.HANGZHOU);
            rbMainHangzhou.setChecked(true);
//            rbMainHangzhou.playAnimation();
        }
    }

    // 上海 杭州
    private void handleTopPosition() {
        if (mPresenter.getBottomPosition() != IntegerConstantTool.SHENZHEN) {
            mPresenter.replaceFragment(IntegerConstantTool.BEIJING);
            rbMainNavHomeBeijing.setChecked(true);
        }else {
            mPresenter.replaceFragment(IntegerConstantTool.SHENZHEN);
            rbMainNavCarSourceShenzhen.setChecked(true);
        }
    }

    // 切换动画
    private void changeAnim(RadioGroup gone, RadioGroup show) {
        // 消失的动画
        gone.clearAnimation(); // 清除自身动画
        Animation animationGone = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_hide);
        gone.startAnimation(animationGone);
        gone.setVisibility(View.GONE);

        // 展示的动画
        show.clearAnimation();
        Animation animationShow = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_show);
        show.startAnimation(animationShow);
        show.setVisibility(View.VISIBLE);
    }

    @Override
    public void showFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().show(mFragment).commit();
    }

    @Override
    public void addFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main_content, mFragment).commit();
    }

    @Override
    public void hideFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().hide(mFragment).commit();
    }
}
