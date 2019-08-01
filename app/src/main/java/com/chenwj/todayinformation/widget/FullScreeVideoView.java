package com.chenwj.todayinformation.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * 全屏播放视频
 * 2019/05/08
 */
public class FullScreeVideoView extends VideoView {

    // 主要用户直接 new 出来的对象
    public FullScreeVideoView(Context context) {
        super(context);
    }

    // 主要用于 xml 文件中，支持自定义属性
    public FullScreeVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    // 主要用户 xml 文件中，支持自定义属性，同时支持 style 样式
    public FullScreeVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width, height);
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
