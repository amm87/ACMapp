package com.acm.njit.acm_tutoring;




public class Tutor {
    //Represents one instance of a tutor tutoring on a certain day, NOT a tutor with all of his/her hours

    String name;
    String[] tutoredClasses;
    int dayWorked;
    String timeWorked; //Structured "10:00 16:15" 24-hour clock!

    public Tutor(String name, String[] tutoredClasses, int dayWorked, String timeWorked) {
        this.name = name;
        this.tutoredClasses = tutoredClasses;
        this.dayWorked = dayWorked;
        this.timeWorked = timeWorked;
    }

    public Tutor(String name, int dayWorked, String timeWorked) {
        this.name = name;
        String[] defaultTutor = new String[1];
        defaultTutor[0] = "CS 100";
        this.tutoredClasses = defaultTutor;
        this.dayWorked = dayWorked;
        this.timeWorked = timeWorked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getTutoredClasses() {
        return tutoredClasses;
    }

    public void setTutoredClasses(String[] tutoredClasses) {
        this.tutoredClasses = tutoredClasses;
    }

    public int getDayWorked() {
        return dayWorked;
    }

    public void setDayWorked(int dayWorked) {
        this.dayWorked = dayWorked;
    }

    public String getTimeWorked() {
        return timeWorked;
    }

    public void setTimeWorked(String timeWorked) {
        this.timeWorked = timeWorked;
    }
}
