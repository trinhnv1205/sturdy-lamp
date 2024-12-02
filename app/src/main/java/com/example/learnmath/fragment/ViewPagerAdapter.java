package com.example.learnmath.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager supportFragmentManager, int behaviorResumeOnlyCurrentFragment) {
        super(supportFragmentManager, behaviorResumeOnlyCurrentFragment);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                return new LichSuLamBaiFragment();
            case 2:
                return new CaiDatFragment();
            default:
                return new TrangChuFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
