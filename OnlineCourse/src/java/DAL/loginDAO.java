/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DATABASE.DBcontext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author WIN
 */
public class loginDAO {

    private Connection con;
    
    public loginDAO() {
        try {
            con = new DBcontext().getConnection();
        } catch (Exception e) {
        }
    }


    public Acc checklog(String userName,String passWord){
        String sql = "select * from Student_HE163469 where UserName=? and password=? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2,passWord);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return new Acc(rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11),rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }
}

//class main{
//    public static void main(String[] args) {
//        loginDAO l = new loginDAO();
//        
//        System.out.println(l.checklog("admin", "123"));
//    }
//}
