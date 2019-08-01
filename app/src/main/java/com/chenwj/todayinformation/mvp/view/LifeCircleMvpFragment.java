package com.chenwj.todayinformation.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.chenwj.todayinformation.mvp.IMvpView;
import com.chenwj.todayinformation.mvp.MvpControl;

/**
 * author : ChenWJ
 * date : 2019/7/29 21:30
 * description :
 */
public class LifeCircleMvpFragment extends Fragment implements IMvpView {

    private MvpControl mvpControl;

    @Override
    public MvpControl getMvpControl() {
        if (mvpControl == null) {
            mvpControl = new MvpControl();
        }
        return mvpControl;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle == null) {
            bundle = new Bundle();
        }
        MvpControl mvpControl = this.getMvpControl();
        if (mvpControl != null) {
            mvpControl.onCreate(savedInstanceState, null, bundle);
            mvpControl.ActivityCreated(savedInstanceState, null, bundle);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        MvpControl mvpControl = this.getMvpControl();
        if (mvpControl != null) {
            mvpControl.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        MvpControl mvpControl = this.getMvpControl();
        if (mvpControl != null) {
            mvpControl.onResume();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        MvpControl mvpControl = this.getMvpControl();
        if (mvpControl != null) {
            mvpControl.onStop();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        MvpControl mvpControl = this.getMvpControl();
        if (mvpControl != null) {
            mvpControl.onPause();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MvpControl mvpControl = this.getMvpControl();
        if (mvpControl != null) {
            mvpControl.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        MvpControl mvpControl = this.getMvpControl();
        if (mvpControl != null) {
            mvpControl.onSaveInstanceState(outState);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MvpControl mvpControl = this.getMvpControl();
        if (mvpControl != null) {
            mvpControl.onDestroy();
        }
    }
}
