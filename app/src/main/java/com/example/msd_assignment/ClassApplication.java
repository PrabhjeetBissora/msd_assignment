/*
activity that initialises database for project
 */

package com.example.msd_assignment;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class ClassApplication extends Application {

    // initialise database
    public static ClassDatabase classDatabase;

    @Override
    public void onCreate(){
        super.onCreate();

        // retrieved from: https://developer.android.com/reference/android/arch/persistence/room/Room
        // build database

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

        classDatabase = Room.databaseBuilder(getApplicationContext(),
                ClassDatabase.class, "class-database")
                .build();
    }

}
