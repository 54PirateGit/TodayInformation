package com.chenwj.todayinformation.utils;

import android.support.annotation.IntDef;

import static com.chenwj.todayinformation.utils.IntegerConstantTool.BEIJING;
import static com.chenwj.todayinformation.utils.IntegerConstantTool.HANGZHOU;
import static com.chenwj.todayinformation.utils.IntegerConstantTool.SHANGHAI;
import static com.chenwj.todayinformation.utils.IntegerConstantTool.SHENZHEN;

/**
 * author : ChenWJ
 * date : 2019/7/31 22:09
 * description : 数值常量
 */
@IntDef({SHANGHAI, HANGZHOU, BEIJING, SHENZHEN})
public @interface IntegerConstantTool {

    int SHANGHAI = 0;
    int HANGZHOU = 1;
    int BEIJING = 2;
    int SHENZHEN = 3;
}
