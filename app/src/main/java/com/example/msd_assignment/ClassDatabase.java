/*
 Class that defines database
 */

package com.example.msd_assignment;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// retrieved from: https://developer.android.com/training/data-storage/room/prepopulate#java
// initialise database of data type class
@Database(entities = {ClassEntity.class}, version = 1)

public abstract class ClassDatabase extends RoomDatabase {

    public abstract ClassDao getClassDao();

    // retrieved from: https://www.youtube.com/watch?v=yuxIflGmeNE

//    public static ClassDatabase INSTANCE;
//
//    public static ClassDatabase getInstance(Context context){
//        if (INSTANCE == null){
//            INSTANCE = Room.databaseBuilder(context, ClassDatabase.class, "class-database")
//                    .allowMainThreadQueries()
//                    .fallbackToDestructiveMigration()
//                    .build();
//        }
//        return INSTANCE;
//    }
}
