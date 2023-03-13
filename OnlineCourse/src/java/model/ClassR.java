/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author WIN
 */
public class ClassR {

    private String ID;
    private String DepartID;
    private String title;
    private String images;
    private String mentor;
    private String describe;
    private int status;

    public ClassR() {
    }

    public ClassR(String ID, String DepartID, String title, String images) {
        this.ID = ID;
        this.DepartID = DepartID;
        this.title = title;
        this.images = images;
    }

    public ClassR(String ID, String DepartID, String title, String images, String mentor, String describe) {
        this.ID = ID;
        this.DepartID = DepartID;
        this.title = title;
        this.images = images;
        this.mentor = mentor;
        this.describe = describe;
    }

    public ClassR(String ID, String DepartID, String title, int stauts) {
        this.ID = ID;
        this.DepartID = DepartID;
        this.title = title;
        this.status = stauts;
    }

    public ClassR(String ID, String DepartID, String title, String images, String mentor) {
        this.ID = ID;
        this.DepartID = DepartID;
        this.title = title;
        this.images = images;
        this.mentor = mentor;
    }
    
    
    
    

    public int getStatus() {
        return status;
    }

    public void setStauts(int stauts) {
        this.status = stauts;
    }
    

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDepartID() {
        return DepartID;
    }

    public void setDepartID(String DepartID) {
        this.DepartID = DepartID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "ClassR{" + "ID=" + ID + ", DepartID=" + DepartID + ", title=" + title + ", images=" + images + '}';
    }

}

