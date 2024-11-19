package com.example.learnmath.fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.learnmath.R;
import com.example.learnmath.luyentap.LuyenTapToan;
import com.example.learnmath.phepchia.MenuPhepChia;
import com.example.learnmath.phepcong.MenuPhepCong;
import com.example.learnmath.phepnhan.MenuPhepNhan;
import com.example.learnmath.pheptru.MenuPhepTru;
import com.example.learnmath.sosanh.PhepSoSanhActivity;

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

        View truButton = view.findViewById(R.id.subtraction_button);
        truButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MenuPhepTru.class);
            startActivity(intent);
        });

        View nhanButton = view.findViewById(R.id.multiplication_button);
        nhanButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MenuPhepNhan.class);
            startActivity(intent);
        });

        View chiaButton = view.findViewById(R.id.division_button);
        chiaButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MenuPhepChia.class);
            startActivity(intent);
        });

        View sosanhButton = view.findViewById(R.id.compare_button);
        sosanhButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PhepSoSanhActivity.class);
            startActivity(intent);
        });

        View luyentapButton = view.findViewById(R.id.luyentaptoan_button);
        luyentapButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), LuyenTapToan.class);
            startActivity(intent);
        });


        return view;
    }
}