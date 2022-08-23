/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.TimeSheet;

/**
 *
 * @author QUANGANH
 */
public class AccountDBContext extends DBContext {
    public AccountDBContext(){
        super();
        
    }
//    public null isLogin(String username, String password) throws SQLException{
//        String sql = "Select * from Staff where StaffUsername =?,StaffPassword = ?";
//        PreparedStatement stm = connection.prepareStatement(sql);
//        stm.setString(1, username);
//        stm.setString(2, password);
//        ResultSet rs = stm.executeQuery();
//    }
    public ArrayList<Account> getListAccount(){
        String sql = "Select * from Staffs";
        
        ArrayList<Account> accounts = new ArrayList<Account>();
        try{
            PreparedStatement stm = connection.prepareStatement(sql);        
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Account a = new Account();
                a.setUsername(rs.getString(1));
                a.setPassword(rs.getString(2));
                a.setName(rs.getNString(3));
                a.setDateOfBirth(rs.getDate(4));
                a.setDivision(rs.getString("Division"));
                a.setTimesheets(new ArrayList<TimeSheet>());
                a.setAbsenceDates(new ArrayList<Date>());
                accounts.add(a);
            }
        }catch(Exception ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(accounts.size() > 0){
            return accounts;
        } 
        else return null;       
    }
    
    
}
