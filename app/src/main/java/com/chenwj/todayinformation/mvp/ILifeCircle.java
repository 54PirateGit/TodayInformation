package com.chenwj.todayinformation.mvp;

import android.content.Intent;
import android.os.Bundle;

/**
 * 2019/07/28
 */
public interface ILifeCircle {

    void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments);

    void ActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArguments);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void destroyView();

    void onViewDestroy();

    void onnNewIntent(Intent intent);

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onSaveInstanceState(Bundle bundle);

    void attachView(IMvpView iMvpView);
}
