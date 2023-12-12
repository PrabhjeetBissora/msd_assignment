/*
activity that initialises database for project
 */

package com.example.msd_assignment;

import android.app.Application;

import androidx.room.Room;

public class ClassApplication extends Application {

    // initialise database
    public static ClassDatabase classDatabase;

    @Override
    public void onCreate(){
        super.onCreate();

        // retrieved from: https://developer.android.com/reference/android/arch/persistence/room/Room
        // build database
        classDatabase = Room.databaseBuilder(getApplicationContext(),
                ClassDatabase.class, "class-database")
                .build();
    }

}
