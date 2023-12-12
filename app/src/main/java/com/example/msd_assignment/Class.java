package com.example.msd_assignment;

public class Class { // using encapsulation
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

    // constructor

    public Class(String code, String name, String type, String startTime, String endTime) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    private String code;
    private String name;
    private String type;
    private String startTime;
    private String endTime;

}
