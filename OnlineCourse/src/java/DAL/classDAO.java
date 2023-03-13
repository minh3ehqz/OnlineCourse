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
import java.util.List;
import model.*;

/**
 *
 * @author WIN
 */
public class classDAO {

    private Connection con;
    private String status = "";

    public classDAO() {
        try {
            con = new DBcontext().getConnection();
            status = "ket noi thanh cong";
        } catch (Exception e) {
            status = "ket noi that bai";
        }
    }
    private ArrayList<ClassR> stClass;
    private ArrayList<ClassR> topclass;
    private ArrayList<ClassR> userclass;

    public void loadClass() {
        stClass = new ArrayList<>();
        String sql = "SELECT * from class_HE163469";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String Did = rs.getString(2);
                String title = rs.getString(3);
                String images = rs.getString(4);
                stClass.add(new ClassR(id, Did, title, images));
            }
        } catch (Exception e) {
            status = e.getMessage();
        }
    }

    public void loadTop() {
        topclass = new ArrayList<>();
        String sql = "SELECT top(4) * from class_HE163469 order by classID desc";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String Did = rs.getString(2);
                String title = rs.getString(3);
                String images = rs.getString(4);
                topclass.add(new ClassR(id, Did, title, images));
            }
        } catch (Exception e) {
            status = "top class " + e.getMessage();
        }
    }

    public void loadTopClassUser(String depid) {
        userclass = new ArrayList<>();
        String sql = "select top(4) * from class_HE163469 where DepartID=? order by classID desc";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, depid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                userclass.add(new ClassR(rs.getString(1), depid, rs.getString(3), rs.getString(4)));
            }
        } catch (Exception e) {
        }
    }

    public int getTotalClass() {
        String sql = "select count(*) from class_HE163469";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<ClassR> pageindex(int index) {
        List<ClassR> lista = new ArrayList<>();
        String sql = "select * from class_HE163469\n"
                + "order by classID\n"
                + "offset ? rows fetch next 10 rows only";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new ClassR(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List<ClassR>  loadMentor(String id){
        List<ClassR> list = new ArrayList<>();
        String sql = "select * from class_HE163469 where mentor=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new ClassR(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void deleteClass(String id) {
        String sql = "delete class_HE163469 where classID=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ClassR classbyID(String id) {
        String sql = "select * from class_HE163469 where classID=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new ClassR(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public ClassR classbyIDM(String id) {
        String sql = "select * from class_HE163469 where classID=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new ClassR(rs.getString(1).trim(), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void updateCl(String id, String deID, String ti, String im) {
        String sql = "update class_HE163469 set DepartID=?,title=?,images=? where classID =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, deID);
            ps.setString(2, ti);
            ps.setString(3, im);
            ps.setString(4, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ArrayList<ClassR> search(String s) {
        String sql = "SELECT * from class_HE163469 where title like ?";
        ArrayList<ClassR> cl = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + s + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cl.add(new ClassR(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (Exception e) {
        }
        return cl;
    }

    public void insertCl(String id, String deid, String title, String im) {
        String sql = "INSERT INTO class_HE163469 values(?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, deid);
            ps.setString(3, title);
            ps.setString(4, im);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ArrayList<ClassR> getUserclass() {
        return userclass;
    }

    public void setUserclass(ArrayList<ClassR> userclass) {
        this.userclass = userclass;
    }

    public ArrayList<ClassR> getTopclass() {
        return topclass;
    }

    public void setTop_class(ArrayList<ClassR> top_class) {
        this.topclass = top_class;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<ClassR> getStClass() {
        return stClass;
    }

    public void setStClass(ArrayList<ClassR> stClass) {
        this.stClass = stClass;
    }

}
//class t1 {
//
//    public static void main(String[] args) {
//        classDAO d = new classDAO();
//        List <ClassR> r =d.pageindex(1);
//        System.out.println(d.classbyIDM("SE1111").getMentor());
//    }
//}
