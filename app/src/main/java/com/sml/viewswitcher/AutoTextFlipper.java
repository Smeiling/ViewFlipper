package com.sml.viewswitcher;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.List;

/**
 * Created by Smeiling on 2017/11/14.
 */

public class AutoTextFlipper extends FrameLayout {

    private Context context;
    private int interval = 2000;
    private int textColor = 0x999999;
    private float textSize = 12f;

    public AutoTextFlipper(@NonNull Context context) {
        this(context, null);
    }

    public AutoTextFlipper(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public AutoTextFlipper(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AutoTextFlipper);
        interval = typedArray.getInt(R.styleable.AutoTextFlipper_interval, 2000);
        textColor = typedArray.getColor(R.styleable.AutoTextFlipper_textColor, 0x999999);
        textSize = px2dip(context, typedArray.getDimension(R.styleable.AutoTextFlipper_textSize, 12f));
        typedArray.recycle();

        this.context = context;
        setupView();
    }

    private int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    private void setupView() {
        ViewFlipper viewFlipper = new ViewFlipper(context);
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(interval);
        TranslateAnimation translateAnimation = new TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_SELF, 0,
                TranslateAnimation.RELATIVE_TO_SELF, 0,
                TranslateAnimation.RELATIVE_TO_SELF, 1,
                TranslateAnimation.RELATIVE_TO_SELF, 0);
        translateAnimation.setDuration(500);
        viewFlipper.setInAnimation(translateAnimation);
        translateAnimation = new TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_SELF, 0,
                TranslateAnimation.RELATIVE_TO_SELF, 0,
                TranslateAnimation.RELATIVE_TO_SELF, 0,
                TranslateAnimation.RELATIVE_TO_SELF, -1);
        translateAnimation.setDuration(500);
        viewFlipper.setOutAnimation(translateAnimation);
        addView(viewFlipper);
    }

    public void setItems(List<String> stringList) {
        ViewFlipper viewFlipper = (ViewFlipper) getChildAt(0);
        TextView textView;
        for (String str : stringList) {
            textView = new TextView(context);
            textView.setText(str);
            textView.setTextSize(textSize);
            textView.setTextColor(textColor);
            viewFlipper.addView(textView);
        }
    }

}
