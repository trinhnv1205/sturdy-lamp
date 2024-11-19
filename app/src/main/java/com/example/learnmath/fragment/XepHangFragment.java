package com.example.learnmath.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.learnmath.R;
import com.example.learnmath.thucthe.CoSoDuLieu;
import com.example.learnmath.thucthe.NguoiDungAdapter;
import com.example.learnmath.thucthe.NguoiDungTable;

import java.util.List;

public class XepHangFragment extends Fragment {

    private CoSoDuLieu database;
    private RecyclerView recyclerView;
    private NguoiDungAdapter nguoiDungAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_xep_hang, container, false);

        database = Room.databaseBuilder(getContext(), CoSoDuLieu.class, "app_database").build();
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        new Thread(() -> {
            List<NguoiDungTable> nguoiDungTables = database.userDao().getAllUsers();
            getActivity().runOnUiThread(() -> {
                nguoiDungAdapter = new NguoiDungAdapter(nguoiDungTables);
                recyclerView.setAdapter(nguoiDungAdapter);
            });
        }).start();

        return view;
    }
}