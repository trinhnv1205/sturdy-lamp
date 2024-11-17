package com.example.learnmath.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.learnmath.R;
import com.example.learnmath.additions.AdditionFragment;

public class Tab1Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);

        LinearLayout additionButton = view.findViewById(R.id.addition_button);
        additionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the AdditionActivity
                Intent intent = new Intent(getActivity(), AdditionFragment.class);
                startActivity(intent);
            }
        });


        return view;
    }
}