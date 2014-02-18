package com.ideas.dogeweather.fragments;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ideas.dogeweather.R;
import com.ideas.dogeweather.views.DogeTextView;

import java.util.Timer;
import java.util.TimerTask;

public class DogeFragment extends Fragment {

    public static final int MINIMUM_INTERVAL = 2000;
    public static final int MAXIMUM_INTERVAL = 8000;
    public static final double HIDE_PROBABILITY = 0.3;
    private DogeTextView soFirst;
    private DogeTextView soSecond;
    private DogeTextView soThird;

    private int width;
    private int height;

    private Timer timer;

    public static DogeFragment newInstance() {
        DogeFragment fragment = new DogeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.doge_layout, null);

        soFirst = (DogeTextView) root.findViewById(R.id.soFirst);
        soSecond = (DogeTextView) root.findViewById(R.id.soSecond);
        soThird = (DogeTextView) root.findViewById(R.id.soThird);

        timer = new Timer();
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        width = display.getWidth();
        height = display.getHeight();

        initTimer(soFirst);
        initTimer(soSecond);
        initTimer(soThird);
    }

    private void initTimer(final DogeTextView textView) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                final RelativeLayout.LayoutParams params =
                        new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT);
                int left = (int) (Math.random() * (width - textView.getWidth()));
                int top = (int) (Math.random() * (height - textView.getHeight()));
                params.setMargins(left, top, -left, -top);

                final int visibility = Math.random() > HIDE_PROBABILITY ? View.VISIBLE : View.INVISIBLE;
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setLayoutParams(params);
                        textView.setVisibility(visibility);
                    }
                });
            }
        }, 500,
            (long) (Math.random() * (MAXIMUM_INTERVAL - MINIMUM_INTERVAL) + MINIMUM_INTERVAL));
    }

    @Override
    public void onPause() {
        super.onPause();
        timer.cancel();
    }
}
