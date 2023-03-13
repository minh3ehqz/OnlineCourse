package DAL;

import DATABASE.DBcontext;
import model.*;
import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;

public class DAO {

    private Connection con;
    private String status = "";

    public DAO() {
        try {
            con = new DBcontext().getConnection();
            status = "ket noi thanh cong";
        } catch (Exception e) {
            status = "ket noi that bai";
        }
    }
    private ArrayList<student> stdHome;
    private ArrayList<Department> depart;

    public void loadStudent() {
        stdHome = new ArrayList<>();
        String sql = "SELECT  * FROM Student_HE163469";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                stdHome.add(new student(rs.getString(1), rs.getString(4), rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11)));
            }
        } catch (Exception e) {
            status = "loi khi doc student " + e.getMessage();
        }
    }

    public void delete(String id) {
        String sql = "delete Student_HE163469 where ID=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void deleteBymail(String email) {
        String sql = "delete Student_HE163469 where email=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void deleteDE(String id) {
        String sql = "delete Department_HE163469 where ID=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void loadDepart() {
        depart = new ArrayList<>();
        String sql = "SELECT * FROM Department_HE163469";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String DepartmentID = rs.getString(1).trim();
                String DepartmentName = rs.getString(2).trim();
                String tile = rs.getString(3).trim();
                String images = rs.getString(4).trim();
                depart.add(new Department(DepartmentID, DepartmentName, tile, images));
            }
        } catch (Exception e) {
            status = "loi doc Department " + e.getMessage();
        }
    }

    public void insertDE(String id, String name, String title, String im) {
        String sql = "INSERT INTO Department_HE163469 values(?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, title);
            ps.setString(4, im);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public student loadbyID(String id) {
        String sql = "SELECT * FROM Student_HE163469 where ID=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String idc = rs.getString(2).trim();
                int idn = rs.getInt(3);
                String name = rs.getString(4);
                return new student(rs.getString(1), idc, idn, name, rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11));
            }
        } catch (Exception e) {
            status = "loi khi doc student " + e.getMessage();
        }
        return null;
    }

    public student checkUser(String user) {
        String sql = "SELECT * FROM Student_HE163469 where UserName=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String idc = rs.getString(2).trim();
                int idn = rs.getInt(3);
                String name = rs.getString(4);
                return new student(rs.getString(1), idc, idn, name, rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11));
            }
        } catch (Exception e) {
            status = "loi khi doc student " + e.getMessage();
        }
        return null;
    }

    public Department departByID(String id) {
        String sql = "SELECT * FROM Department_HE163469 where ID=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Department(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (Exception e) {
            status = "loi doc Department " + e.getMessage();
        }
        return null;
    }

    public boolean checkPhone(String phone) {
        String sql = "SELECT * FROM Student_HE163469 where phoneNumber=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return false;
            }
        } catch (Exception e) {
            status = "loi khi doc student " + e.getMessage();
        }
        return true;
    }

    public boolean checkEmail(String email) {
        String sql = "SELECT * FROM Student_HE163469 where email=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return false;
            }
        } catch (Exception e) {
            status = "loi khi doc student " + e.getMessage();
        }
        return true;
    }

    public int getTotalST() {
        String sql = "select count(*) from Student_HE163469";
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

    public List<student> pageADindex(int index) {
        List<student> lista = new ArrayList<>();
        String sql = "select * from Student_HE163469\n"
                + "order by ID\n"
                + "offset ? rows fetch next 10 rows only";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new student(rs.getString(1), rs.getString(4), rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11)));
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int getTotalDe() {
        String sql = "select count(*) from Department_HE163469";
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

    public List<Department> pageDeAd(int index) {
        List<Department> lis = new ArrayList<>();
        String sql = "select * from Department_HE163469\n"
                + "order by ID\n"
                + "offset ? rows fetch next 10 rows only";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lis.add(new Department(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (Exception e) {
        }
        return lis;
    }

    public void InserUser(boolean gender, String dep, String name, String phone, String userName, String pass, String email) {
        String sql = "INSERT INTO Student_HE163469 values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, (gender ? "HM" : "HF") + String.valueOf(createID(gender)));
            ps.setString(2, (gender ? "HM" : "HF"));
            ps.setInt(3, createID(gender));
            ps.setString(4, name);
            ps.setBoolean(5, gender);
            ps.setString(6, dep);
            ps.setString(7, phone);
            ps.setString(8, userName);
            ps.setString(9, pass);
            ps.setString(10, email);
            ps.setInt(11, 1);
            ps.executeUpdate();
        } catch (Exception e) {
            status = "co loi insert " + e.getMessage();
        }
    }

    public void updateUser(String id, String name, String phone, String mail, boolean gender, String depart) {
        String sql = "update Student_HE163469\n"
                + "set Name =?,phoneNumber=?,email=?, gender = ? ,DepartID=?\n"
                + "where ID=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, mail);
            ps.setBoolean(4, gender);
            ps.setString(5, depart);
            ps.setString(6, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void upadtePassU(String pass, String id) {
        String sql = "update Student_HE163469\n"
                + "set password =?\n"
                + "where ID=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateAd(String userName, String mail, String pass, int active) {
        String sql = "update Student_HE163469\n"
                + "set password =?,email=?,active=?\n"
                + "where UserName=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, mail);
            ps.setInt(3, active);
            ps.setString(4, userName);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateDE(String id, String name, String title, String images) {
        String sql = "update Department_HE163469 set Name=?,title=?,images=? where ID=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, title);
            ps.setString(3, images);
            ps.setString(4, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public student createstID(String id) {
        String sql = "select * from Student_HE163469 where IDc=? and IDn=(select max(IDn) from Student_HE163469)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new student(rs.getString(1), rs.getString(2).trim(), rs.getInt(3), rs.getString(4), rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public int createID(boolean gender) {
        String id = "";
        if (gender) {
            id = "HM";
        } else {
            id = "HF";
        }

        return (createstID(id).getIDn() + 1);
    }

    public boolean validEmail(String emailAddress) {
        String regexPattern = "[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.compile(regexPattern).matcher(emailAddress).matches();
    }

    public boolean vailphone(String phone) {
        String pattern = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        return Pattern.compile(pattern).matcher(phone).matches();
    }

    public boolean Vail(String userName, String password, String repass, String phone, String email, String[] check) {
        if (checkUser(userName) != null) {
            check[0] = "tên đăng nhập đã tồn tại";
        }
        if (password.equals(repass) == false) {
            check[1] = "mật khẩu không khớp";
            check[2] = check[1];
        }
        if (!vailphone(phone)) {
            check[3] = "số điện thoại không hợp lệ";
        } else if (!checkPhone(phone)) {
            check[3] = "số điện thoạt đã tồn tại";
        }
        if (!validEmail(email)) {
            check[4] = "email sai định dạng";
        } else if (!checkEmail(email)) {
            check[4] = "email đã tồn tại";
        }

        for (String s : check) {
            if (!s.equals("")) {
                return false;
            }
        }
        return true;
    }

//    ______________________________________________________________________
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<student> getStdHome() {
        return stdHome;
    }

    public void setStdHome(ArrayList<student> std) {
        this.stdHome = std;
    }

    public ArrayList<Department> getDepart() {
        return depart;
    }

    public void setDepart(ArrayList<Department> depart) {
        this.depart = depart;
    }

}

//class t1 {
//
//    public static void main(String[] args) {
//        DAO d = new DAO();
//        System.out.println(d.createstID("HF4"));
//    }
//}
