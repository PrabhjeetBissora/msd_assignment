/*
 Class that initialises database
 */

package com.example.msd_assignment;

import androidx.room.Database;
import androidx.room.RoomDatabase;

// retrieved from: https://developer.android.com/training/data-storage/room/prepopulate#java
// initialise database of data type class
@Database(entities = {ClassEntity.class}, version = 1)

public abstract class ClassDatabase extends RoomDatabase {

    public abstract ClassDao classDao();
}
