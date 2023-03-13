/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DATABASE.DBcontext;
import model.*;
import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;

public class processDAO {

    private Connection con;
    private String status = "";

    public processDAO() {
        try {
            con = new DBcontext().getConnection();
            status = "ket noi thanh cong";
        } catch (Exception e) {
            status = "ket noi that bai";
        }
    }

    private ArrayList<process> p;
    private ArrayList<ClassR> v;

    public void loadProcess(String stID) {
        p = new ArrayList<>();
        String sql = "select * from process_HE163469 where studentID=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, stID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.add(new process(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (Exception e) {
        }
    }

    public void viewProcess(ArrayList<process> p, String stid) {
        v = new ArrayList<>();
        String sql = "select distinct cl.classID,cl.DepartID,cl.title,pr.status \n"
                + "from class_HE163469 cl , process_HE163469 pr \n"
                + "where cl.classID=? and pr.classID=cl.classID and pr.studentID=?";

        for (process pr : p) {
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, pr.getClassID());
                ps.setString(2, stid);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    v.add(new ClassR(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
                }
            } catch (Exception e) {
            }
        }
    }

    public void insert(String classID, String stID) {
        String sql = "insert into process_HE163469 values(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, classID);
            ps.setString(2, stID);
            ps.setInt(3, 0);
            ps.executeUpdate();
        } catch (Exception e) {
            status = "process thanh cong";
        }
    }

    public void deletePro(String id) {
        String sql = "delete process_HE163469 where classID=? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public process checkCon(String id, String classid) {
        String sql = "select * from process_HE163469 where classID=? and studentID=? and status=1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, classid);
            ps.setString(2, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new process(rs.getString(1), rs.getString(2), rs.getInt(3));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList<student> mentorlis(String clid) {
        ArrayList<student> v = new ArrayList<>();
        String sql = "select pr.classID,st.ID,st.Name,st.gender,st.DepartID,st.phoneNumber,st.email,pr.status from process_HE163469 pr , Student_HE163469 st\n"
                + "where pr.classID=? and pr.studentID=st.ID";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, clid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                v.add(new student(rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return v;
    }

    public void updatepr(int st, String clid, String stid) {
        String sql = "update process_HE163469 set status=? where classID=? and studentID=?";
        String sql_2="delete process_HE163469 where "
                + "classID in (select classid from condition_HE163469 where conditionid=?) "
                + "and studentID =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            PreparedStatement ps1 = con.prepareStatement(sql_2);
            ps.setInt(1, st);
            ps.setString(2, clid);
            ps.setString(3, stid);
            ps1.setString(1, clid);
            ps1.setString(2, stid);
            ps.executeUpdate();
            ps1.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
    
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<process> getP() {
        return p;
    }

    public void setP(ArrayList<process> p) {
        this.p = p;
    }

    public ArrayList<ClassR> getV() {
        return v;
    }

    public void setV(ArrayList<ClassR> v) {
        this.v = v;
    }

}

//class t {
//
//    public static void main(String[] args) {
//        processDAO pr = new processDAO();
//        pr.loadProcess("HF1");
//        pr.viewProcess(pr.getP());
//        for(ClassR c : pr.getV()){
//            System.out.println(c);
//        }
//    }
//}
