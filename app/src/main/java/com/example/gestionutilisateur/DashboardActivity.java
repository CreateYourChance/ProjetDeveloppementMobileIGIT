package com.example.gestionutilisateur;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class DashboardActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private ActionBar actionBar;
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        actionBar = getSupportActionBar();
        if (actionBar !=null){
            actionBar.setTitle("Profile Activity");
        }
        firebaseAuth = FirebaseAuth.getInstance();

        navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this::handleNavigationSelection);
        if (actionBar !=null){
            actionBar.setTitle("Home");

        }

        // Show the home fragment when the application is first opened
        displayFragment(new HomeFragment());
    }

    private boolean handleNavigationSelection(MenuItem menuItem) {
        int itemId = menuItem.getItemId();

        if (itemId == R.id.nav_home ) {
            if (actionBar != null){
                actionBar.setTitle("Home");
            }

            displayFragment(new HomeFragment());
            return true;
        } else if (itemId == R.id.nav_profile ) {
            if (actionBar != null){
                actionBar.setTitle("Profile");
            }
            displayFragment(new ProfileFragment());
            return true;
        } else if (itemId == R.id.nav_users) {
            if (actionBar != null){
                actionBar.setTitle("Users");
            }
            displayFragment(new UsersFragment());
            return true;
        } else if (itemId == R.id.nav_chat) {
            if (actionBar != null){
                actionBar.setTitle("Chats");
            }
            displayFragment(new ChatListFragment());
            return true;
        } else if (itemId == R.id.nav_addblogs) {
            if (actionBar != null){
                actionBar.setTitle("Add Blogs");
            }
            displayFragment(new AddBlogFragment());
            return true;
        } else {
            return false;
        }
    }

    private void displayFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment, "");
        fragmentTransaction.commit();
    }
}
