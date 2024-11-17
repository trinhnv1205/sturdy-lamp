package com.example.learnmath.fragment;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.learnmath.R;
import com.example.learnmath.phepcong.MenuPhepCong;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TrangChu extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment and set click listeners
        View view = inflater.inflate(R.layout.fragment_trang_chu, container, false);

        View additionButton = view.findViewById(R.id.addition_button);
        additionButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MenuPhepCong.class);
            startActivity(intent);
        });
        return view;
    }
}