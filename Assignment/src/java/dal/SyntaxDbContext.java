/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Syntax;

/**
 *
 * @author QUANGANH
 */
public class SyntaxDbContext extends DBContext {

    public SyntaxDbContext() {
        super();
    }
    public ArrayList<Syntax> getSyntax(){
        String sql = "Select * from TimeKeepingSyntax";
        ArrayList<Syntax>syntaxes = new ArrayList<Syntax>();
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Syntax s = new Syntax();
                s.setName(rs.getString("Name"));
                s.setSyntax(rs.getString("Syntax"));
                syntaxes.add(s);
               
            }
             return syntaxes;
        }catch(Exception ex){
             Logger.getLogger(SyntaxDbContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
