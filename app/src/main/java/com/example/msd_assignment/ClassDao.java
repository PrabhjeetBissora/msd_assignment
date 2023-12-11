package com.example.msd_assignment;

import java.util.List;

public interface ClassDao {

    // INSERT INTO DATABASE
    void insertClass(Class c);

    // UPDATE DATABASE
    void updateClass(Class c);

    // DELETE FROM DATABASE
    void deleteClass(Class c);

    // SELECT * FROM DATABASE

    List<Class> getAllClasses();
}
