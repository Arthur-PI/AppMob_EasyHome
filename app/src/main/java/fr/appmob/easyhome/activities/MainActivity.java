package fr.appmob.easyhome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    RecyclerView recyclerView;
    int currFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Needed to used the API
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        currFrag = 0;

        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.activity_main_bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    if (currFrag == item.getItemId()) return false;
                    Fragment selectedFragment = null;
                    String tag = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            currFrag = R.id.nav_home;
                            selectedFragment = new HomeFragment();
                            tag = "HOME";
                            break;
                        case R.id.nav_search:
                            currFrag = R.id.nav_search;
                            selectedFragment = new SearchFragment();
                            tag = "SEARCH";
                            break;
                        case R.id.nav_favourites:
                            currFrag = R.id.nav_favourites;
                            selectedFragment = new FavouritesFragment();
                            tag = "FAVOURITES";
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, selectedFragment, tag).commit();
                    return true;
                }
            };
}