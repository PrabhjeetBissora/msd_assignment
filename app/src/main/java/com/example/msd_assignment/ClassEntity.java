/*
 class that contains parameters of Class
 */

package com.example.msd_assignment;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ClassEntity {

    // constructor for 0 args passed
    public ClassEntity() {

    }
    // using encapsulation
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // variables

    @PrimaryKey
    @NonNull
    private String code;
    private String name;
    private String type;
    private String startTime;
    private String endTime;
    private String location;
    private String date;

    // constructor

    public ClassEntity(@NonNull String code, String name, String type, String startTime, String endTime, String location, String date) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.date = date;
    }

}
