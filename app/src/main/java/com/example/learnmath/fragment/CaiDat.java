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
import com.example.learnmath.thucthe.AppDatabase;
import com.example.learnmath.thucthe.Settings;

public class CaiDat extends Fragment {

    private AppDatabase database;
    private Switch switchMusic;
    private MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cai_dat, container, false);

        switchMusic = view.findViewById(R.id.nhacnen);

        database = Room.databaseBuilder(getContext(), AppDatabase.class, "app_database").build();

        // Initialize MediaPlayer
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.bg);
        mediaPlayer.setLooping(true);

        // Load the current settings
        new Thread(() -> {
            Settings settings = database.settingsDao().getSettings(1);
            if (settings != null) {
                getActivity().runOnUiThread(() -> {
                    switchMusic.setChecked(settings.musicEnabled);
                    if (settings.musicEnabled) {
                        mediaPlayer.start();
                    }
                });
            }
        }).start();

        switchMusic.setOnCheckedChangeListener((buttonView, isChecked) -> {
            new Thread(() -> {
                Settings settings = new Settings();
                settings.id = 1; // Ensure the ID is set to 1
                settings.musicEnabled = isChecked;
                database.settingsDao().update(settings);
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
}