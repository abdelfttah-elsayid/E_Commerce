package com.example.e_commerce.ui;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.e_commerce.R;
import com.example.e_commerce.databinding.ActivityMainBinding;
import com.example.e_commerce.ui.fragments.CategoriesFragment;
import com.example.e_commerce.ui.fragments.FavoritesFragment;
import com.example.e_commerce.ui.fragments.HomeFragment;
import com.example.e_commerce.ui.fragments.SearchFragment;
import com.example.e_commerce.ui.fragments.SettingsFragment;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        showFragments(new HomeFragment());
        binding.bottomNavView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);

                if (item.getItemId()==R.id.item_home){
                    showFragments(new HomeFragment());
                   // changeAppBarName("Home");
                }
              else  if (item.getItemId() == R.id.item_categories){
                    showFragments(new CategoriesFragment());
//                    changeAppBarName("Categories");

                }
              else if (item.getItemId()==R.id.item_search){
                  showFragments(new SearchFragment());
                }
                else if (item.getItemId() == R.id.item_fav){
                    showFragments(new FavoritesFragment());
                   // changeAppBarName("Favorites");

                }
                else {
                    showFragments(new SettingsFragment());
                  //  changeAppBarName("Settings");

                }

                return false;
            }
        });
    }

    private void changeAppBarName(String name){

        getSupportActionBar().setTitle(name);

    }
    private void showFragments(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout , fragment)
                .commit();

    }
}