package com.xinlan.geassim.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/3/24.
 */
public class NoScrollTextView extends TextView {
    public NoScrollTextView(Context context) {
        super(context);
    }

    public NoScrollTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScrollTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public NoScrollTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void scrollTo(int x, int y) {
        //do nothing
    }
}//end class
