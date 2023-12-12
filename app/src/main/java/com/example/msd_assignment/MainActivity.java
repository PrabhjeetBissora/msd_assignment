/*
activity that is initialised at start.  Has four buttons that each lead to their respective fragments
 */

package com.example.msd_assignment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.msd_assignment.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    // declare database to use
    static ClassDatabase classDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RoomDatabase.Callback myCallBack = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }
        };

        classDatabase = Room.databaseBuilder(getApplicationContext(), ClassDatabase.class, "ClassDB")
                .addCallback(myCallBack)
                .allowMainThreadQueries()
                .build();

        // retrieved from: https://stackoverflow.com/questions/62061386/illegalargumentexception-id-does-not-reference-a-view-inside-this-activity

        // Find the NavHostFragment
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_container);

        if (navHostFragment != null) {

            // Get the NavController from the NavHostFragment
            NavController navController = navHostFragment.getNavController();
        }
        else{
            Log.e("MainActivity", "NavHostFragment is null"); // program crashes
        }

        // declare title of applictaion
        TextView textView = findViewById(R.id.welcomeTitle);

        // declare buttons in main page
        Button addButton = findViewById(R.id.addButton);
        Button deleteButton = findViewById(R.id.deleteButton);
        Button modifyButton = findViewById(R.id.modifyButton);
        Button viewButton = findViewById(R.id.viewButton);

        // direct to add page
        if (addButton != null) {
            addButton.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                public void onClick(View it) {
                    // displaying a toast message
                    Toast.makeText((Context) MainActivity.this, "You just clicked on Add Button", Toast.LENGTH_LONG).show();
                    Log.e("MainActivity", "xxxx");
                    //openAddActivity();
                    // Navigate to the AddClass fragment using the Navigation component

                    //NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_container);
                    //navController.navigate(R.id.action_MainActivity_to_AddClass);

                    // referenced from: https://developer.android.com/reference/android/app/FragmentTransaction

                    // Create FragmentManager to navigate to fragment
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    // retrieved from: https://stackoverflow.com/questions/52037634/making-a-button-disappear-after-clicking-another-button
                    // switch to next view
                    addButton.setVisibility(View.GONE);
                    addButton.setClickable(false);
                    deleteButton.setVisibility(View.GONE);
                    deleteButton.setClickable(false);
                    modifyButton.setVisibility(View.GONE);
                    modifyButton.setClickable(false);
                    viewButton.setVisibility(View.GONE);
                    viewButton.setClickable(false);
                    textView.setVisibility(View.GONE);

                    // Replace the current fragment with AddClass fragment
                    fragmentTransaction.replace(R.id.nav_host_container, new AddClass());
                    fragmentTransaction.commit();
                }
            }));
        }

        // direct to delete page
        if (deleteButton != null) {
            deleteButton.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                public final void onClick(View it) {
                    // displaying a toast message
                    //Toast.makeText((Context) MainActivity.this, "You just clicked on Delete Button", Toast.LENGTH_LONG).show();
                    Log.e("MainActivity", "You just clicked on Delete Button");

                    // Create FragmentManager to navigate to fragment
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    ClassEntity c1 = new ClassEntity();
                    ClassEntity c2 = new ClassEntity();
                    c1.setCode("CMPU2022");
                    c2.setCode("LLLLOLLL");

                    classDatabase.getClassDao().insertClass(c1);
                    classDatabase.getClassDao().insertClass(c2);

                    // retrieved from: https://stackoverflow.com/questions/52037634/making-a-button-disappear-after-clicking-another-button
                    // switch to next view
//                    addButton.setVisibility(View.GONE);
//                    addButton.setClickable(false);
//                    deleteButton.setVisibility(View.GONE);
//                    deleteButton.setClickable(false);
//                    modifyButton.setVisibility(View.GONE);
//                    modifyButton.setClickable(false);
//                    viewButton.setVisibility(View.GONE);
//                    viewButton.setClickable(false);
//                    textView.setVisibility(View.GONE);

                    // Replace the current fragment with AddClass fragment
//                    fragmentTransaction.replace(R.id.nav_host_container, new DeleteClass());
//                    fragmentTransaction.commit();
                }
            }));
        }

        // direct to modify page
        if (modifyButton != null) {
            modifyButton.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                public final void onClick(View it) {
                    // displaying a toast message
                    Toast.makeText((Context) MainActivity.this, "You just clicked on Modify Button", Toast.LENGTH_LONG).show();
                    Log.e("MainActivity", "xxxx");

                    // Create FragmentManager to navigate to fragment
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    // retrieved from: https://stackoverflow.com/questions/52037634/making-a-button-disappear-after-clicking-another-button
                    // switch to next view
                    addButton.setVisibility(View.GONE);
                    addButton.setClickable(false);
                    deleteButton.setVisibility(View.GONE);
                    deleteButton.setClickable(false);
                    modifyButton.setVisibility(View.GONE);
                    modifyButton.setClickable(false);
                    viewButton.setVisibility(View.GONE);
                    viewButton.setClickable(false);
                    textView.setVisibility(View.GONE);

                    // Replace the current fragment with AddClass fragment
//                    fragmentTransaction.replace(R.id.nav_host_container, new ModifyClass());
//                    fragmentTransaction.commit();
                }
            }));
        }

        // direct to view page
        if (viewButton != null) {
            viewButton.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                public final void onClick(View it) {
                    // displaying a toast message
                    //Toast.makeText((Context) MainActivity.this, "You just clicked on View Button", Toast.LENGTH_LONG).show();

                    Log.e("MainActivity", "line1");

                    // Create FragmentManager to navigate to fragment
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    Log.e("MainActivity", "line2");

//                    List<ClassEntity> classList = classDatabase.getClassDao().getAllClasses();
//
//                    StringBuilder sb = new StringBuilder();
//                    for(ClassEntity c : classList){
//                        sb.append(c.getCode());
//                        sb.append("\n");
//                    }
//                    String output = sb.toString();
//                    Toast.makeText((Context) MainActivity.this, output, Toast.LENGTH_LONG).show();

                    // retrieved from: https://stackoverflow.com/questions/52037634/making-a-button-disappear-after-clicking-another-button
                    // switch to next view
                    addButton.setVisibility(View.GONE);
                    addButton.setClickable(false);
                    deleteButton.setVisibility(View.GONE);
                    deleteButton.setClickable(false);
                    modifyButton.setVisibility(View.GONE);
                    modifyButton.setClickable(false);
                    viewButton.setVisibility(View.GONE);
                    viewButton.setClickable(false);
                    textView.setVisibility(View.GONE);

                    Log.e("MainActivity", "line3");

                    // Replace the current fragment with AddClass fragment
                    fragmentTransaction.replace(R.id.nav_host_container, new ViewClass());

                    Log.e("MainActivity", "line4");
                    fragmentTransaction.commit();
                }
            }));
        }
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

    public static void insertIntoDB(ClassEntity c){
        classDatabase.getClassDao().insertClass(c);
    }

    public static void updateDB(ClassEntity c){
        classDatabase.getClassDao().updateClass(c);
    }

    public static void deleteFromDB(ClassEntity c){
        classDatabase.getClassDao().deleteClass(c);
    }

    public static List<ClassEntity> viewDB(){
        List<ClassEntity> classList = classDatabase.getClassDao().getAllClasses();
        return classList;
    }
}