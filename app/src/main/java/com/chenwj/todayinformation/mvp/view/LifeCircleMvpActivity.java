package com.chenwj.todayinformation.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.chenwj.todayinformation.mvp.IMvpView;
import com.chenwj.todayinformation.mvp.MvpControl;

/**
 * author : ChenWJ
 * date : 2019/7/29 21:30
 * description :
 */
public class LifeCircleMvpActivity extends AppCompatActivity implements IMvpView {

    private MvpControl mvpControl;

    @Override
    public MvpControl getMvpControl() {
        if (mvpControl == null) {
            mvpControl = new MvpControl();
        }
        return mvpControl;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent == null) {
            intent = new Intent();
        }
        MvpControl mvpControl = this.getMvpControl();
        if (mvpControl != null) {
            mvpControl.onCreate(savedInstanceState, intent, null);
            mvpControl.ActivityCreated(savedInstanceState, intent, null);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        MvpControl mvpControl = this.getMvpControl();
        if (mvpControl != null) {
            mvpControl.onnNewIntent(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        MvpControl mvpControl = this.getMvpControl();
        if (mvpControl != null) {
            mvpControl.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        MvpControl mvpControl = this.getMvpControl();
        if (mvpControl != null) {
            mvpControl.onResume();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        MvpControl mvpControl = this.getMvpControl();
        if (mvpControl != null) {
            mvpControl.onStop();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        MvpControl mvpControl = this.getMvpControl();
        if (mvpControl != null) {
            mvpControl.onPause();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MvpControl mvpControl = this.getMvpControl();
        if (mvpControl != null) {
            mvpControl.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        MvpControl mvpControl = this.getMvpControl();
        if (mvpControl != null) {
            mvpControl.onSaveInstanceState(outState);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MvpControl mvpControl = this.getMvpControl();
        if (mvpControl != null) {
            mvpControl.onDestroy();
        }
    }
}
