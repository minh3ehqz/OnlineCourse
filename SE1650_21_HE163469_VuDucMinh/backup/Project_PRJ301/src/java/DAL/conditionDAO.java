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
import model.Condition;

/**
 *
 * @author WIN
 */
public class conditionDAO {

    private Connection con;
    private String status = "";

    public conditionDAO() {
        try {
            con = new DBcontext().getConnection();
            status = "ket noi thanh cong";
        } catch (Exception e) {
            status = "ket noi that bai";
        }
    }
    
    private ArrayList<Condition> cop ;

    public ArrayList<String> classCondition(String id) {
        ArrayList<String> c = new ArrayList<>();
        String sql = "select * from condition_HE163469 where classid=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c.add(rs.getString(2));
            }
        } catch (Exception e) {
        }
        return c;
    }
    
    

    public ArrayList<Condition> getCop() {
        return cop;
    }

    public void setCop(ArrayList<Condition> cop) {
        this.cop = cop;
    }
    
}

//class test{
//    public static void main(String[] args) {
//        conditionDAO co = new conditionDAO();
//        ArrayList<String> s = co.classCondition("SE1111");
//        for(String st : s){
//            System.out.println(st);
//        }
//    }
//}
