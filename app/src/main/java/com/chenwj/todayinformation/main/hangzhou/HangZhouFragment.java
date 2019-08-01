package com.chenwj.todayinformation.main.hangzhou;

import android.widget.TextView;

import com.chenwj.todayinformation.R;
import com.chenwj.todayinformation.annotation.ViewInJect;
import com.chenwj.todayinformation.base.BaseFragment;

import butterknife.BindView;

/**
 * author : ChenWJ
 * date : 2019/7/31 22:29
 * description : 杭州
 */
@ViewInJect(bindLayoutId = R.layout.fragment_others)
public class HangZhouFragment extends BaseFragment {

    @BindView(R.id.tv_position)
    TextView tvPosition;

    @Override
    public void afterBindView() {
        tvPosition.setText("杭州");
    }
}
