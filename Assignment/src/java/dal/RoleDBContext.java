/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QUANGANH
 */
public class RoleDBContext extends DBContext{
      
    RoleDBContext(){
        super();
    }
    public int getRoleIdByUsername(String username){
        String sql = "Select sr.RoleId from StaffRoles where StaffUsername = '"+username+"'";
         int roleId = 0;
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                roleId =  rs.getInt(1);
                break;
            }
        } catch (Exception ex) {
            Logger.getLogger(RoleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roleId;
    }
}
