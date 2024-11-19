package com.example.learnmath;


import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.viewpager.widget.ViewPager;

import com.example.learnmath.fragment.ViewPagerAdapter;
import com.example.learnmath.thucthe.AppDatabase;
import com.example.learnmath.thucthe.Settings;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ManHinhChinh extends AppCompatActivity {

    private static AppDatabase database;
    private ViewPager mViewPager;
    private BottomNavigationView mBottomNavigationView;
    private MediaPlayer mediaPlayer;

    public static AppDatabase getDatabase() {
        return database;
    }

    protected void loadSettings() {
        new Thread(() -> {
            Settings settings = database.settingsDao().getSettings(1);
            if (settings != null) {
                runOnUiThread(() -> {
                    // Apply settings (e.g., enable/disable music)
                    if (settings.musicEnabled) {
                        mediaPlayer.start();
                    } else {
                        mediaPlayer.pause();
                    }
                });
            }
        }).start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "app_database").build();

        // Initialize MediaPlayer and start playing background music
        mediaPlayer = MediaPlayer.create(this, R.raw.bg);
        mediaPlayer.setLooping(true); // Set looping
        setContentView(R.layout.activity_man_hinh_chinh);

        // check if the settings are saved in the database
        new Thread(() -> {
            Settings settings = database.settingsDao().getSettings(1);
            if (settings == null) {
                // if not, save the default settings
                database.settingsDao().insert(new Settings());
            } else {
                // if yes, load the settings
                loadSettings();
            }
        }).start();


        mViewPager = findViewById(R.id.view_pager);
        mBottomNavigationView = findViewById(R.id.bottom_navigation);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(adapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Do nothing
            }

            @Override
            public void onPageSelected(int position) {
                mBottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // Do nothing
            }
        });

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_tab_1) {
                    mViewPager.setCurrentItem(0);
                    return true;
                } else if (item.getItemId() == R.id.menu_tab_2) {
                    mViewPager.setCurrentItem(1);
                    return true;
                } else if (item.getItemId() == R.id.menu_tab_3) {
                    mViewPager.setCurrentItem(2);
                    return true;
                }

                return false;
            }
        });
    }
}