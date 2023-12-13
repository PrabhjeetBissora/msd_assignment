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
@Database(entities = {ClassEntity.class}, version = 2)

public abstract class ClassDatabase extends RoomDatabase {

    public abstract ClassDao getClassDao();

}
