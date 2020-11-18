package com.tamzid.sleep.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tamzid.sleep.R;
import com.tamzid.sleep.view.fragments.HomeFragment;
import com.tamzid.sleep.view.fragments.ProfileFragment;
import com.tamzid.sleep.view.fragments.SongListFragment;

public class MainActivity extends AppCompatActivity implements SongListFragment.SongListFragmentListener, ProfileFragment.ProfileFragmentListener {
    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ColorStateList iconsAndTextColorStates = new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_checked},
                        new int[]{android.R.attr.state_checked}
                },
                new int[]{
                        Color.parseColor("#98A1BD"),
                        Color.parseColor("#ffffff")
                });
        navigation.setItemIconTintList(iconsAndTextColorStates);
        navigation.setItemTextColor(iconsAndTextColorStates);
        navigation.setSelectedItemId(R.id.navigation_home);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            Bundle bundle = new Bundle();
            SongListFragment fragobj = new SongListFragment();

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_sleep:
                    bundle.putString("title", "Sleep Music");
                    fragobj.setArguments(bundle);
                    loadFragment(fragobj);
                    return true;
                case R.id.navigation_meditate:
                    bundle.putString("title", "Meditate Music");
                    fragobj.setArguments(bundle);
                    loadFragment(fragobj);
                    return true;
                case R.id.navigation_music:
                    bundle.putString("title", "Music");
                    fragobj.setArguments(bundle);
                    loadFragment(fragobj);
                    return true;
                case R.id.navigation_afsar:
                    fragment = new ProfileFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment,"main_fragment");
//        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackButtonClickSongListFragment() {
//        loadFragment(new HomeFragment());
        navigation.setSelectedItemId(R.id.navigation_home);
    }
}