package com.chenwj.todayinformation.main.shenzhen;

import android.widget.TextView;

import com.chenwj.todayinformation.R;
import com.chenwj.todayinformation.annotation.ViewInJect;
import com.chenwj.todayinformation.base.BaseFragment;

import butterknife.BindView;

/**
 * author : ChenWJ
 * date : 2019/7/31 22:29
 * description : 深圳
 */
@ViewInJect(bindLayoutId = R.layout.fragment_others)
public class ShenZhenFragment extends BaseFragment {

    @BindView(R.id.tv_position)
    TextView tvPosition;

    @Override
    public void afterBindView() {
        tvPosition.setText("深圳");
    }
}
