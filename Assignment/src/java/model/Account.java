/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author QUANGANH
 */
public class Account {
    private String username;
    private String password;
    private String role;
    private String name;
    private Date dateOfBirth;
    private ArrayList<TimeSheet>timesheets;
    private Absence absences;
    private ArrayList<Date>absenceDates;
    private String division;
    private OverTime overtime;
    private LeaveDays leavedays;

    public Account(String username, String password, String role, String name, Date dateOfBirth) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public OverTime getOvertime() {
        return overtime;
    }

    public void setOvertime(OverTime overtime) {
        this.overtime = overtime;
    }

    public LeaveDays getLeavedays() {
        return leavedays;
    }

    public void setLeavedays(LeaveDays leavedays) {
        this.leavedays = leavedays;
    }

    public Absence getAbsences() {
        return absences;
    }

    public void setAbsences(Absence absences) {
        this.absences = absences;
    }

    public ArrayList<Date> getAbsenceDates() {
        return absenceDates;
    }

    public void setAbsenceDates(ArrayList<Date> absenceDates) {
        this.absenceDates = absenceDates;
    }

    public Account(String username, String password, String role, String name, Date dateOfBirth, ArrayList<TimeSheet> timesheets, String division) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.timesheets = timesheets;
        this.division = division;
    }
    
    public Account() {
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
    
    public ArrayList<TimeSheet> getTimesheets() {
        return timesheets;
    }

    public void setTimesheets(ArrayList<TimeSheet> timesheets) {
        this.timesheets = timesheets;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public int specialFunction(TimeSheet t){
        int count = 0;
        if(this.getAbsenceDates() != null && this.getAbsenceDates().size() >0 ){
            
            for(Date d : this.getAbsenceDates()){
                if(t.getDate().compareTo(d) == 0){
                    count = count+1;
                    break;
                }else {continue;}
            }
            if(count == 0){
                if(t.getCheckIn() != null && t.getCheckOut()!= null){
                    return 1;
                }
                else{
                    return 0;
                }
            }
            else{
                if(this.getAbsences().getTypeId()==1){
                    return 2;
                }
                else return 3;
            }
            
           
            
        }else{
             if(t.getCheckIn() != null && t.getCheckOut()!= null){
                    return 1;
                }
                else{
                    return 0;
                }
            
        }
       
        
    }
    
    
}
