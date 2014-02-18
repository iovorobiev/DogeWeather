package com.ideas.dogeweather.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class DogeTextView extends TextView {

    public DogeTextView(Context context) {
        super(context);
        initTypeface();
    }

    public DogeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTypeface();
    }

    public DogeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initTypeface();
    }

    private void initTypeface() {
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "comicsans.ttf");
        setTypeface(typeface, 1);
    }
}
