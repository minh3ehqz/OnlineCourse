/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author WIN
 */
public class Department {

    private String ID;
    private String name;
    private String title;
    private String images;

    public Department() {
    }

    public Department(String ID, String name, String title, String images) {
        this.ID = ID;
        this.name = name;
        this.title = title;
        this.images = images;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Department{" + "ID=" + ID + ", name=" + name + ", title=" + title + ", images=" + images + '}';
    }

   
}
