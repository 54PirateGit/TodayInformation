package com.chenwj.todayinformation.mvp;

import android.content.Intent;
import android.os.Bundle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * author : ChenWJ
 * date : 2019/7/29 21:32
 * description :
 */
public class MvpControl implements ILifeCircle {

    // 存放的是 P 层的实例
    private Set<ILifeCircle> iLifeCircles = new HashSet<>();

    public void savePresenter(ILifeCircle iLifeCircle) {
        iLifeCircles.add(iLifeCircle);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments) {
        Iterator<ILifeCircle> iterator = iLifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle lifeCircle = iterator.next();
            if (intent == null) {
                intent = new Intent();
            }
            if (getArguments == null) {
                getArguments = new Bundle();
            }
            lifeCircle.onCreate(savedInstanceState, intent, getArguments);
        }
    }

    @Override
    public void ActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArguments) {
        Iterator<ILifeCircle> iterator = iLifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle lifeCircle = iterator.next();
            if (intent == null) {
                intent = new Intent();
            }
            if (getArguments == null) {
                getArguments = new Bundle();
            }
            lifeCircle.ActivityCreated(savedInstanceState, intent, getArguments);
        }
    }

    @Override
    public void onStart() {
        Iterator<ILifeCircle> iterator = iLifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle lifeCircle = iterator.next();
            lifeCircle.onStart();
        }
    }

    @Override
    public void onResume() {
        Iterator<ILifeCircle> iterator = iLifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle lifeCircle = iterator.next();
            lifeCircle.onResume();
        }
    }

    @Override
    public void onPause() {
        Iterator<ILifeCircle> iterator = iLifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle lifeCircle = iterator.next();
            lifeCircle.onPause();
        }
    }

    @Override
    public void onStop() {
        Iterator<ILifeCircle> iterator = iLifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle lifeCircle = iterator.next();
            lifeCircle.onStop();
        }
    }

    @Override
    public void onDestroy() {
        Iterator<ILifeCircle> iterator = iLifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle lifeCircle = iterator.next();
            lifeCircle.onDestroy();
        }
    }

    @Override
    public void destroyView() {
        Iterator<ILifeCircle> iterator = iLifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle lifeCircle = iterator.next();
            lifeCircle.destroyView();
        }
    }

    @Override
    public void onViewDestroy() {
        Iterator<ILifeCircle> iterator = iLifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle lifeCircle = iterator.next();
            lifeCircle.onViewDestroy();
        }
    }

    @Override
    public void onnNewIntent(Intent intent) {
        Iterator<ILifeCircle> iterator = iLifeCircles.iterator();
        while (iterator.hasNext()) {
            if (intent == null) {
                intent = new Intent();
            }
            ILifeCircle lifeCircle = iterator.next();
            lifeCircle.onnNewIntent(intent);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Iterator<ILifeCircle> iterator = iLifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle lifeCircle = iterator.next();
            lifeCircle.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        Iterator<ILifeCircle> iterator = iLifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle lifeCircle = iterator.next();
            lifeCircle.onSaveInstanceState(bundle);
        }
    }

    @Override
    public void attachView(IMvpView iMvpView) {
        Iterator<ILifeCircle> iterator = iLifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCircle lifeCircle = iterator.next();
            lifeCircle.attachView(iMvpView);
        }
    }
}
