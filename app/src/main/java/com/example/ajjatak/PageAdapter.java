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
                return new WorldFragment();
            case 3:
                return new VideoFragment();
            case 4:
                return new EnternimentFragment();
            case 5:
                return new TechnologyFragment();
            case 6:
                return new SportsFragment();
            case 7:
                return new WebStoriesFragment();
            case 8:
                return new BusinessFragment();
            case 9:
                return new DharmFragment();
            case 10:
                return new ExplainedFragment();
            case 11:
                return new LifestyleFragment();
            case 12:
                return new TrendingFragment();
            case 13:
                return new AutoFragment();
            case 14:
                return new PhotosFragment();
            case 15:
                return new NewsReelsFragment();
            case 16:
                return new LivetvFragment();
            case 17:
                return new DarkModeFragment();
            case 18:
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
