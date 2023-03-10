package com.example.ajjatak;

import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    int tabcount;

    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new IndiaFragment();

            case 2:
                return new VideoFragment();

            case 3:
                return new SportsFragment();

            case 4:
                return new NewsReelsFragment();
            case 5:
                return new LivetvFragment();
            case 6:
                return new GamesFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {

        return tabcount;

    }
}
