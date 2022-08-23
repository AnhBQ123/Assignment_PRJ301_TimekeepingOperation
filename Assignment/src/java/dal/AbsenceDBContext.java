/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Absence;

/**
 *
 * @author QUANGANH
 */
public class AbsenceDBContext extends DBContext {

    public AbsenceDBContext() {
        super();
    }
    
    public ArrayList<Date> getListDateAbsence(String username, int month,int year){
        String sql = "Select * from Absence where StaffUsername = ? and Month([From]) = ? and Year([From]) = ? order by AId asc ";
        ArrayList<Date>dates = new ArrayList<Date>();
        ArrayList<Absence> absences = new ArrayList<Absence>();
        try{
            PreparedStatement st =connection.prepareStatement(sql);
            st.setString(1,username);
            st.setInt(2, month);
            st.setInt(3, year);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                Absence a = new Absence();
                a.setaId(rs.getInt("AId"));
                a.setFrom(rs.getDate("From"));
                a.setTo(rs.getDate("To"));
                a.setUsername(username);
                a.setTypeId(rs.getInt("TypeId"));
                absences.add(a);               
            }
                    
        }catch(Exception ex){
            Logger.getLogger(AbsenceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Absence a : absences){ 
            Calendar calendar = Calendar.getInstance();
             calendar.setTime(a.getFrom());

            while (calendar.getTime().before(a.getTo()))
            {
                Date result = new Date(calendar.getTime().getTime());
                dates.add(result);
                calendar.add(Calendar.DATE, 1);
            }
        }
        return dates;
    }
    public Absence getAbsence(String username, int month,int year){
        Absence a = new Absence();
        String sql = "Select * from Absence where StaffUsername = ? and Month([From]) = ? and Year([From]) = ? order by AId asc ";
        try{
            PreparedStatement st =connection.prepareStatement(sql);
            st.setString(1,username);
            st.setInt(2, month);
            st.setInt(3, year);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                
                a.setaId(rs.getInt("AId"));
                a.setFrom(rs.getDate("From"));
                a.setTo(rs.getDate("To"));
                a.setUsername(username);
                a.setTypeId(rs.getInt("TypeId"));
                              
            }
                    
        }catch(Exception ex){
            Logger.getLogger(AbsenceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
}
