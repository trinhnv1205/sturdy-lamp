package com.example.learnmath.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.learnmath.phepcong.MenuPhepCong;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager supportFragmentManager, int behaviorResumeOnlyCurrentFragment) {
        super(supportFragmentManager, behaviorResumeOnlyCurrentFragment);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                return new XepHang();
            case 2:
                return new CaiDat();
            default:
                return new TrangChu();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
