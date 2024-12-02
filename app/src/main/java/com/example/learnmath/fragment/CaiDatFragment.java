package com.example.learnmath.fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.learnmath.R;
import com.example.learnmath.thucthe.CaiDatTable;
import com.example.learnmath.thucthe.CoSoDuLieu;

public class CaiDatFragment extends Fragment {

    private CoSoDuLieu database;
    private Switch switchMusic;
    private MediaPlayer mediaPlayer;

    // Tạo view cho fragment cài đặt
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //chuyển layout thành view
        View view = inflater.inflate(R.layout.fragment_cai_dat, container, false);

        switchMusic = view.findViewById(R.id.nhacnen);

        database = Room.databaseBuilder(getContext(), CoSoDuLieu.class, "app_database").build();

        // tạo đối tượng MediaPlayer để phát nhạc nền
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.nhacnenapp);
        mediaPlayer.setLooping(true);

        // Lấy cài đặt từ cơ sở dữ liệu và cập nhật trạng thái của switch
        new Thread(() -> {
            CaiDatTable caiDatTable = database.settingsDao().getSettings(1);
            if (caiDatTable != null) {
                getActivity().runOnUiThread(() -> {
                    switchMusic.setChecked(caiDatTable.musicEnabled);
                    if (caiDatTable.musicEnabled) {
                        mediaPlayer.start();
                    }
                });
            }
        }).start();

        // Sự kiện khi người dùng thay đổi trạng thái của switch
        switchMusic.setOnCheckedChangeListener((buttonView, isChecked) -> {
            new Thread(() -> {
                CaiDatTable caiDatTable = new CaiDatTable();
                caiDatTable.id = 1; // Ensure the ID is set to 1
                caiDatTable.musicEnabled = isChecked;
                database.settingsDao().update(caiDatTable);
            }).start();

            if (isChecked) {
                // Play music
                mediaPlayer.start();
            } else {
                // Pause music
                mediaPlayer.stop();
            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        database.close();
        super.onDestroy();
    }
}