/*
 interface that contains data access objects to be used for sqlite functions
 */

package com.example.msd_assignment;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ClassDao {

    // INSERT INTO DATABASE
    @Insert
    void insertClass(ClassEntity c);

    // UPDATE DATABASE
    @Update
    void updateClass(ClassEntity c);

    // DELETE FROM DATABASE
    @Delete
    void deleteClass(ClassEntity c);

    // SELECT * FROM DATABASE
    @Query("SELECT * FROM ClassEntity")
    List<ClassEntity> getAllClasses();
}
