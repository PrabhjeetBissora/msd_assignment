package com.example.msd_assignment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.msd_assignment.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        // declare title of applictaion
        TextView textView = (TextView)findViewById(R.id.welcomeTitle);
        // textView.setText("AbhiAndroid"); //set text for text view

        // declare buttons in main page
        Button addButton = (Button)findViewById(R.id.addButton);
        Button deleteButton = (Button)findViewById(R.id.deleteButton);
        Button modifyButton = (Button)findViewById(R.id.modifyButton);
        Button viewButton = (Button)findViewById(R.id.viewButton);

        // direct to add page
        if (addButton != null) {
            addButton.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                public final void onClick(View it) {
                    // displaying a toast message
                    Toast.makeText((Context) MainActivity.this, "You just clicked on Add Button", Toast.LENGTH_LONG).show();
                    openAddActivity();
                }
            }));
        }

        // direct to delete page
        if (deleteButton != null) {
            deleteButton.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                public final void onClick(View it) {
                    // displaying a toast message
                    Toast.makeText((Context) MainActivity.this, "You just clicked on Delete Button", Toast.LENGTH_LONG).show();
                }
            }));
        }

        // direct to modify page
        if (modifyButton != null) {
            modifyButton.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                public final void onClick(View it) {
                    // displaying a toast message
                    Toast.makeText((Context) MainActivity.this, "You just clicked on Modify Button", Toast.LENGTH_LONG).show();
                }
            }));
        }

        // direct to view page
        if (viewButton != null) {
            viewButton.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                public final void onClick(View it) {
                    // displaying a toast message
                    Toast.makeText((Context) MainActivity.this, "You just clicked on View Button", Toast.LENGTH_LONG).show();
                }
            }));
        }

//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAnchorView(R.id.fab)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // go to add class page. Retrieved from: https://www.youtube.com/watch?v=bgIUdb-7Rqo
    public void openAddActivity() {
        //Toast.makeText((Context) MainActivity.this, "You just clicked on Add Button", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, DeleteClass.class);
        startActivity(intent);
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
}