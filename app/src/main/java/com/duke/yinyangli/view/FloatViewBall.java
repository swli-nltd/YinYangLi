package com.duke.yinyangli.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.duke.yinyangli.constants.Constants;
import com.duke.yinyangli.utils.LogUtils;
import com.tencent.mmkv.MMKV;

import androidx.customview.widget.ViewDragHelper;


/**
 * Created by Administrator on 2016/1/18.
 */
public class FloatViewBall extends RelativeLayout {
    private ViewDragHelper mDragger;


    public FloatViewBall(Context context, AttributeSet attrs) {
        super(context, attrs);
        mDragger = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                return true;
            }

            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                final int leftBound = getPaddingLeft();
                final int rightBound = getWidth() - child.getWidth() - leftBound;
                final int newLeft = Math.min(Math.max(left, leftBound), rightBound);
                return newLeft;
            }

            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
                final int topBound = getPaddingTop();
                final int bottomBound = getHeight() - child.getHeight();
                final int newTop = Math.min(Math.max(top, topBound), bottomBound);
                return newTop;
            }

            @Override
            public int getViewHorizontalDragRange(View child) {
                return getMeasuredWidth() - child.getMeasuredWidth();
            }

            @Override
            public int getViewVerticalDragRange(View child) {
                return getMeasuredHeight() - child.getMeasuredHeight();
            }

            @Override
            public void onViewReleased(View releasedChild, float xvel, float yvel) {
                moveToSide(releasedChild);
                invalidate();
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return mDragger.shouldInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDragger.processTouchEvent(event);
        return false;
    }


    @Override
    public void computeScroll() {
        if (mDragger.continueSettling(true)) {
            invalidate();
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setClickable(true);
        }
    }

    private void moveToSide(View view) {
        MMKV.defaultMMKV().encode(Constants.SP_KEY.MAIN_LEFT, view.getLeft());
        MMKV.defaultMMKV().encode(Constants.SP_KEY.MAIN_TOP, view.getTop());
        MMKV.defaultMMKV().encode(Constants.SP_KEY.MAIN_RIGHT, view.getRight());
        MMKV.defaultMMKV().encode(Constants.SP_KEY.MAIN_BOTTOM, view.getBottom());
        float top = view.getTop();
        float bottom = getMeasuredHeight() - view.getBottom();
        float right = getMeasuredWidth() - view.getRight();
        float left = view.getLeft();
        LogUtils.e("ball margin:" + view.getLeft() + ", " + view.getTop() +", " + view.getRight() + ", " + view.getBottom());
        if ((top < bottom ? top : bottom) / getMeasuredHeight() < (right < left ? right : left) / getMeasuredWidth()) {
            //上下滑动
//            mDragger.settleCapturedViewAt(view.getLeft(), top < bottom ? 0 : getMeasuredHeight() - view.getMeasuredHeight());
        } else {
            //左右滑动
//            mDragger.settleCapturedViewAt(left < right ? 0 : getMeasuredWidth() - view.getMeasuredWidth(), view.getTop());
        }
    }

}
