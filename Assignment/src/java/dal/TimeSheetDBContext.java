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
import model.TimeSheet;

/**
 *
 * @author QUANGANH
 */
public class TimeSheetDBContext extends DBContext {

    public TimeSheetDBContext() {
        super();
    }
    public ArrayList<TimeSheet> getListTimeSheetByMonth(String username,int month){
        String sql = "Select * from TimeSheet where Month(Date) = ? and StaffUsername = ? and DATEPART(WEEKDAY,Date) != 1 and DATEPART(WEEKDAY,Date) !=7 order by Date asc";
        ArrayList<TimeSheet> tsheets = new ArrayList<TimeSheet>();
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,month);
            st.setString(2,username);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                TimeSheet ts = new TimeSheet();
                ts.settId(rs.getInt(1));
                ts.setStaffUsername(username);
                ts.setDate(rs.getDate("Date"));
                ts.setCheckIn(rs.getTime("CheckIn"));
                ts.setCheckOut(rs.getTime("CheckOut"));
                tsheets.add(ts);
            }
            return tsheets;
        }catch(Exception ex){
            Logger.getLogger(TimeSheetDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
