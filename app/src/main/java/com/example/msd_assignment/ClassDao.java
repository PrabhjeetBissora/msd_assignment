package com.example.msd_assignment;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import java.util.List;

public interface ClassDao {

    // INSERT INTO DATABASE
    @Insert
    void insertClass(Class c);

    // UPDATE DATABASE
    @Update
    void updateClass(Class c);

    // DELETE FROM DATABASE
    @Delete
    void deleteClass(Class c);

    // SELECT * FROM DATABASE
    List<Class> getAllClasses();
}
