/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author WIN
 */
public class Condition {
    private String classId;
    private String conditionId;

    public Condition() {
    }

    public Condition(String classId, String conditionId) {
        this.classId = classId;
        this.conditionId = conditionId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getConditionId() {
        return conditionId;
    }

    public void setConditionId(String conditionId) {
        this.conditionId = conditionId;
    }

    @Override
    public String toString() {
        return "Condition{" + "classId=" + classId + ", conditionId=" + conditionId + '}';
    }
    
    
}
