/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dal;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import helper.TimeHelper;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import model.TimeSheet;

/**
 *
 * @author QUANGANH
 */
public class TestClass extends DBContext {

    public TestClass() {
        super();
    }
    
    public Time getTime(Date date,String username){
        String sql = "Select [CheckIn],[CheckOut] from TimeSheet where Date = ? and StaffUsername = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDate(1, date);
            st.setString(2, username);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                 long x = rs.getTime(2).getTime() - rs.getTime(1).getTime();
                 System.out.println(x/1000);
                 System.out.println(x/(60*1000));
                 System.out.println(x/(60*60*1000));
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return null;
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DaysLeaveDBContext a = new DaysLeaveDBContext();
        System.out.println(a.getDaysLeaveByMY("anhbq", 8, 2022).getBussinessTravel());
    }
    
}
