package com.example.learnmath.additions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.learnmath.R;

public class AdditionFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_addition, container, false);

        LinearLayout continuousAdditionButton = view.findViewById(R.id.continuous_addition_button);
        continuousAdditionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click
            }
        });

        LinearLayout cong1chusoButton = view.findViewById(R.id.cong1chuso_button);
        cong1chusoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click
            }
        });

        LinearLayout cong2chusoButton = view.findViewById(R.id.cong2chuso_button);
        cong2chusoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click
            }
        });

        LinearLayout cong3chusoButton = view.findViewById(R.id.cong3chuso_button);
        cong3chusoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click
            }
        });

        LinearLayout cong3soButton = view.findViewById(R.id.cong3so_button);
        cong3soButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click
            }
        });

        LinearLayout phepcongtimsoButton = view.findViewById(R.id.phepcongtimso_button);
        phepcongtimsoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click
            }
        });

        return view;
    }
}