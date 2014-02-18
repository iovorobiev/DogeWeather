package com.ideas.dogeweather;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.ideas.dogeweather.fragments.DogeFragment;

public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDogeFragment();
    }

    private void initDogeFragment() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(android.R.id.content, DogeFragment.newInstance()).commit();
    }
}
