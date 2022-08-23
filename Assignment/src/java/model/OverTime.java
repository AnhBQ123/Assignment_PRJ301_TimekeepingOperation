/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author QUANGANH
 */
public class OverTime {
    private float workingHolidays;
    private float workingDaysOff;   
    private float overTimeNormalDayE;
    private float overTimeNormalDayN;
    private String staffUsername;
    private int month;
    private int year;

    public OverTime() {
    }

    
    public float getWorkingHolidays() {
        return workingHolidays;
    }

    public void setWorkingHolidays(float workingHolidays) {
        this.workingHolidays = workingHolidays;
    }

    public float getWorkingDaysOff() {
        return workingDaysOff;
    }

    public void setWorkingDaysOff(float workingDaysOff) {
        this.workingDaysOff = workingDaysOff;
    }

    public float getOverTimeNormalDayE() {
        return overTimeNormalDayE;
    }

    public void setOverTimeNormalDayE(float overTimeNormalDayE) {
        this.overTimeNormalDayE = overTimeNormalDayE;
    }

    public float getOverTimeNormalDayN() {
        return overTimeNormalDayN;
    }

    public void setOverTimeNormalDayN(float overTimeNormalDayN) {
        this.overTimeNormalDayN = overTimeNormalDayN;
    }

    public String getStaffUsername() {
        return staffUsername;
    }

    public void setStaffUsername(String staffUsername) {
        this.staffUsername = staffUsername;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    
}
