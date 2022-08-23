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
import model.TimeSheet;

/**
 *
 * @author QUANGANH
 */
public class DaysLeaveDBContext extends DBContext {

    public DaysLeaveDBContext() {
        super();
    }
    public LeaveDays getDaysLeaveByMY(String username,int month,int year){
        String sql = "Select * from DaysLeave where month = ? and StaffUsername = ? and year = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,month);
            st.setString(2,username);
            st.setInt(3,year);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
               LeaveDays ld = new LeaveDays();
               
                ld.setWorkingSunday(rs.getFloat("WorkingSunday"));
                ld.setWorkingHoliday(rs.getFloat("WorkingHoliday"));
                ld.setBussinessTravel(rs.getFloat("BussinessTravel"));
                ld.setCompensatoryLeave(rs.getFloat("CompensatoryLeave"));
                ld.setRegime(rs.getFloat("Regime"));
                ld.setDaysLeave(rs.getFloat("DaysLeave"));
                ld.setStaffUsername(rs.getString("StaffUsername"));
                ld.setMonth(month);
                ld.setYear(year);
                return ld;
            }
            
        }catch(Exception ex){
            Logger.getLogger(DaysLeaveDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
