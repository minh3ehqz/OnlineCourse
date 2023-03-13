/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author WIN
 */
public class student {
    private String ID;
    private String IDc;
    private int IDn;
    private String name;
    private boolean gender;
    private String deptID;
    private String phoneNumber;
    private String userName;
    private String passWord;
    private String email;
    private int active;
    private int classst;

    public student() {
    }

    public student(String ID, String name, boolean gender, String deptID, String phoneNumber, String email,int classst) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.deptID = deptID;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.classst = classst;
    }
    
    

    public student(String ID, String name, boolean gender, String deptID, String phoneNumber, String userName, String passWord, String email, int active) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.deptID = deptID;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.active = active;
    }

    public student(String IDc, int IDn, String name,String depid) {
        this.IDc = IDc;
        this.IDn = IDn;
        this.name = name;
        this.deptID=depid;
    }

    public student(String ID,String IDc, int IDn, String name, boolean gender, String deptID, String phoneNumber, String userName, String passWord, String email, int active) {
        this.ID =ID;
        this.IDc = IDc;
        this.IDn = IDn;
        this.name = name;
        this.gender = gender;
        this.deptID = deptID;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.active = active;
    }

    public int getClassst() {
        return classst;
    }

    public void setClassst(int classst) {
        this.classst = classst;
    }
    
    

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public String getIDc() {
        return IDc;
    }

    public void setIDc(String IDc) {
        this.IDc = IDc;
    }

    public int getIDn() {
        return IDn;
    }

    public void setIDn(int IDn) {
        this.IDn = IDn;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDeptId() {
        return deptID;
    }

    public void setDeptID(String deptID) {
        this.deptID = deptID;
    }

    @Override
    public String toString() {
        return "student{" + "IDc=" + IDc + ", IDn=" + IDn + ", name=" + name + ", gender=" + gender + ", deptID=" + deptID + ", phoneNumber=" + phoneNumber + ", userName=" + userName + ", passWord=" + passWord + ", email=" + email + ", active=" + active + '}';
    }
    

}
