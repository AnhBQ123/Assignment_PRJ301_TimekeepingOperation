/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.LeaveDays;
import model.OverTime;
import model.TimeSheet;

/**
 *
 * @author QUANGANH
 */
public class OverTimeDBContext extends DBContext {

    public OverTimeDBContext() {
        super();
    }
    public OverTime getOverTimeByMY(String username,int month,int year){
        String sql = "Select * from OverTime where month = ? and StaffUsername = ? and year = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,month);
            st.setString(2,username);
            st.setInt(3,year);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
               OverTime ot = new OverTime();
               
                ot.setWorkingHolidays(rs.getFloat("WorkingHolidays"));
                ot.setWorkingDaysOff(rs.getFloat("WorkingDaysOff"));
                ot.setOverTimeNormalDayE(rs.getFloat("OverTimeNormalDayE"));
                ot.setOverTimeNormalDayN(rs.getFloat("OverTimeNormalDayN"));
                ot.setStaffUsername(rs.getString("StaffUsername"));
                ot.setMonth(month);
                ot.setYear(year);
                return ot;
            }
            
        }catch(Exception ex){
            Logger.getLogger(DaysLeaveDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
