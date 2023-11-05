package com.example.karigusan;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    ImageView backButton;
    TextView title;
    private TextView textView;
    private ImageView go;
    private ImageView heart;
    private DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        backButton = findViewById(R.id.back);
        title = findViewById(R.id.title_app);

    }


    public void showMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.menu);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.about) {
            Toast.makeText(this, "Choose about", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.fav) {

            dbHelper = new DBHelper(this); // Replace 'this' with the appropriate context if necessary
            List<String> savedFavorites = dbHelper.getAllFavoriteResorts();

            if (savedFavorites.isEmpty()) {
                Toast.makeText(this, "No favorites yet!", Toast.LENGTH_SHORT).show();
            } else {
                title.setText("FAVORITE");
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Favorites fragment = new Favorites(); // Replace with your actual fragment class
                fragmentTransaction.replace(R.id.fragmentContainerView2, fragment); // Replace R.id.fragment_container with your actual container ID
                fragmentTransaction.addToBackStack(null); // Add the transaction to the back stack
                fragmentTransaction.commit();
            }
            return true;
        } else {
            return false;
        }

    }


    public void back(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
        } else {
            Toast.makeText(this, "Already in Home Screen", Toast.LENGTH_SHORT).show();
        }


        go = findViewById(R.id.gobutton);
        go.setVisibility(View.INVISIBLE);

        title.setText("CN - KARIGUSAN");
    }



    @Override
    public void onBackPressed() {
        // Check if the fragment manager has any fragments in the back stack
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            // If there are fragments in the back stack, pop the back stack
            getSupportFragmentManager().popBackStack();
        } else {
            // If there are no fragments in the back stack, perform the default back button behavior
            super.onBackPressed();
        }


        go = findViewById(R.id.gobutton);
        go.setVisibility(View.INVISIBLE);
        title.setText("CN - KARIGUSAN");
    }



}