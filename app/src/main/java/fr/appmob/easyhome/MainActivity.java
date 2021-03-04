package fr.appmob.easyhome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.activity_main_bottom_navigation);
        this.configureBottomView();
    }

    private void configureBottomView(){
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> updateMainFragment(item.getItemId()));
    }

    private Boolean updateMainFragment(Integer integer){
        switch (integer) {
            case R.id.menu_1:
                Intent profileActivity= new Intent(getApplicationContext(),ProfileActivity.class);
                startActivity(profileActivity);
                finish();
                break;
            case R.id.menu_2:

                break;
            case R.id.menu_3:
                Intent favoriteActivity= new Intent(getApplicationContext(),FavoriteActivity.class);
                startActivity(favoriteActivity);
                finish();
                break;
        }
        return true;
    }
}
