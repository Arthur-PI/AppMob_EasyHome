package fr.appmob.easyhome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bottomNavigationView = findViewById(R.id.activity_main_bottom_navigation);
        this.configureBottomView();
    }
    private void configureBottomView(){
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> updateMainFragment(item.getItemId()));
    }


    private Boolean updateMainFragment(Integer integer){
        switch (integer) {
            case R.id.menu_1:

                break;
            case R.id.menu_2:
                Intent mainActivity= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainActivity);

                break;
            case R.id.menu_3:
                Intent favoriteActivity= new Intent(getApplicationContext(),FavoriteActivity.class);
                startActivity(favoriteActivity);

                break;
        }
        return true;
    }
}